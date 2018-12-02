package com.example.demo.mongo.repository;

import com.example.demo.mongo.documents.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductsRepository extends MongoRepository<Products, String> {

    Products findByProductID(Integer productId);
}
