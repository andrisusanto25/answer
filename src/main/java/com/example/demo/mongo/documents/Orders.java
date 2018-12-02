package com.example.demo.mongo.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Orders {
    @Id
    private String id;
    private Integer orderID;
    private Integer customerID;
    private Integer employeeID;
    private String orderDate;
    private String purchaseOrderNumber;
    private String shipDate;
    private Integer shippingMethodID;
    private Integer freightCharge;
    private Integer taxes;
    private String paymentReceived;
    private String comment;
    private Customers customers;
    private Employees employees;
    private ShippingMethods shippingMethods;
    private List<OrderDetails> orderDetails;
    private Integer subTotal;
    private Integer orderTotal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public Integer getShippingMethodID() {
        return shippingMethodID;
    }

    public void setShippingMethodID(Integer shippingMethodID) {
        this.shippingMethodID = shippingMethodID;
    }

    public Integer getFreightCharge() {
        return freightCharge;
    }

    public void setFreightCharge(Integer freightCharge) {
        this.freightCharge = freightCharge;
    }

    public Integer getTaxes() {
        return taxes;
    }

    public void setTaxes(Integer taxes) {
        this.taxes = taxes;
    }

    public String getPaymentReceived() {
        return paymentReceived;
    }

    public void setPaymentReceived(String paymentReceived) {
        this.paymentReceived = paymentReceived;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public ShippingMethods getShippingMethods() {
        return shippingMethods;
    }

    public void setShippingMethods(ShippingMethods shippingMethods) {
        this.shippingMethods = shippingMethods;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Integer getSubTotal() {
        Integer total = 0;
        if (null != orderDetails) {
            for (OrderDetails orderDetail : orderDetails) {
                total += orderDetail.getExtendedPrice();
            }
        }
        return total;
    }

    public Integer getOrderTotal() {
        freightCharge = null != freightCharge ? freightCharge : 0;
        taxes = null != taxes ? taxes : 0;
        Integer subTotal = null != getSubTotal() ? getSubTotal() : 0;
        return subTotal + taxes + freightCharge;
    }
}
