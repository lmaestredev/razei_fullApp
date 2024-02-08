package com.ecommerce.razei_fullapp.product.domain.model;

public class ProductQuery {

    private String id;
    private String name;
    private String code;
    private double price;
    private Integer quantity;
    private String type;
    private String description;

    public ProductQuery() {
    }

    public ProductQuery(String id, String name, String code, double price, Integer quantity, String type, String description) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
