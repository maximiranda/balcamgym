package com.example.balcamgym.Services;

import com.example.balcamgym.Models.Product;

public interface ProductServices {
    public void saveProduct(Product product);
    public Product findProductById(long id);
}
