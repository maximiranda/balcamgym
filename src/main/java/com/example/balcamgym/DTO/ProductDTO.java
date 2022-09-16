package com.example.balcamgym.DTO;

import com.example.balcamgym.Models.Product;
import com.example.balcamgym.Models.ProductCategory;

public class ProductDTO {
    private long id;
    private String name,description,urlImg;
    private ProductCategory productCategory;
    private double price;
    private int stock;

    public ProductDTO(){}

    public ProductDTO(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.urlImg = product.getUrlImg();
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

    public String getDescription() {return description;}

    public String getUrlImg() {return urlImg;}

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
