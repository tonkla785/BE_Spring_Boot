package com.example.practice_BE.Repository;

import com.example.practice_BE.Entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository <SaleEntity, Long>{
    List<SaleEntity> findBySaleNameContainingIgnoreCase(String keyword);
}
