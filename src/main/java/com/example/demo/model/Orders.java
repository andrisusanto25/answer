package com.example.demo.model;

import com.example.demo.base.BaseModel;

import java.util.Date;
import java.util.List;

public class Orders extends BaseModel {
    private Integer orderId;
    private Integer customerId;
    private Integer employeeId;
    private Date orderDate;
    private String purchaseOrderNumber;
    private Date shipDate;
    private Integer shippingMethodId;
    private Integer freightCharge;
    private Integer taxes;
    private Character paymentReceived;
    private String comment;
    private Customers customers;
    private Employees employees;
    private ShippingMethods shippingMethods;
    private List<OrderDetails> orderDetails;
    private Integer subTotal;
    private Integer orderTotal;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public Integer getShippingMethodId() {
        return shippingMethodId;
    }

    public void setShippingMethodId(Integer shippingMethodId) {
        this.shippingMethodId = shippingMethodId;
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

    public Character getPaymentReceived() {
        return paymentReceived;
    }

    public void setPaymentReceived(Character paymentReceived) {
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
        return getSubTotal() + taxes + freightCharge;
    }
}
