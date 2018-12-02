package com.example.demo.services;

import com.example.demo.model.Orders;

import java.util.List;


public interface OrderService {

    List<Orders> findOrders(Orders orders);
}
