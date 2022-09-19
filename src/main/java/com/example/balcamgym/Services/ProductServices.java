package com.example.balcamgym.Services;

import com.example.balcamgym.Models.Product;
import com.example.balcamgym.Models.ProductStorage;

import java.util.List;

public interface ProductServices {
    public void saveProduct(Product product);
    public Product findProductById(long id);

    public Product findByName(String name);

    public List<Product> findAllProductsById(List<Long> ids);

    public List<Product> findAllProducts();

}
