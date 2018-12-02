package com.example.demo.services.impl;

import com.example.demo.mongo.documents.Employees;
import com.example.demo.mongo.repository.EmployeesRepository;
import com.example.demo.services.EmployeesMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmployeesMongoServiceImpl implements EmployeesMongoService {

    @Autowired
    private EmployeesRepository employeesRepository;

    @Override
    public Employees findByEmployeeID(Integer id) {
        return employeesRepository.findByEmployeeID(id);
    }
}
