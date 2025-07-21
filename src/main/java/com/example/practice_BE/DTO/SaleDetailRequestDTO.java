package com.example.practice_BE.DTO;

public class SaleDetailRequestDTO {

    private Long productId;
    private Integer quantity;

    public SaleDetailRequestDTO(Long productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        if (quantity == null) {
            throw new IllegalArgumentException("Quantity can not be null");
        }
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        if (productId == null) {
            throw new IllegalArgumentException("Product ID is required.");
        }
        this.productId = productId;
    }
}
