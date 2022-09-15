package com.example.balcamgym.Repositories;

import com.example.balcamgym.Models.Client;
import com.example.balcamgym.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findProductById(long id);

    Product findByName(String name);


}
