package com.example.demo.controller;

import com.example.demo.dto.StockDto;
import com.example.demo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping
    public ResponseEntity getListStock() {
        return ResponseEntity.ok(stockService.getStockAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getByProductId(@PathVariable int id) {
        return ResponseEntity.ok(stockService.getByProductId(id));
    }

    @PostMapping(value = "/saveAll")
    public ResponseEntity saveAllStock(@RequestBody List<StockDto>stockDtos){
        return ResponseEntity.ok(stockService.saveStockAll(stockDtos));
    }

    @PostMapping(value = "/{productId}")
    public ResponseEntity addStock(@RequestBody StockDto stockDto, @PathVariable int productId) {
        return ResponseEntity.ok(stockService.createStock(stockDto, productId));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateStock(@RequestBody StockDto stockDto, @PathVariable int id) {
        return ResponseEntity.ok(stockService.updateStock(stockDto, id));
    }
}
