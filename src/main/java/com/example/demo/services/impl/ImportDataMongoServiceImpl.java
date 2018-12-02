package com.example.demo.services.impl;

import com.example.demo.services.ImportDataMongoService;
import org.springframework.stereotype.Service;


@Service
public class ImportDataMongoServiceImpl implements ImportDataMongoService {

    @Override
    public String importCustomers(String mongoimportPath) {
        Runtime runtime = Runtime.getRuntime();
        StringBuilder result = new StringBuilder();
        String command = mongoimportPath +" -d demo -c customers --type csv --file src/main/resources/mongo/Customers.csv --headerline";
        result.append(executeImport(runtime ,command,result));
        result.append("customers ");
        result.append("Finish");
        return result.toString();
    }

    @Override
    public String importEmployees(String mongoimportPath) {
        Runtime runtime = Runtime.getRuntime();
        StringBuilder result = new StringBuilder();
        String command = mongoimportPath +" -d demo -c employees --type csv --file src/main/resources/mongo/Employees.csv --headerline";
        result.append(executeImport(runtime ,command,result));
        result.append("employees ");
        result.append("Finish");
        return result.toString();
    }

    @Override
    public String importOders(String mongoimportPath) {
        Runtime runtime = Runtime.getRuntime();
        StringBuilder result = new StringBuilder();
        String command = mongoimportPath +" -d demo -c orders --type csv --file src/main/resources/mongo/Orders.csv --headerline";
        result.append(executeImport(runtime ,command,result));
        result.append("orders ");
        result.append("Finish");
        return result.toString();
    }

    @Override
    public String importOrderDetails(String mongoimportPath) {
        Runtime runtime = Runtime.getRuntime();
        StringBuilder result = new StringBuilder();
        String command = mongoimportPath +" -d demo -c order_details --type csv --file src/main/resources/mongo/OrderDetails.csv --headerline";
        result.append(executeImport(runtime ,command,result));
        result.append("order details ");
        result.append("Finish");
        return result.toString();
    }

    @Override
    public String importProducts(String mongoimportPath) {
        Runtime runtime = Runtime.getRuntime();
        StringBuilder result = new StringBuilder();
        String command = mongoimportPath +" -d demo -c products --type csv --file src/main/resources/mongo/Products.csv --headerline";
        result.append(executeImport(runtime ,command,result));
        result.append("products ");
        result.append("Finish");
        return result.toString();
    }

    @Override
    public String importShippingMethods(String mongoimportPath) {
        Runtime runtime = Runtime.getRuntime();
        StringBuilder result = new StringBuilder();
        String command = mongoimportPath +" -d demo -c shipping_methods --type csv --file src/main/resources/mongo/ShippingMethods.csv --headerline";
        result.append(executeImport(runtime ,command,result));
        result.append("shipping methods ");
        result.append("Finish");
        return result.toString();
    }

    private String executeImport(Runtime runtime, String command, StringBuilder response) {
        Process process = null;
        try {
            process = runtime.exec(command);
            response.append("Reading csv into Database ");
        } catch (Exception e){
            response.append("\n");
            response.append("Error executing " + command + e.toString());
            response.append("\n");
            return response.toString();
        }
        return response.toString();
    }
}
