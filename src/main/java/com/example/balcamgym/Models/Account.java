package com.example.balcamgym.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "native", strategy = "native")
    private long id;


    private String accountNumber;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Account (){}

    public Account(String accountNumber, Client client) {
        this.accountNumber = accountNumber;
        this.client = client;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }



    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }


    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
}
