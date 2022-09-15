package com.example.balcamgym.Services.Implements;

import com.example.balcamgym.Models.Client;
import com.example.balcamgym.Models.Product;
import com.example.balcamgym.Repositories.ProductRepository;
import com.example.balcamgym.Services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Product findByName(String name){return productRepository.findByName(name);}

    @Override
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

}

