package com.example.demo.services.impl;

import com.example.demo.mongo.documents.OrderDetails;
import com.example.demo.mongo.repository.OrderDetailsRepository;
import com.example.demo.services.OrderDetailMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderDetailsMongoServiceImpl implements OrderDetailMongoService{

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    public List<OrderDetails> findByOrderID(Integer orderId) {
        return orderDetailsRepository.findAllByOrOrderID(orderId);
    }
}
