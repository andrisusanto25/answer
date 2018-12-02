package com.example.demo.mongo.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("shipping_methods")
public class ShippingMethods {
    @Id
    private String id;
    private Integer shippingMethodID;
    private String shippingMethod;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getShippingMethodID() {
        return shippingMethodID;
    }

    public void setShippingMethodID(Integer shippingMethodID) {
        this.shippingMethodID = shippingMethodID;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
}
