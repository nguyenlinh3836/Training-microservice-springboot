package com.example.demo.controller;

import com.example.demo.dto.ProductDto;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity listProduct(@RequestParam(name = "page") int page,@RequestParam(name = "size") int size) {
        return ResponseEntity.ok(productService.listAllProduct(page,size));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getProductById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.getProductById(id));
    }

    @PostMapping
    public ResponseEntity insertProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.insertProduct(productDto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateProduct(@RequestBody ProductDto productDto, @PathVariable int id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.updateProduct(productDto,id));
    }
//    @PutMapping(value = "/updateSupplier")
//    public ResponseEntity updateProduct(@RequestParam int productId, @RequestParam int supplierId) {
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body();
//    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id) {
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Product has been delete");
    }


}
