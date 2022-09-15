package com.example.balcamgym.Services.Implements;

import com.example.balcamgym.Models.Product;
import com.example.balcamgym.Repositories.ProductRepository;
import com.example.balcamgym.Services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServicesImplements implements ProductServices {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findProductById(long id) {
        return productRepository.findProductById(id);
    }
}

