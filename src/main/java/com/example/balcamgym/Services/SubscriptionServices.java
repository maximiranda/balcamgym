package com.example.balcamgym.Services;

import com.example.balcamgym.Models.Subscription;

public interface SubscriptionServices {
    public void saveSubscription(Subscription subscription);
    public Subscription findSubscriptionById(long id);
}
