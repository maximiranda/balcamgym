package com.example.balcamgym.Repositories;

import com.example.balcamgym.Models.BillSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BillSubscriptionRepository extends JpaRepository<BillSubscription,Long> {
    BillSubscription findById(long id);
}
