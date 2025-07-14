package com.example.practice_BE.Service;

import com.example.practice_BE.DTO.ProductRequestDTO;
import com.example.practice_BE.Entity.ProductEntity;
import com.example.practice_BE.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService{

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity createProduct(ProductRequestDTO productRequest) {
        validateProduct(productRequest);
        try{
            ProductEntity productEntity = new ProductEntity();
            productEntity.setProductName(productRequest.getProductName());
            productEntity.setProductPrice(productRequest.getProductPrice());
            productEntity.setProductAmount(productRequest.getProductAmount());
            productEntity.setProductDate(new Timestamp(System.currentTimeMillis()));
            productEntity.setTokenId(UUID.randomUUID().toString());
            return productRepository.save(productEntity);
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
    public ProductEntity findById(Integer id){
        try {
            Optional<ProductEntity> result = productRepository.findById(id);
            ProductEntity data = null;
            if (result.isPresent()) {
                data = result.get();
            }
            return data;
        }catch (Exception e){
            throw new RuntimeException("Error while Searching",e);
        }
    }

    private void validateProduct(ProductRequestDTO productRequest){
        if(productRequest == null){
            throw new IllegalArgumentException("Product cannot be null");
        }
        if(productRequest.getProductName() == null || productRequest.getProductName().trim().isEmpty()){
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }
        if(productRequest.getProductPrice() == null){
            throw new IllegalArgumentException("Product price cannot be null or empty");
        }
        if(productRequest.getProductAmount() == null){
            throw new IllegalArgumentException("Product amount cannot be null or empty");
        }
    }
}
