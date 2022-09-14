package com.example.balcamgym.Repositories;

import com.example.balcamgym.Models.BillSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BillSubscriptionRepositories extends JpaRepository<BillSubscription,Long> {
}
