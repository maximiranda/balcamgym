package com.example.balcamgym.DTO;

import com.example.balcamgym.Models.Bill;
import com.example.balcamgym.Models.Product;
import com.example.balcamgym.Models.ProductStorage;

import java.util.Set;
import java.util.stream.Collectors;

public class ProductStorageDTO {
    private long id;
    private Product product;



    public ProductStorageDTO(){}

    public ProductStorageDTO(ProductStorage productStorage){
        this.id = productStorage.getId();
        this.product = productStorage.getProduct();
    }

    public long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }
}
