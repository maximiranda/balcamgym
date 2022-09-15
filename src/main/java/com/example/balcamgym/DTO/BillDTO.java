package com.example.balcamgym.DTO;

import com.example.balcamgym.Models.Bill;

import java.util.Set;
import java.util.stream.Collectors;

public class BillDTO {
    private long id;
    private Set<ProductStorageDTO> productStorage;
    private double amount;

    public BillDTO(){}

    public BillDTO (Bill bill){
        this.id = bill.getId();
        this.productStorage= bill.getProductStorage().stream().map(ProductStorageDTO::new).collect(Collectors.toSet());
        this.amount = bill.getAmount();
    }

    public long getId() {
        return id;
    }


    public Set<ProductStorageDTO> getProducts() {
        return productStorage;
    }

    public double getAmount() {
        return amount;
    }
}
