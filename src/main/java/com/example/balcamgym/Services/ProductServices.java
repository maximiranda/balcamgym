package com.example.balcamgym.Services;

import com.example.balcamgym.Models.Product;

import java.util.List;

public interface ProductServices {
    public void saveProduct(Product product);
    public Product findProductById(long id);

    public Product findByName(String name);

    public List<Product> getAllProducts();

}
