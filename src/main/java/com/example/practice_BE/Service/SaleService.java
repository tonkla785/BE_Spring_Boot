package com.example.practice_BE.Service;

import com.example.practice_BE.DTO.ProductRequestDTO;
import com.example.practice_BE.DTO.SaleDetailRequestDTO;
import com.example.practice_BE.Entity.ProductEntity;
import com.example.practice_BE.Entity.SaleDetailEntity;
import com.example.practice_BE.Entity.SaleEntity;
import com.example.practice_BE.Repository.SaleDetailRepository;
import com.example.practice_BE.Repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final SaleDetailRepository saleDetailRepository;
    private final ProductService productService;

    @Autowired
    public SaleService(SaleRepository saleRepository,
                       SaleDetailRepository saleDetailRepository,
                       ProductService productService
                       ){
        this.saleRepository = saleRepository;
        this.saleDetailRepository = saleDetailRepository;
        this.productService = productService;
    }

    @Transactional
    public SaleEntity createSale(List<SaleDetailRequestDTO> saleDetails){
        try {
            double total = 0.0;
            validateSaleDetail(saleDetails);

            SaleEntity sale = new SaleEntity();
            sale.setSaleTokenId(UUID.randomUUID().toString());
            sale.setSaleDate(new Timestamp(System.currentTimeMillis()));
            sale.setSaleTotal(total);
            saleRepository.save(sale);

            for (SaleDetailRequestDTO dto : saleDetails) {
                ProductEntity product = productService.findById(dto.getProductId());
                System.out.println(product);

                product.setProductAmount(product.getProductAmount()-dto.getQuantity());
                System.out.println("กำลังลด stock: " + product.getProductName());
                System.out.println("จำนวนคงเหลือ: " + product.getProductAmount());
                System.out.println("จำนวนที่ขาย: " + dto.getQuantity());
                productService.updateProduct(product.getProductId(),
                        new ProductRequestDTO(
                                product.getProductName(),
                                product.getProductPrice(),
                                product.getProductAmount()
                            )
                        );

                SaleDetailEntity detail = new SaleDetailEntity();
                detail.setSaleId(sale);
                detail.setProductId(product);
                detail.setQuantitySale(dto.getQuantity());


                double price = product.getProductPrice() * dto.getQuantity();
                detail.setPriceSale(price);
                total += price;
                System.out.println(total);

                saleDetailRepository.save(detail);
            }

            sale.setSaleTotal(total);
            saleRepository.save(sale);
            return sale;
        }catch (IllegalArgumentException | NoSuchElementException e) {
            throw e;
        } catch (Exception e){
            throw new RuntimeException("Error while Ordering",e);
        }
    }

    public SaleEntity getSaleById(Long id) {
        SaleEntity sale = saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sale not found"));

        // Force fetch saleDetails
        sale.getSaleDetails().size(); // บังคับให้ Hibernate ดึงข้อมูลจาก DB

        return sale;
    }

    private void validateSaleDetail(List<SaleDetailRequestDTO> saleDetails){
        for (SaleDetailRequestDTO dto : saleDetails) {
            ProductEntity product = productService.findById(dto.getProductId());

            if (product == null) {
                throw new IllegalArgumentException("Product ID " + dto.getProductId() + " ไม่พบในระบบ");
            }

            if (dto.getQuantity() <= 0) {
                throw new IllegalArgumentException("จำนวนที่สั่งซื้อของสินค้า " + product.getProductName() + " ต้องมากกว่า 0");
            }

            if (product.getProductAmount() < dto.getQuantity()) {
                throw new IllegalArgumentException("Stock ไม่พอสำหรับสินค้า " + product.getProductName() +
                        " (เหลืออยู่: " + product.getProductAmount() + ")");
            }
        }
    }
}
