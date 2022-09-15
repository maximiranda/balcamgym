package com.example.balcamgym.Services.Implements;

import com.example.balcamgym.Models.Subscription;
import com.example.balcamgym.Repositories.SubscriptionRepository;
import com.example.balcamgym.Services.SubscriptionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServicesImplements implements SubscriptionServices {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    public void saveSubscription(Subscription subscription) {
        subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription findSubscriptionById(long id) {
        return subscriptionRepository.findSubscriptionById(id);
    }
}
