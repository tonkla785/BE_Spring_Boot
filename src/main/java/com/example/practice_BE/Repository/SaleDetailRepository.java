package com.example.practice_BE.Repository;

import com.example.practice_BE.Entity.SaleDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleDetailRepository extends JpaRepository <SaleDetailEntity, Long>{
}
