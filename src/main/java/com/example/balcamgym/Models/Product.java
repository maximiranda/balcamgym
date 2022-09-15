package com.example.balcamgym.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
    private Set<ProductStorage> productsStorage;

    private String name;

    private ProductCategory productCategory;

    private double price;

    private int stock;


    public Product (){}

    public Product(String name, ProductCategory productCategory, double price, int stock) {
        this.name = name;
        this.productCategory = productCategory;
        this.price = price;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Set<ProductStorage> getProductsStorage() {
        return productsStorage;
    }

    public void setProductsStorage(ProductStorage productStorage) {
        productStorage.setProduct(this);
        this.productsStorage.add(productStorage);
    }
}
