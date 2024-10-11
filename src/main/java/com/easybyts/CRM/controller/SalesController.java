package com.easybyts.CRM.controller;

import com.easybyts.CRM.model.Sales;
import com.easybyts.CRM.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @PostMapping
    public ResponseEntity<Sales> createSales( @RequestBody Sales sales){
        Sales saveSales = salesService.saveSales(sales);
        return ResponseEntity.ok(saveSales);
    }
    @GetMapping
    public List<Sales> getAllSales(){
        return salesService.getAllSales();

    }
    @GetMapping("/{id}")
    public ResponseEntity<Sales> getSalesById( @PathVariable Long id ){
        Sales sales = salesService.getSalesById(id);
        return ResponseEntity.ok(sales);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSales( @PathVariable Long id){
        salesService.deleteSales(id);
        return ResponseEntity.noContent().build();
    }

}
