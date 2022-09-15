package com.example.balcamgym.Controllers;

import com.example.balcamgym.DTO.ClientDTO;
import com.example.balcamgym.Models.Client;
import com.example.balcamgym.Repositories.ClientRepository;
import com.example.balcamgym.Services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    ClientServices clientServices;

    @GetMapping("clients")
    public List<ClientDTO> getClient(){
        return clientServices.getAllClients().stream().map(ClientDTO::new).collect(Collectors.toList());
    }
    @PostMapping("/clients")
    public ResponseEntity<Object> register(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password,
                                           Authentication authentication){
        Client newCurrentClient = clientServices.findByEmail(authentication.getName());
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()){
            return new ResponseEntity<>("Missing Data", HttpStatus.FORBIDDEN);
        }if (clientServices.findByEmail(authentication.getName()) != null){
            return new ResponseEntity<>("This email already use",HttpStatus.FORBIDDEN);
        }
        Client client = new Client(firstName, lastName, email, password, false);
        clientServices.saveClient(client);
        return new ResponseEntity<>("Create", HttpStatus.CREATED);
    }


}
