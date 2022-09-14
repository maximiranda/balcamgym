package com.example.balcamgym.REPOSITORIES;


import com.example.balcamgym.MODELS.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SubscriptionsRepositories  extends JpaRepository<Subscription,Long> {
}
