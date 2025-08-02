package com.example.practice_BE.Repository;

import com.example.practice_BE.Entity.SaleDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleDetailRepository extends JpaRepository <SaleDetailEntity, Long>{

    @Query("SELECT SUM(d.quantitySale) FROM SaleDetailEntity d WHERE d.productId.productId = :productId")
    Integer getTotalQuantityByProduct(@Param("productId") Long productId);

}
