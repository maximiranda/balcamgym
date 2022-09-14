package com.example.balcamgym.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private List<Product> products;
  /*  @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")*/
    private Client client;
    /*@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subscription_id")*/
    private Subscription subscription;
    private LocalDateTime date;
    private double amount;

    public Order(long id, Client client, Subscription subscription, List<Product> products, LocalDateTime date, double amount) {
        this.id = id;
        this.client = client;
        this.subscription = subscription;
        this.products = products;
        this.date = date;
        this.amount = amount;
    }

    public Order(long id, Client client, List<Product> products, LocalDateTime date, double amount) {
        this.id = id;
        this.client = client;
        this.products = products;
        this.date = date;
        this.amount = amount;

    }

    public long getId() {
        return id;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
