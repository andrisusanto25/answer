package com.example.demo.services;

import com.example.demo.mongo.documents.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface OrderMongoService {

    Page<Orders> findAll(Pageable pageable);
}
