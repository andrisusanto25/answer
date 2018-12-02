package com.example.demo.services;

import com.example.demo.mongo.documents.OrderDetails;

import java.util.List;


public interface OrderDetailMongoService {

    List<OrderDetails> findByOrderID(Integer orderId);
}
