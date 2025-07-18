package com.example.practice_BE.Service;

import com.example.practice_BE.Entity.SaleDetailEntity;
import com.example.practice_BE.Repository.SaleDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleDetailService {

    private final SaleDetailRepository saleDetailRepository;

    @Autowired
    public SaleDetailService(SaleDetailRepository saleDetailRepository) {
        this.saleDetailRepository = saleDetailRepository;
    }

    public SaleDetailEntity save(SaleDetailEntity detail) {
        return saleDetailRepository.save(detail);
    }

    public void delete(Long id) {
        saleDetailRepository.deleteById(id);
    }


    public int getTotalQuantityByProduct(Long productId) {
        return saleDetailRepository.findAll().stream()
                .filter(detail -> detail.getProductId().getProductId().equals(productId))
                .mapToInt(SaleDetailEntity::getQuantitySale)
                .sum();
    }
}
