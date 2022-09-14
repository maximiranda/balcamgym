package com.example.balcamgym.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "native", strategy = "native")
    private long id;


    private SubscriptionTypes subscriptionTypes;

    private double amount;

    private LocalDate fromdate, toDate;

    public Subscription(){}


    public Subscription(SubscriptionTypes subscriptionTypes, double amount, LocalDate fromdate, LocalDate toDate) {
        this.subscriptionTypes = subscriptionTypes;
        this.amount = amount;
        this.fromdate = fromdate;
        this.toDate = toDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SubscriptionTypes getSubscriptionTypes() {
        return subscriptionTypes;
    }

    public void setSubscriptionTypes(SubscriptionTypes subscriptionTypes) {
        this.subscriptionTypes = subscriptionTypes;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getFromdate() {
        return fromdate;
    }

    public void setFromdate(LocalDate fromdate) {
        this.fromdate = fromdate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }
}
