package com.example.balcamgym.Services.Implements;

import com.example.balcamgym.Models.BillSubscription;
import com.example.balcamgym.Repositories.BillSubscriptionRepository;
import com.example.balcamgym.Services.BillSubscriptionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillSubscriptionServicesImplements implements BillSubscriptionServices {
    @Autowired
    private BillSubscriptionRepository billSubscriptionRepository;

    @Override
    public void saveBillSubscription(BillSubscription billSubscription) {
        billSubscriptionRepository.save(billSubscription);
    }

    @Override
    public BillSubscription findById(long id) {
        return billSubscriptionRepository.findById(id);
    }
}

