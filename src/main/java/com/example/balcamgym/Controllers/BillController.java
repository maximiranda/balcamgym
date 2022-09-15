package com.example.balcamgym.Controllers;

import com.example.balcamgym.DTO.BillDTO;
import com.example.balcamgym.Models.Client;
import com.example.balcamgym.Models.ProductStorage;
import com.example.balcamgym.Repositories.BillRepository;
import com.example.balcamgym.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BillController {
    @Autowired
    private BillRepository billRepository;

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/bills")
    public Set<BillDTO> getBills(){
        return billRepository.findAll().stream().map(BillDTO::new).collect(Collectors.toSet());
    }

    @PostMapping("/buys")//compra de preducto
    public ResponseEntity<Object> makeBuy (@RequestParam Set<ProductStorage> productStorage, @RequestParam String email){
        Client client = clientRepository.findByEmail(email);
        if(client == null){
            return new ResponseEntity<>("", HttpStatus.FORBIDDEN);
        }
        double amount = 0;
        //productStorage.stream().map(ProductStorage::getProduct).forEach(price -> amount = amount+ price);

        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
