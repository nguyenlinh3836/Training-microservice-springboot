package com.example.demo.dto;

import javax.persistence.Id;


public class ProductDto {
    @Id
    private int id;
    private String productName;
    private double price;
//    private StockDto stockDto;

    public ProductDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public StockDto getStockDto() {
//        return stockDto;
//    }
//
//    public void setStockDto(StockDto stockDto) {
//        this.stockDto = stockDto;
//    }
}
