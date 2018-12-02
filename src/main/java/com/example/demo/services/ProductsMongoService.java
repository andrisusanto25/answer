package com.example.demo.services;

import com.example.demo.mongo.documents.Products;


public interface ProductsMongoService {

    Products findByProductId(Integer productId);
}
