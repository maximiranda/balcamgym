package com.example.balcamgym.Controllers;

import com.example.balcamgym.DTO.ClientDTO;
import com.example.balcamgym.Models.Client;
import com.example.balcamgym.Repositories.ClientRepository;
import com.example.balcamgym.Services.ClientServices;
import com.example.balcamgym.Utils.EmailSenderService;
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
    @Autowired
    EmailSenderService emailSenderService;

    @GetMapping("/clients")
    public List<ClientDTO> getClients(){
        return clientServices.getAllClients().stream().map(ClientDTO::new).collect(Collectors.toList());
    }
    @GetMapping("/clients/{id}")
    public ClientDTO getClient(@PathVariable Long id){
        return new ClientDTO(clientServices.findClientById(id));
    }
    @PostMapping("/clients")
    public ResponseEntity<Object> register(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password){
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()){
            return new ResponseEntity<>("Missing Data", HttpStatus.FORBIDDEN);
        }if (clientServices.findByEmail(email) != null){
            return new ResponseEntity<>("This email already use",HttpStatus.FORBIDDEN);
        }
        Client client = new Client(firstName, lastName, email, password, false);
        clientServices.saveClient(client);
        emailSenderService.sendEmail(client.getEmail(),"Activacion de cuenta","localhost:8080/api/client/activation/" + client.getId());
        return new ResponseEntity<>("Create", HttpStatus.CREATED);

    }
    @GetMapping("/client/activation/{id}")
    public ResponseEntity<Object> verification(@PathVariable Long id){
        Client client = clientServices.findClientById(id);
        if (client == null){
            return new ResponseEntity<>("client not found", HttpStatus.FORBIDDEN);
        }
        client.setVerification(true);
        clientServices.saveClient(client);
        return new ResponseEntity<>("client verifying", HttpStatus.ACCEPTED);
    }
    @GetMapping("/clients/current")
    public ClientDTO getClient(Authentication authentication){
        Client client = clientServices.findByEmail(authentication.getName());
        return new ClientDTO(client);
    }
}
