package com.example.balcamgym.DTO;

import com.example.balcamgym.Models.BillSubscription;

public class BillSubscriptionDTO {
    private long id;
    private double amount;
    private ClientDTO client;

    private SubscriptionDTO subscription;

    public BillSubscriptionDTO(){}

    public BillSubscriptionDTO(BillSubscription billSubscription){
        this.id = billSubscription.getId();
        this.client = new ClientDTO(billSubscription.getClient());
        this.subscription = new SubscriptionDTO(billSubscription.getSubscription());


    }

    public long getId() {
        return id;
    }


}
