package com.example.practice_BE.Controllers;

import com.example.practice_BE.Entity.ProductEntity;
import com.example.practice_BE.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ProductEntity addProduct(@RequestBody ProductEntity productEntity){
        return productService.createProduct(productEntity);
    }
}
