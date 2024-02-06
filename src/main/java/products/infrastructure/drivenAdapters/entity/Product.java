package products.infrastructure.drivenAdapters.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Products")
public class Product {

    @Id
    private String id;
    private String name;
    private String code;
    private double price;
    private Integer quantity;
    private String type;
    private String description;

    public Product() {
    }

    public Product(String name, String code, double price, Integer quantity, String type, String description) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
        this.description = description;
    }

    //getters
    public String getId() {
        return id;
    }

    public String getType() {
        return type;
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

    public String getDescription() {
        return description;
    }

    //setters
    public void setType(String type) {
        this.type = type;
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

    public void setDescription(String description) {
        this.description = description;
    }
}
