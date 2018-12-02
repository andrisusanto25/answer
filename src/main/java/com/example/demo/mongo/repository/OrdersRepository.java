package com.example.demo.mongo.repository;

import com.example.demo.mongo.documents.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrdersRepository extends MongoRepository<Orders, String> {
}
