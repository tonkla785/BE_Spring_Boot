package com.example.practice_BE.Service;

import com.example.practice_BE.Repository.SaleDetailRepository;
import com.example.practice_BE.Repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class SaleDetailService {

    private final SaleDetailRepository saleDetailRepository;
    private final SaleRepository saleRepository;

    @Autowired
    public SaleDetailService(SaleDetailRepository saleDetailRepository,
                             SaleRepository saleRepository) {
        this.saleDetailRepository = saleDetailRepository;
        this.saleRepository = saleRepository;
    }

    //Get Total sale product
    public int getTotalQuantityByProduct(Long productId) {
        try{
            Integer total = saleDetailRepository.getTotalQuantityByProduct(productId);
            return total != null ? total : 0;
        } catch (Exception e) {
            throw new RuntimeException("Error while get total sale product id: "+productId,e);
        }
    }

    //Get total sale summary Month
    public double getTotalSalesLast30Days() {
        try {
            LocalDateTime thirtyDaysAgo = LocalDateTime.now().minusDays(30);
            Timestamp startDate = Timestamp.valueOf(thirtyDaysAgo);

            Double total = saleRepository.getTotalSalesLast30Days(startDate);
            return total != null ? total : 0.0;
        } catch (Exception e) {
            throw new RuntimeException("Error while calculating last 30 days sales total", e);
        }
    }

    //Get total sale by select
    public double getTotalSalesBetween(LocalDateTime start, LocalDateTime end) {
        try {
            Double total = saleRepository.getTotalSalesBetween(start, end);
            return total != null ? total : 0.0;
        } catch (Exception e) {
            throw new RuntimeException("Error while calculating sales total between range", e);
        }
    }
}
