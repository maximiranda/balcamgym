package com.example.balcamgym.DTO;

import com.example.balcamgym.Models.Subscription;
import com.example.balcamgym.Models.SubscriptionTypes;
import jdk.jshell.JShell;

import java.time.LocalDate;

public class SubscriptionDTO {
    private long id;
    private SubscriptionTypes subscriptionTypes;
    private double amount;


    public SubscriptionDTO(){}

    public SubscriptionDTO(Subscription subscription) {
        this.id = subscription.getId();
        this.subscriptionTypes = subscription.getSubscriptionTypes();
        this.amount = subscription.getAmount();
    }

    public long getId() {
        return id;
    }

    public SubscriptionTypes getSubscriptionTypes() {
        return subscriptionTypes;
    }

    public double getAmount() {
        return amount;
    }
}
