package com.example.demo.mongo.repository;

import com.example.demo.mongo.documents.Customers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomersRepository extends MongoRepository<Customers, String>{

    Customers findByCustomerID(Integer customerId);
}
