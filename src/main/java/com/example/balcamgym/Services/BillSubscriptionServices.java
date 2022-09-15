package com.example.balcamgym.Services;

import com.example.balcamgym.Models.BillSubscription;

public interface BillSubscriptionServices {
    public void saveBillSubscription(BillSubscription billSubscription);

    public BillSubscription findById(long id);
}
