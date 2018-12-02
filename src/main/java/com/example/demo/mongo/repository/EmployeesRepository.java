package com.example.demo.mongo.repository;

import com.example.demo.mongo.documents.Employees;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeesRepository extends MongoRepository<Employees, String> {

    Employees findAllByEmployeeID(Integer EmployeeID);

    Employees findByEmployeeID(Integer id);
}
