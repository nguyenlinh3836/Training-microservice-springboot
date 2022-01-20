package com.example.demo.repository;

import com.example.demo.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepo extends JpaRepository<Stock,Integer> {
    Stock findByProductid(int id);
}
