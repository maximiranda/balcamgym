package com.example.balcamgym.Services.Implements;

import com.example.balcamgym.Models.Client;
import com.example.balcamgym.Repositories.ClientRepository;
import com.example.balcamgym.Services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServicesImplements implements ClientServices {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

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
