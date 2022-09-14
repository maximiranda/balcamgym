package com.example.balcamgym.DTO;

import com.example.balcamgym.Models.ProductStorage;

import java.util.Set;
import java.util.stream.Collectors;

public class ProductStorageDTO {
    private long id;
    private Set<ProductDTO> product;
    private Set<BillDTO>  bill;

    public ProductStorageDTO(){}

    public ProductStorageDTO(ProductStorage productStorage){
        this.id = productStorage.getId();
        this.product = productStorage.getProducts().stream().map(ProductDTO::new).collect(Collectors.toSet());
        this.bill = productStorage.getBills().stream().map(BillDTO::new).collect(Collectors.toSet());
    }

    public long getId() {
        return id;
    }

    public Set<ProductDTO> getProduct() {
        return product;
    }

    public Set<BillDTO> getBill() {
        return bill;
    }
}
