package com.example.balcamgym.Controllers;

import com.example.balcamgym.DTO.BillDTO;
import com.example.balcamgym.Models.Client;
import com.example.balcamgym.Models.Product;
import com.example.balcamgym.Models.ProductStorage;
import com.example.balcamgym.Repositories.BillRepository;
import com.example.balcamgym.Services.BillServices;
import com.example.balcamgym.Services.ClientServices;
import com.example.balcamgym.Services.ProductServices;
import com.example.balcamgym.Utils.PdfGenerator;

import com.example.balcamgym.Services.ProductStorageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashSet;
import java.util.List;
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


    @PostMapping("/purchase")
    public ResponseEntity<Object> purchase (@RequestBody ProductStorageBillDTO productStorageBillDTO, @RequestParam boolean paymentAuthorization, Authentication authentication){
        Client client = clientServices.findByEmail(authentication.getName());
        List<Long> ids = productStorageBillDTO.getIds();

        if (client == null){
            return new ResponseEntity<>("Client doesn´t found", HttpStatus.FORBIDDEN);
        }
        if (!paymentAuthorization){
            return new ResponseEntity<>("Payment unauthorized", HttpStatus.FORBIDDEN);
        }
        if (ids.isEmpty()){
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }
        Bill bill  = new Bill(client, productStorageBillDTO.getAmount(),"000-000-001");
        billServices.saveBill(bill);
        Set<ProductStorage> productStorages = new HashSet<>();

        for (Long id: ids){
            Product product1 = productServices.findProductById(id);
            if (product1.getStock() < 0) {
                return new ResponseEntity<>("Product " + product1.getName() + "doesn´t have stock", HttpStatus.FORBIDDEN);
            }
            product1.setStock(product1.getStock()-1);
            System.out.println(product1);
            ProductStorage productStorage = new ProductStorage(product1, bill);

            productServices.saveProduct(product1);
            productStorageServices.saveProductStorage(productStorage);
            System.out.println("hola");
            productStorages.add(productStorage);

        }
        System.out.println(productStorages);
        bill.setProductStorage(productStorages);
        billServices.saveBill(bill);

        PdfGenerator pdf = new PdfGenerator();
        BillDTO billDTO = new BillDTO(bill);
        pdf.createBill(productStorageBillDTO, billDTO);

        return new ResponseEntity<>("Purchase success", HttpStatus.OK);
    }



}
