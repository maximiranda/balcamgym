package com.example.balcamgym.Repositories;

import com.example.balcamgym.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AccountRepositories extends JpaRepository<Account,Long> {

}
