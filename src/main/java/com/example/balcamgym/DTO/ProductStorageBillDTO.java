package com.example.balcamgym.DTO;

import com.example.balcamgym.Models.Product;

import java.util.List;

public class ProductStorageBillDTO {
    private double amount;
    private List<Long> ids;


    public ProductStorageBillDTO(double amount, List<Long> ids) {
        this.amount = amount;
        this.ids = ids;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}