package com.example.practice_BE.Service;

import com.example.practice_BE.Entity.ProductEntity;
import com.example.practice_BE.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.UUID;

@Service
public class ProductService{

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity createProduct(ProductEntity productEntity) {
        validateProduct(productEntity);
        try{
            productEntity.setProductDate(new Timestamp(System.currentTimeMillis()));
            productEntity.setTokenId(UUID.randomUUID().toString());
            return productRepository.save(productEntity);
        } catch (Exception e) {
            throw new RuntimeException("Error while saving",e);
        }
    }

    private void validateProduct(ProductEntity productEntity){
        if(productEntity == null){
            throw new IllegalArgumentException("Product cannot be null");
        }
        if(productEntity.getProductName() == null || productEntity.getProductName().trim().isEmpty()){
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }
        if(productEntity.getProductPrice() == null){
            throw new IllegalArgumentException("Product price cannot be null or empty");
        }
        if(productEntity.getProductAmount() == null){
            throw new IllegalArgumentException("Product amount cannot be null or empty");
        }
    }
}
