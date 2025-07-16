package com.example.practice_BE.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductRequestDTO {

    @NotBlank(message = "กรุณาใส่ชื่อสินค้า")
    private String productName;
    @NotNull(message = "กรุณาใส่ราคาสินค้า")
    private Double productPrice;
    @NotNull(message = "กรุณาใส่จำนวนสินค้า")
    private Integer productAmount;

    public ProductRequestDTO(String productName, Double productPrice, Integer productAmount) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productAmount = productAmount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Integer productAmount) {
        this.productAmount = productAmount;
    }
}
