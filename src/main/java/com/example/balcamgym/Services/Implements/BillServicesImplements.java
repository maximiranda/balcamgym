package com.example.balcamgym.Services.Implements;

import com.example.balcamgym.Services.BillServices;
import com.example.balcamgym.Models.Bill;
import com.example.balcamgym.Repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServicesImplements implements BillServices {
    @Autowired
    private BillRepository billRepository;

    @Override
    public void saveBill(Bill bill) {
        billRepository.save(bill);
    }

    @Override
    public Bill findBillById(long id) {
        return billRepository.findBillById(id);
    }
}
