package com.example.balcamgym.Models;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToOne
    private Account account;

    /*@OneToMany(mappedBy = "subscriptions", fetch = FetchType.EAGER)
    private Set<Order> orders = new HashSet<>();*/


    private SubscriptionTypes subscriptionTypes;

    private double amount;

    private LocalDate fromDate, toDate;



    public Subscription(){}

    public Subscription(SubscriptionTypes subscriptionTypes, double amount, LocalDate fromDate, LocalDate toDate, Account account) {
        this.subscriptionTypes = subscriptionTypes;
        this.amount = amount;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.account = account;
    }



    public SubscriptionTypes getSubscriptionsTypes() {
        return subscriptionTypes;
    }
    public void setSubscriptionsTypes(SubscriptionTypes subscriptionTypes) {
        this.subscriptionTypes = subscriptionTypes;
    }



    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }



    public LocalDate getFromDate() {
        return fromDate;
    }
    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }



    public LocalDate getToDate() {
        return toDate;
    }
    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }



    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }



}