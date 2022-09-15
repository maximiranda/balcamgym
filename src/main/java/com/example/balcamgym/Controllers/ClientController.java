package com.example.balcamgym.Controllers;

import com.example.balcamgym.DTO.ClientDTO;
import com.example.balcamgym.Models.Client;
import com.example.balcamgym.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    ClientRepository clientRepository;

    @GetMapping("clients")
    public List<ClientDTO> getClient(){
        return clientRepository.findAll().stream().map(ClientDTO::new).collect(Collectors.toList());
    }
    @PostMapping("/clients")
    public ResponseEntity<Object> register(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password){
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()){
            return new ResponseEntity<>("", HttpStatus.FORBIDDEN);
        }
        Client client = new Client(firstName, lastName, email, password, false);
        clientRepository.save(client);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }
}
