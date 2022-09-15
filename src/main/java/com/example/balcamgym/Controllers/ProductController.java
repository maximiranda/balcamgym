package com.example.balcamgym.Controllers;

import com.example.balcamgym.DTO.ProductDTO;
import com.example.balcamgym.Models.Client;
import com.example.balcamgym.Models.Product;
import com.example.balcamgym.Models.ProductCategory;
import com.example.balcamgym.Repositories.ProductRepository;
import com.example.balcamgym.Services.ClientServices;
import com.example.balcamgym.Services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductServices productServices;

    @Autowired
    ClientServices clientServices;

    @GetMapping("/products")
    public Set<ProductDTO> getProducts(){
        return productServices.getAllProducts().stream().map(ProductDTO::new).collect(Collectors.toSet());
    }
    @PostMapping("/products")
    public ResponseEntity<Object> buyProduct(@RequestParam String name, @RequestParam ProductCategory category, @RequestParam double price,
                                             @RequestParam int stock, Authentication authentication){
        Client newCurrentClient = clientServices.findByEmail(authentication.getName());
        if (name.isEmpty() || category == null || price == 0.0 || stock == 0 ){
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }if (productServices.findByName(name).getStock()<= 0){
            return new ResponseEntity<>("No stock",HttpStatus.FORBIDDEN);
        }if(newCurrentClient == null){
            return new ResponseEntity<>("Client not found", HttpStatus.FORBIDDEN);
        }
        Product product = new Product(name, category, price, stock);
        productServices.saveProduct(product);
        return  new ResponseEntity<>("Buy accepted", HttpStatus.CREATED);
    }
}
