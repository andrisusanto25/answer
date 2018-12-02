package com.example.demo.mongo.repository;

import com.example.demo.mongo.documents.OrderDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderDetailsRepository extends MongoRepository<OrderDetails, String> {

    List<OrderDetails> findAllByOrOrderID(Integer orderId);
}
