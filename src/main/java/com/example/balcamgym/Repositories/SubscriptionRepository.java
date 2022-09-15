package com.example.balcamgym.Repositories;

import com.example.balcamgym.Models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {
    Subscription findSubscriptionById(long id);
}
