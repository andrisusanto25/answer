package com.example.demo.services.impl;

import com.example.demo.mongo.documents.ShippingMethods;
import com.example.demo.mongo.repository.ShippingMethodsRepository;
import com.example.demo.services.ShippingMethodMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ShippingMethodMongoServiceImpl implements ShippingMethodMongoService {

    @Autowired
    private ShippingMethodsRepository shippingMethodsRepository;

    public ShippingMethods findByShppingMethodId(Integer shippingMethodId) {
        return shippingMethodsRepository.findByShippingMethodID(shippingMethodId);
    }
}
