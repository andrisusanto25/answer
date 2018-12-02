package com.example.demo.mongo.repository;

import com.example.demo.mongo.documents.ShippingMethods;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShippingMethodsRepository extends MongoRepository<ShippingMethods, String> {
    ShippingMethods findByShippingMethodID(Integer shippingMethodId);
}
