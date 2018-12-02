package com.example.demo.model;


import com.example.demo.base.BaseModel;

public class Products extends BaseModel {
    private Integer productId;
    private String productName;
    private Integer unitPrice;
    private Character inStock;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Character getInStock() {
        return inStock;
    }

    public void setInStock(Character inStock) {
        this.inStock = inStock;
    }
}
