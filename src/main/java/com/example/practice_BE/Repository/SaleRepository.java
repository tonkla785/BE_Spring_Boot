package com.example.practice_BE.Repository;

import com.example.practice_BE.Entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository <SaleEntity, Long>{

    List<SaleEntity> findBySaleNameContainingIgnoreCase(String keyword);

    @Query("SELECT SUM(s.saleTotal) FROM SaleEntity s WHERE s.saleDate >= :startDate")
    Double getTotalSalesLast30Days(@Param("startDate") Timestamp startDate);

    @Query("SELECT SUM(s.saleTotal) FROM SaleEntity s WHERE s.saleDate BETWEEN :startDate AND :endDate")
    Double getTotalSalesBetween(@Param("startDate") LocalDateTime startDate,
                                @Param("endDate") LocalDateTime endDate);
}
