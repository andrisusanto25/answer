package com.example.demo.services;


public interface ImportDataMongoService {

    String importCustomers(String mongoimportPath);

    String importEmployees(String mongoimportPath);

    String importOders(String mongoimportPath);

    String importOrderDetails(String mongoimportPath);

    String importProducts(String mongoimportPath);

    String importShippingMethods(String mongoimportPath);
}
