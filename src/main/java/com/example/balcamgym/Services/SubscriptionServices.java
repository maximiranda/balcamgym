package com.example.balcamgym.Services;

import com.example.balcamgym.Models.Subscription;

import java.util.List;

public interface SubscriptionServices {
    public Subscription findSubscriptionById(long id);
    public List<Subscription> findAllSubscriptions();
    public void saveSubscription(Subscription subscription);
}
