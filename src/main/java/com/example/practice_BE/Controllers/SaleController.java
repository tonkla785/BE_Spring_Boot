package com.example.practice_BE.Controllers;

import com.example.practice_BE.DTO.SaleDetailRequestDTO;
import com.example.practice_BE.Entity.SaleEntity;
import com.example.practice_BE.Service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SaleController {

    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping("/sales")
    public ResponseEntity<?> createSale(@RequestBody List<SaleDetailRequestDTO> saleDetails) {
        try {
            SaleEntity sale = saleService.createSale(saleDetails);
            return ResponseEntity.ok(sale); // หรือส่ง DTO กลับก็ได้
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("เกิดข้อผิดพลาดขณะทำรายการ: " + e.getMessage());
        }
    }
}

