package com.example.balcamgym.REPOSITORIES;

import com.example.balcamgym.MODELS.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AccountRepositories extends JpaRepository<Account,Long> {

}
