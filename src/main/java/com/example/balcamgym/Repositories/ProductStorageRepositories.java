package com.example.balcamgym.Repositories;

import com.example.balcamgym.Models.ProductStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductStorageRepositories extends JpaRepository<ProductStorage,Long> {
}
