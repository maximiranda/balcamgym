package com.example.balcamgym.DTO;

import com.example.balcamgym.Models.Client;

import java.util.Set;
import java.util.stream.Collectors;

public class ClientDTO {
private long id;
    private String firstName, lastName, email;
    private Set<BillDTO> bill;


    public ClientDTO(){}

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.email = client.getEmail();
        this.bill = client.getBills().stream().map(BillDTO::new).collect(Collectors.toSet());
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Set<BillDTO> getBill() {
        return bill;
    }
}
