package com.example.balcamgym.Controllers;

import com.example.balcamgym.DTO.BillDTO;
import com.example.balcamgym.Models.*;
import com.example.balcamgym.Repositories.BillRepository;
import com.example.balcamgym.Services.*;
import com.example.balcamgym.Utils.EmailSenderService;
import com.example.balcamgym.Utils.PdfGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


import javax.mail.MessagingException;
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
    private ClientServices clientServices;
    @Autowired
    private ProductServices productServices;
    @Autowired
    private ProductStorageServices productStorageServices;
    @Autowired
    private BillServices billServices;

    @Autowired
    private EmailSenderService senderEmail;

    @GetMapping("/bills")
    public Set<BillDTO> getBills(){
        return billRepository.findAll().stream().map(BillDTO::new).collect(Collectors.toSet());
    }


    @PostMapping("/purchase")
    public ResponseEntity<Object> purchase (@RequestParam List<Long> ids, @RequestParam boolean paymentAuthorization, Authentication authentication) throws MessagingException {
        Client client = clientServices.findByEmail(authentication.getName());
        if (client == null){
            return new ResponseEntity<>("Client doesn't found", HttpStatus.FORBIDDEN);
        }
        if (!paymentAuthorization){
            return new ResponseEntity<>("Payment unauthorized", HttpStatus.FORBIDDEN);
        }
        if (ids.isEmpty()){
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }
        List<Product> products = ids.stream().map(id -> productServices.findProductById(id)).collect(Collectors.toList());
        double amount = products.stream().map(Product::getPrice).reduce(0.0, Double::sum);

        Bill bill  = new Bill(client, amount,"000-000-001");
        billServices.saveBill(bill);
        Set<ProductStorage> productStorages = new HashSet<>();

        for (Long id: ids){
            Product product1 = productServices.findProductById(id);
            if (product1.getStock() < 0) {
                return new ResponseEntity<>("Product " + product1.getName() + "doesn't have stock", HttpStatus.FORBIDDEN);
            }
            product1.setStock(product1.getStock()-1);

            ProductStorage productStorage = new ProductStorage(product1, bill);

            productServices.saveProduct(product1);
            productStorageServices.saveProductStorage(productStorage);
            productStorages.add(productStorage);

        }

        bill.setProductStorage(productStorages);
        billServices.saveBill(bill);

        BillDTO billDTO = new BillDTO(bill);
        PdfGenerator.createBill(ids,billDTO,productServices);
        senderEmail.sendMailWithAttchment(client.getEmail(), "Purchase PDF","Invoce number:"+ billDTO.getNumber(),"C:\\Users\\Chino\\Downloads\\BALCAM_BILL.pdf");
        return new ResponseEntity<>("Purchase success", HttpStatus.CREATED);
    }
    @GetMapping("/purchase/pdf/{id}")
    public ResponseEntity<Object> getPdf(@PathVariable Long id){
        BillDTO bill = new BillDTO(billRepository.findBillById(id));
        List<Long> ids = bill.getProducts().stream().map(productStorageDTO -> productStorageDTO.getProduct().getId()).collect(Collectors.toList());
        PdfGenerator.createBill(ids, bill, productServices);
        return new ResponseEntity<>("Purchase success", HttpStatus.CREATED);
    }
}
