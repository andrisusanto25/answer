package com.example.demo.services.impl;

import com.example.demo.mongo.documents.Customers;
import com.example.demo.mongo.repository.CustomersRepository;
import com.example.demo.services.CustomersMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomersMongoServiceImpl implements CustomersMongoService {

    @Autowired
    private CustomersRepository customersRepository;

    @Override
    public Customers findByCustomerId(Integer customerId) {
        return customersRepository.findByCustomerID(customerId);
    }
}
