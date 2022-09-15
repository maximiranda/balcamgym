package com.example.balcamgym.DTO;

import com.example.balcamgym.Models.ProductStorage;

import java.util.Set;
import java.util.stream.Collectors;

public class ProductStorageDTO {
    private long id;
    private ProductDTO product;


    public ProductStorageDTO(){}

    public ProductStorageDTO(ProductStorage productStorage){
        this.id = productStorage.getId();
        this.product = new ProductDTO(productStorage.getProduct());
    }

    public long getId() {
        return id;
    }

    public ProductDTO getProduct() {
        return product;
    }

}
