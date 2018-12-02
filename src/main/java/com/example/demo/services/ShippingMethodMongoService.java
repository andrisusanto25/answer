package com.example.demo.services;

import com.example.demo.mongo.documents.ShippingMethods;


public interface ShippingMethodMongoService {

    ShippingMethods findByShppingMethodId(Integer shippingMethodId);
}
