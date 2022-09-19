package com.example.balcamgym.Controllers;

import com.example.balcamgym.DTO.SubscriptionDTO;
import com.example.balcamgym.Models.BillSubscription;
import com.example.balcamgym.Models.Client;
import com.example.balcamgym.Models.Subscription;
import com.example.balcamgym.Services.BillSubscriptionServices;
import com.example.balcamgym.Services.ClientServices;
import com.example.balcamgym.Services.SubscriptionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SubscriptionController {
    @Autowired
    private SubscriptionServices subscriptionServices;
    @Autowired
    private ClientServices clientServices;

    @Autowired
    private BillSubscriptionServices billSubscriptionServices;

    @GetMapping("/subscriptions")
    public List<SubscriptionDTO> getSubscriptions(){
        return subscriptionServices.findAllSubscriptions().stream().map(SubscriptionDTO::new).collect(Collectors.toList());
    }
    @GetMapping("/subscription/{id}")
    public SubscriptionDTO getSubscription(@PathVariable Long id){
        return new SubscriptionDTO(subscriptionServices.findSubscriptionById(id));
    }
    @PostMapping("/subscriptions")
    public ResponseEntity<Object> purchaseSubscription(Authentication authentication, @RequestParam Long id, @RequestParam boolean paymentAuthorization){
        if (!paymentAuthorization){
            return new ResponseEntity<>("", HttpStatus.FORBIDDEN);
        }
        Client client = clientServices.findByEmail(authentication.getName());
        if (client == null){
            return new ResponseEntity<>("", HttpStatus.FORBIDDEN);
        }
        Subscription subscription = subscriptionServices.findSubscriptionById(id);
        if (subscription == null){
            return new ResponseEntity<>("", HttpStatus.FORBIDDEN);
        }
        BillSubscription billSubscription = new BillSubscription(client, subscription);
        client.setClientSubscription(true);
        client.setBillSubscription(billSubscription);
        billSubscriptionServices.saveBillSubscription(billSubscription);
        clientServices.saveClient(client);
        return new ResponseEntity<>("Subscription added", HttpStatus.CREATED);
    }
}
