package com.example.practice_BE.DTO;

import jakarta.validation.constraints.NotNull;

public class SaleDetailRequestDTO {

    @NotNull(message = "กรุณาเลือกสินค้า")
    private Long productId;
    @NotNull(message = "กรุณาใส่จำนวนสินค้า")
    private Integer quantity;

    public SaleDetailRequestDTO(Long productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
