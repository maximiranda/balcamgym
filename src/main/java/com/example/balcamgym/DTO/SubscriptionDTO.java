package com.example.balcamgym.DTO;

import com.example.balcamgym.Models.Subscription;
import com.example.balcamgym.Models.SubscriptionTypes;
import jdk.jshell.JShell;

import java.time.LocalDate;

public class SubscriptionDTO {
    private long id;
    private SubscriptionTypes subscriptionTypes;
    private double amount;

    private LocalDate fromDate, toDate;


    public SubscriptionDTO(){}

    public SubscriptionDTO(Subscription subscription) {
        this.id = subscription.getId();
        this.subscriptionTypes = subscription.getSubscriptionTypes();
        this.amount = subscription.getAmount();
        this.fromDate = subscription.getFromDate();
        this.toDate = subscription.getToDate();
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

    public LocalDate getFromDate() {
        return fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }
}
