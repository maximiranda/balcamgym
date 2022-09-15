package com.example.balcamgym.Services;

import com.example.balcamgym.Models.ProductStorage;

public interface ProductStorageServices {
    public void saveProductStorage(ProductStorage productStorage);
    public ProductStorage findProductStorageById(long id);
}
