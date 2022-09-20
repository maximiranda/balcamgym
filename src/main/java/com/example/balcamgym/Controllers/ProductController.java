package com.example.balcamgym.Controllers;

import com.example.balcamgym.DTO.ProductDTO;
import com.example.balcamgym.Models.Client;
import com.example.balcamgym.Models.Product;
import com.example.balcamgym.Models.ProductCategory;
import com.example.balcamgym.Repositories.ImgFIleRepository;
import com.example.balcamgym.Repositories.ProductRepository;
import com.example.balcamgym.Services.ClientServices;
import com.example.balcamgym.Services.ImgFIleServices;
import com.example.balcamgym.Services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductServices productServices;
    @Autowired
    private ImgFIleServices imgFIleServices;
    @Autowired
    private ClientServices clientServices;

    @GetMapping("/products")
    public Set<ProductDTO> getProducts(){
        return productServices.findAllProducts().stream().filter(product -> product.isProductActive() && product.getStock()>0).map(ProductDTO::new).collect(Collectors.toSet());
    }
    @PostMapping("/products")
    public ResponseEntity<Object> createProduct(@RequestParam String name, @RequestParam ProductCategory category, @RequestParam double price,
                                             @RequestParam int stock, @RequestParam("file") MultipartFile multipartFile, @RequestParam String description, Authentication authentication){
        Client newCurrentClient = clientServices.findByEmail(authentication.getName());
        if (name.isEmpty() || category == null || price == 0.0 || stock == 0 ){
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }if(newCurrentClient == null){
            return new ResponseEntity<>("Client not found", HttpStatus.FORBIDDEN);
        }
        if (multipartFile.isEmpty()){
            Product product = new Product(name, description, category, price, stock);
            return  new ResponseEntity<>("Product Added", HttpStatus.CREATED);
        }
        try {
            imgFIleServices.save(multipartFile);
            Product product = new Product(name, description,"/public/"+ multipartFile.getOriginalFilename(), category, price, stock,true);
            productServices.saveProduct(product);
            return new ResponseEntity<>("Uploaded", HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>("Not upload", HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PatchMapping("/products")
    public ResponseEntity<Object> disableProduct(@RequestParam long id, Authentication authentication){
        Client client = clientServices.findByEmail(authentication.getName());
        Product product = productServices.findProductById(id);
        if (product == null){
            return new ResponseEntity<>("Product not found", HttpStatus.FORBIDDEN);
        }

        product.setProductActive(false);
        productServices.saveProduct(product);
        return new ResponseEntity<>("Product disalbe",HttpStatus.ACCEPTED);

    }
}
