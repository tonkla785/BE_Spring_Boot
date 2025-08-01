package com.example.practice_BE.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "sales")
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private Long saleId;

    @JsonProperty("saleTokenId")
    @Column(name = "sale_token_id")
    private String saleTokenId;

    @JsonProperty("saleDate")
    @Column(name = "sale_date")
    private Timestamp saleDate;

    @JsonProperty("saleName")
    @Column(name = "sale_name")
    private String saleName;

    @JsonProperty("saleTotal")
    @Column(name = "sale_total")
    private Double saleTotal;

    @OneToMany(mappedBy = "saleId", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<SaleDetailEntity> saleDetails;

    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName;
    }

    public Double getSaleTotal() {
        return saleTotal;
    }

    public void setSaleTotal(Double saleTotal) {
        this.saleTotal = saleTotal;
    }

    public List<SaleDetailEntity> getSaleDetails() {
        return saleDetails;
    }

    public void setSaleDetails(List<SaleDetailEntity> saleDetails) {
        this.saleDetails = saleDetails;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public String getSaleTokenId() {
        return saleTokenId;
    }

    public void setSaleTokenId(String saleTokenId) {
        this.saleTokenId = saleTokenId;
    }

    public Timestamp getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Timestamp saleDate) {
        this.saleDate = saleDate;
    }
}
