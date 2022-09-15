package com.example.balcamgym.Services.Implements;

import com.example.balcamgym.Models.ProductStorage;
import com.example.balcamgym.Repositories.ProductStorageRepository;
import com.example.balcamgym.Services.ProductStorageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductStorageServicesImplements implements ProductStorageServices {
    @Autowired
    private ProductStorageRepository productStorageRepository;

    @Override
    public void saveProductStorage(ProductStorage productStorage) {
        productStorageRepository.save(productStorage);
    }

    @Override
    public ProductStorage findProductStorageById(long id) {
        return productStorageRepository.findProductStorageById(id);
    }
}

