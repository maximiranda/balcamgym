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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    PasswordEncoder passwordEncoder;
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
        Client client = new Client(firstName, lastName, email, passwordEncoder.encode(password), false);
        clientServices.saveClient(client);
        emailSenderService.sendEmail(client.getEmail(),"Activacion de cuenta","http://localhost:8080/api/client/activation/" + client.getId());
        return new ResponseEntity<>("Create", HttpStatus.CREATED);
    }
    @GetMapping("/client/activation/{id}")
    public RedirectView verification(@PathVariable Long id){
        Client client = clientServices.findClientById(id);
        if (client == null){
            return new RedirectView("/web/login.html?confirm=false");
        }
        client.setVerification(true);
        clientServices.saveClient(client);
        return new RedirectView("/web/login.html?confirm=true");
    }
    @GetMapping("/clients/current")
    public ClientDTO getClient(Authentication authentication){
        Client client = clientServices.findByEmail(authentication.getName());
        return new ClientDTO(client);
    }


}
