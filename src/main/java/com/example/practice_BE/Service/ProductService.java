package com.example.practice_BE.Service;

import com.example.practice_BE.DTO.ProductRequestDTO;
import com.example.practice_BE.Entity.ProductEntity;
import com.example.practice_BE.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService{

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Create service
    public ProductEntity createProduct(ProductRequestDTO productRequest) {
        try{
            validateProduct(productRequest);

            ProductEntity productEntity = new ProductEntity();
            productEntity.setProductName(productRequest.getProductName());
            productEntity.setProductPrice(productRequest.getProductPrice());
            productEntity.setProductAmount(productRequest.getProductAmount());
            productEntity.setProductDate(new Timestamp(System.currentTimeMillis()));
            productEntity.setTokenId(UUID.randomUUID().toString());
            return productRepository.save(productEntity);
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error while saving",e);
        }
    }

    //Get All Service
    public List<ProductEntity> findAll(){
        try {
            return productRepository.findAll();
        }catch (Exception e){
            throw new RuntimeException("Error while Searching",e);
        }
    }

    //Get by ID Service
    public ProductEntity findById(Integer id) {
        try {
            return productRepository.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Product with ID " + id + " not found"));
        } catch (NoSuchElementException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error while searching for product", e);
        }
    }

    //Update service
    public ProductEntity updateProduct(Integer id, ProductRequestDTO request) {
        try {
            ProductEntity productEntity = productRepository.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("ไม่พบสินค้า ID: " + id));

            validateProduct(request);

            productEntity.setProductName(request.getProductName());
            productEntity.setProductPrice(request.getProductPrice());
            productEntity.setProductAmount(request.getProductAmount());
            return productRepository.save(productEntity);
        } catch (IllegalArgumentException | NoSuchElementException e) {
            throw e;
        } catch (Exception e){
            throw new RuntimeException("Error while updating product",e);
        }
    }

    //Delete service
    public void deleteProduct(Integer id) {
        try {
            ProductEntity product = productRepository.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("ไม่พบสินค้า ID: " + id));
            productRepository.delete(product);
        } catch (NoSuchElementException e) {
            throw e;
        } catch (Exception e){
        throw new RuntimeException("Error while deleting product",e);
    }
    }

    //Validate
    private void validateProduct(ProductRequestDTO productRequest){
        if(productRequest == null){
            throw new IllegalArgumentException("Product cannot be null");
        }
        if(productRequest.getProductName() == null || productRequest.getProductName().trim().isEmpty()){
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }
        if(productRequest.getProductPrice() == null || productRequest.getProductPrice() < 0){
            throw new IllegalArgumentException("Product price cannot be null or empty or minus");
        }
        if(productRequest.getProductAmount() == null || productRequest.getProductAmount() < 0){
            throw new IllegalArgumentException("Product amount cannot be null or empty or minus");
        }
    }
}
