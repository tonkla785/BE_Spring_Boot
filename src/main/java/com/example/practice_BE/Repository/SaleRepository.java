package com.example.practice_BE.Repository;

import com.example.practice_BE.Entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository <SaleEntity, Long>{
}
