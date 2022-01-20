package com.example.demo.repository;

import com.example.demo.model.Order;
import com.example.demo.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepo extends JpaRepository<OrderDetail,Integer> {
    List<OrderDetail> getByOrder(Order order);
}
