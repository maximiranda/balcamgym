package com.example.balcamgym.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToMany(mappedBy = "products", fetch = FetchType.EAGER)
    private Set<Order> orders = new HashSet<>();
    private String name;
    private ProductType type;
    private double price;
    private int stock;
    private List<ProductCategory> categories;
}
