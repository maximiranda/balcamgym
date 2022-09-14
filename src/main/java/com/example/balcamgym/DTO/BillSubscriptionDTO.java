package com.example.balcamgym.DTO;

import com.example.balcamgym.Models.BillSubscription;

public class BillSubscriptionDTO {
    private long id;
    private double amount;

    public BillSubscriptionDTO(){}

    public BillSubscriptionDTO(BillSubscription billSubscription){
        this.id = billSubscription.getId();
        this.amount = billSubscription.getAmount();
    }

    public long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }
}
