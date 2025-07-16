package com.example.practice_BE.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @JsonProperty("productDate")
    @Column(name = "product_date")
    private Timestamp productDate;

    @JsonProperty("productName")
    @Column(name = "product_name")
    private String productName;

    @JsonProperty("productPrice")
    @Column(name = "product_price")
    private Double productPrice;

    @JsonProperty("productAmount")
    @Column(name = "product_amount")
    private Integer productAmount;

    @JsonProperty("tokenId")
    @Column(name = "token_id")
    private String tokenId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Timestamp getProductDate() {
        return productDate;
    }

    public void setProductDate(Timestamp productDate) {
        this.productDate = productDate;
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

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }
}
