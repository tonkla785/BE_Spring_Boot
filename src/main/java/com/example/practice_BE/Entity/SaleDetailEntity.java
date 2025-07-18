package com.example.practice_BE.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "sale_details")
public class SaleDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_detail_id")
    private Long saleDetailId;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    @JsonIgnoreProperties("saleDetails")
    private SaleEntity saleId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties("saleDetails")
    private ProductEntity productId;

    @JsonProperty("quantitySale")
    @Column(name = "quantity")
    private Integer quantitySale;

    @JsonProperty("priceSale")
    @Column(name = "price")
    private Double priceSale;

    public Long getSaleDetailId() {
        return saleDetailId;
    }

    public void setSaleDetailId(Long saleDetailId) {
        this.saleDetailId = saleDetailId;
    }

    public SaleEntity getSaleId() {
        return saleId;
    }

    public void setSaleId(SaleEntity saleId) {
        this.saleId = saleId;
    }

    public ProductEntity getProductId() {
        return productId;
    }

    public void setProductId(ProductEntity productId) {
        this.productId = productId;
    }

    public Integer getQuantitySale() {
        return quantitySale;
    }

    public void setQuantitySale(Integer quantitySale) {
        this.quantitySale = quantitySale;
    }

    public Double getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(Double priceSale) {
        this.priceSale = priceSale;
    }
}
