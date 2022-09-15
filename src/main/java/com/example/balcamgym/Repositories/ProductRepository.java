package com.example.balcamgym.Repositories;

import com.example.balcamgym.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findProductById(long id);
}
