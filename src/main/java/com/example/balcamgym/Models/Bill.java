package com.example.balcamgym.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ps_id")
    private ProductStorage productStorage;

    private String name;

    private double amount;

    public Bill(){}

    public Bill(Client client, String name, double amount) {
        this.client = client;
        this.name = name;
        this.amount = amount;
    }

    public Bill(Client client, ProductStorage productStorage, String name, double amount) {
        this.client = client;
        this.productStorage = productStorage;
        this.name = name;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public ProductStorage getProductStorage() {
        return productStorage;
    }

    public void setProductStorage(ProductStorage productStorage) {
        this.productStorage = productStorage;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
