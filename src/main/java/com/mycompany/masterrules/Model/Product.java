/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.masterrules.Model;

import java.math.BigDecimal;

/**
 *
 * @author alexs
 */
public class Product {
    private long ID;
    private String productName;
    private String productType;
    private BigDecimal price;
    private BigDecimal VIPprice;

    public Product(long id, String productName, String productType, BigDecimal price, BigDecimal VIPprice) {
        this.ID = id;
        this.productName = productName;
        this.productType = productType;
        this.price = price;
        this.VIPprice = VIPprice;
    }

    public long getID() {
        return ID;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getVIPprice() {
        return VIPprice;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setVIPprice(BigDecimal VIPprice) {
        this.VIPprice = VIPprice;
    }
}
