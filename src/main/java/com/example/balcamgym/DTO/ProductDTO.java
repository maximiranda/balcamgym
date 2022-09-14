package com.example.balcamgym.DTO;

import com.example.balcamgym.Models.Product;
import com.example.balcamgym.Models.ProductCategory;

public class ProductDTO {
    private long id;
    private String name;
    private ProductCategory productCategory;
    private double price;
    private int stock;

    public ProductDTO(){}

    public ProductDTO(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.productCategory = product.getProductCategory();
        this.price = product.getPrice();
        this.stock = product.getStock();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}
