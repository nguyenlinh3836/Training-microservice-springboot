package com.example.demo.service;

import com.example.demo.dto.StockDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StockService {
    List<StockDto> getStockAll();

    List<StockDto> saveStockAll(List<StockDto> stockDtos);

    StockDto createStock(StockDto stockDto, int productId);

    StockDto updateStock(StockDto stockDto, int id);

    StockDto getByProductId(int id);

    void deleteStock(int id);
}
