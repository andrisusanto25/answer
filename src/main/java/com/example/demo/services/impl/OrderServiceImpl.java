package com.example.demo.services.impl;

import com.example.demo.dao.OrdersMapper;
import com.example.demo.model.Orders;
import com.example.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> findOrders(Orders orders) {
        return ordersMapper.selectOrdersPage(orders);
    }
}
