package com.example.demo.services;

import com.example.demo.mongo.documents.Employees;


public interface EmployeesMongoService {
    Employees findByEmployeeID(Integer id);
}
