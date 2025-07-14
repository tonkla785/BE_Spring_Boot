package com.example.practice_BE.Controllers;

import com.example.practice_BE.DTO.ProductRequestDTO;
import com.example.practice_BE.Entity.ProductEntity;
import com.example.practice_BE.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/service")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody ProductRequestDTO productRequest){
        if(productRequest == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                    "responseStatus", 400,
                    "responseMessage", "ข้อมูลสินค้าไม่ถูกต้อง"
            ));
        }
        if(productRequest.getProductName() == null || productRequest.getProductName().trim().isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                    "responseStatus", 400,
                    "responseMessage", "กรุณาใส่ชื่อสินค้า"
            ));
        }
        if(productRequest.getProductPrice() == null || productRequest.getProductAmount() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                    "responseStatus", 400,
                    "responseMessage", productRequest.getProductPrice() == null ? "กรุณาใส่ราคาสินค้า" : "กรุณาใส่จำนวนสินค้า"
            ));
        }
        try{
            ProductEntity createproduct = productService.createProduct(productRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                    "responseStatus", 200,
                    "responseMessage", "เพิ่มสินค้าสำเร็จ",
                    "data", createproduct
            ));

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "responseStatus", 500,
                    "responseMessage", "เกิดข้อผิดพลาดในระบบ"
            ));
        }
    }

    @GetMapping("/")
    public List<ProductEntity> getAllProduct(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Integer id){
        try {
            ProductEntity product = productService.findById(id);
            if(product == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                        "responseStatus", 404,
                        "responseMessage", "ไม่พบสินค้า"
                ));
            }

            return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                    "responseStatus", 200,
                    "responseMessage", "ค้นหาสำเร็จ",
                    "data", product
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "responseStatus", 500,
                    "responseMessage", "เกิดข้อผิดพลาดในระบบ"
            ));
        }
    }
}
