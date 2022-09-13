package com.example.balcamgym.REPOSITORIES;

import com.example.balcamgym.MODELS.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ClientRepositories extends JpaRepository<Client,Long> {
}
