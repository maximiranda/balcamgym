package com.example.balcamgym.DTO;

import com.example.balcamgym.Models.Bill;
import com.example.balcamgym.Models.Client;

import java.util.Set;
import java.util.stream.Collectors;

public class BillDTO {
    private long id;
    private String number;
    private Set<ProductStorageDTO> productStorage;
    private Client client;
    private double amount;


    public BillDTO (Bill bill){
        this.id = bill.getId();
        this.number = bill.getNumber();
        this.productStorage= bill.getProductStorage().stream().map(ProductStorageDTO::new).collect(Collectors.toSet());
        this.amount = bill.getAmount();
        this.client = bill.getClient();
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

    public Client getClient() {
        return client;
    }

    public String getNumber() {
        return number;
    }
}
