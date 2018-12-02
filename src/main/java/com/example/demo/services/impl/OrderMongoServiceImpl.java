package com.example.demo.services.impl;

import com.example.demo.mongo.documents.Orders;
import com.example.demo.mongo.repository.OrdersRepository;
import com.example.demo.services.OrderMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderMongoServiceImpl implements OrderMongoService {

    @Autowired
    OrdersRepository ordersRepository;

    @Override
    public Page<Orders> findAll(Pageable pageable) {
        return ordersRepository.findAll(pageable);
    }
}
