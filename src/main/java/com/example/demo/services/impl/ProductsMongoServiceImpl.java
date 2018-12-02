package com.example.demo.services.impl;

import com.example.demo.mongo.documents.Products;
import com.example.demo.mongo.repository.ProductsRepository;
import com.example.demo.services.ProductsMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductsMongoServiceImpl implements ProductsMongoService {

    @Autowired
    private ProductsRepository productsRepository;

    public Products findByProductId(Integer productId) {
        return productsRepository.findByProductID(productId);
    }
}
