package com.easybyts.CRM.service;

import com.easybyts.CRM.model.Sales;
import com.easybyts.CRM.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {

    @Autowired
    private SalesRepository salesRepository;


    public Sales saveSales(Sales sales){
        return salesRepository.save(sales);
    }

    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    public Sales getSalesById(Long id){
        return salesRepository.findById(id).orElse(null);
    }

    public void deleteSales(Long id){
        salesRepository.deleteById(id);
    }
}
