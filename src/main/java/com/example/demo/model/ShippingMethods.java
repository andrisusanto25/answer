package com.example.demo.model;


import com.example.demo.base.BaseModel;

public class ShippingMethods extends BaseModel {
    private Integer shippingMethodId;
    private String shippingMethod;

    public Integer getShippingMethodId() {
        return shippingMethodId;
    }

    public void setShippingMethodId(Integer shippingMethodId) {
        this.shippingMethodId = shippingMethodId;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
}
