package com.example.balcamgym.DTO;

import com.example.balcamgym.Models.Bill;

public class BillDTO {
    private long id;
    private String name;
    private double amount;

    public BillDTO(){}

    public BillDTO (Bill bill){
        this.id = bill.getId();
        this.name = bill.getName();
        this.amount = bill.getAmount();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }
}
