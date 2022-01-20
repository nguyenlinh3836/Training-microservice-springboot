package com.example.demo.kafka;

import com.example.demo.dto.StockDto;
import com.example.demo.service.StockService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class listener {
    @Autowired
    private StockService stockService;

    @KafkaListener(topics = "orderTopic", groupId = "group-id")
    public void listener(List<StockDto> stockDtos) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<StockDto> myobj = objectMapper.convertValue(stockDtos, new TypeReference<List<StockDto>>() {
        });
        for (StockDto stockDto : myobj) {
            stockService.updateStock(stockDto, stockDto.getId());
        }
    }
}
