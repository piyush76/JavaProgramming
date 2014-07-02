package com.piyush.learning.vendingmachine;

/**
 * Created by piyush on 6/25/14.
 */
public class Product {

    String productCode;

    String productDesc;

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    long cost ;



}
