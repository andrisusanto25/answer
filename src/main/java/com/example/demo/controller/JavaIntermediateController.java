package com.example.demo.controller;

import com.example.demo.common.CommonConstants;
import com.example.demo.common.JsonListResponse;
import com.example.demo.model.Orders;
import com.example.demo.services.ImportDataSqlService;
import com.example.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The answer java intermediate
 */
@RestController
public class JavaIntermediateController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ImportDataSqlService importDataSqlService;

    @GetMapping("/importCsvToSql")
    public String importCsv() {

        try {
            importDataSqlService.executeImport();
            return "success";
        } catch (Exception e) {
            return "failed with error : " + e.getMessage();
        }
    }

    @GetMapping("/getData")
    public ResponseEntity<JsonListResponse> getData(@RequestParam(value = "page", required = false) Integer page,
                                                    @RequestParam(value = "perPage", required = false) Integer perPage) {

        // Determine pagination
        page = null != page ? page : CommonConstants.ONE;
        page = page - CommonConstants.ONE;
        perPage = null == perPage ? CommonConstants.ONE : perPage;

        Orders orders = new Orders();
        orders.setStartIndex(page * perPage);
        orders.setEndIndex(perPage);
        List<Orders> ordersList =  orderService.findOrders(orders);

        JsonListResponse<Orders> response = new JsonListResponse<>(HttpStatus.OK.value(), "success");
        response.setData(ordersList);
        response.setCurrentPage(page + CommonConstants.ONE);
        response.setPerPage(perPage);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
