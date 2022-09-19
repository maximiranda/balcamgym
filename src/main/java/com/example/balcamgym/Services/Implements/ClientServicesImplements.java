package com.example.balcamgym.Services.Implements;

import com.example.balcamgym.Services.ClientServices;
import com.example.balcamgym.Models.Client;
import com.example.balcamgym.Repositories.ClientRepository;
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
    public Client findClientById(long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }
    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

}
