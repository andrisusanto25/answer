package com.example.demo.services;

import com.example.demo.mongo.documents.Customers;


public interface CustomersMongoService {

    Customers findByCustomerId(Integer customerId);
}
