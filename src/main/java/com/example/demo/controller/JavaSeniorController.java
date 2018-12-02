package com.example.demo.controller;

import com.example.demo.common.CommonConstants;
import com.example.demo.mongo.documents.OrderDetails;
import com.example.demo.mongo.documents.Orders;
import com.example.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

/**
 * The answer java senior
 */
@RestController
public class JavaSeniorController {

    @Autowired
    private OrderMongoService orderMongoService;

    @Autowired
    private CustomersMongoService customersMongoService;

    @Autowired
    private EmployeesMongoService employeesMongoService;

    @Autowired
    private ShippingMethodMongoService shippingMethodMongoService;

    @Autowired
    private ProductsMongoService productsMongoService;

    @Autowired
    private OrderDetailMongoService orderDetailMongoService;

    @Autowired
    private ImportDataMongoService importDataMongoService;

    /**
     * please define your mongoimport path on below
     */
    private final static String mongoimportPath ="C:/Program Files/MongoDB/Server/3.6/bin/mongoimport";

    @GetMapping("/getDataFlux")
    public Flux<Page<Orders>> getOrders(@RequestParam(value = "page", required = false) Integer page,
                                        @RequestParam(value = "perPage", required = false) Integer perPage) {

        // Determine pagination
        page = null != page ? page : CommonConstants.ONE;
        page = page - CommonConstants.ONE;
        perPage = null == perPage ? CommonConstants.ONE : perPage;
        Integer pageStart = page * perPage;

        Pageable pageable = PageRequest.of(pageStart, perPage);

        Page<Orders> orders = orderMongoService.findAll(pageable);
        for (Orders order : orders) {
            order.setCustomers(customersMongoService.findByCustomerId(order.getCustomerID()));
            order.setEmployees(employeesMongoService.findByEmployeeID(order.getEmployeeID()));
            order.setShippingMethods(shippingMethodMongoService.findByShppingMethodId(order.getShippingMethodID()));
            List<OrderDetails> orderDetails = orderDetailMongoService.findByOrderID(order.getOrderID());
            order.setOrderDetails(orderDetails);

            for (OrderDetails od : order.getOrderDetails()) {
                od.setProducts(productsMongoService.findByProductId(od.getProductID()));
            }
        }
        return Flux.interval(Duration.ofMillis(100)).map(l -> orders).take(1);
    }

    @GetMapping("/importCsvToMongo")
    public String importToMongo(){
        StringBuilder result = new StringBuilder();
        result.append(importDataMongoService.importCustomers(mongoimportPath));
        result.append("\n");
        result.append(importDataMongoService.importEmployees(mongoimportPath));
        result.append("\n");
        result.append(importDataMongoService.importOders(mongoimportPath));
        result.append("\n");
        result.append(importDataMongoService.importOrderDetails(mongoimportPath));
        result.append("\n");
        result.append(importDataMongoService.importProducts(mongoimportPath));
        result.append("\n");
        result.append(importDataMongoService.importShippingMethods(mongoimportPath));
        return result.toString();
    }
}
