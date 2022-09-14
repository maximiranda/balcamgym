package com.example.balcamgym.Repositories;

import com.example.balcamgym.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ClientRepositories extends JpaRepository<Client,Long> {
}
