package com.estudos.stock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.stock.services.reports.LowStockReportService;
import com.estudos.stock.services.reports.ProductsWithMoreOutputsService;
import com.estudos.stock.shared.dtos.LowStockProductDto;
import com.estudos.stock.shared.dtos.ProductExitReportDto;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private LowStockReportService lowStockReportService;
    @Autowired
    private ProductsWithMoreOutputsService productsWithMoreOutputsService;

    @GetMapping("/low-stock")
    public ResponseEntity<List<LowStockProductDto>> getLowStockProducts() {
        List<LowStockProductDto> lowStockProducts = lowStockReportService.execute();
        return ResponseEntity.ok(lowStockProducts);
    }

    @GetMapping("/most-exited-products")
    public ResponseEntity<List<ProductExitReportDto>> getMostExitedProducts() {
        return ResponseEntity.ok(productsWithMoreOutputsService.execute());
    }
}
