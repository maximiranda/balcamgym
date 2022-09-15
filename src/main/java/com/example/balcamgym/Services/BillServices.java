package com.example.balcamgym.Services;

import com.example.balcamgym.Models.Bill;


public interface BillServices {
    public void saveBill(Bill bill);
    public Bill findBillById(long id);
}
