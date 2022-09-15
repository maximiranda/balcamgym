package com.example.balcamgym.Services.Implements;

import com.example.balcamgym.Services.ClientServices;
import com.example.balcamgym.Models.Client;
import com.example.balcamgym.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServicesImplements implements ClientServices {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client findClientById(long id) {
        return clientRepository.findClientById(id);
    }

    @Override
    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

}
