package com.example.balcamgym.Services;

import com.example.balcamgym.Models.Client;

import java.lang.ref.Cleaner;
import java.util.List;

public interface ClientServices {
    void saveClient(Client client);

    public List<Client> getAllClients();

    Client findClientById(long id);

    Client findByEmail(String email);

}

