package com.example.balcamgym.Services;

import com.example.balcamgym.Models.Client;

public interface ClientServices {
    public void saveClient(Client client);
    public Client findClientById(long id);
    public Client findByEmail(String email);
}

