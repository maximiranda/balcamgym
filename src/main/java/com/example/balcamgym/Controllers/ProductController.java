package com.example.balcamgym.Controllers;

import com.example.balcamgym.DTO.ProductDTO;
import com.example.balcamgym.Models.Product;
import com.example.balcamgym.Models.ProductCategory;
import com.example.balcamgym.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public Set<ProductDTO> getProducts(){
        return productRepository.findAll().stream().map(ProductDTO::new).collect(Collectors.toSet());
    }
    @PostMapping("/products")
    public ResponseEntity<Object> createProduct(@RequestParam String name, @RequestParam ProductCategory category, @RequestParam double price, @RequestParam int stock){

        if (name.isEmpty() || category == null || price == 0.0 || stock == 0 ){
            return new ResponseEntity<>("", HttpStatus.FORBIDDEN);
        }
        Product product = new Product(name, category, price, stock);
        productRepository.save(product);
        return  new ResponseEntity<>("", HttpStatus.CREATED);
    }
}
