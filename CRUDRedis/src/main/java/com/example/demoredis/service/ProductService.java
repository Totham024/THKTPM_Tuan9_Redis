package com.example.demoredis.service;

import com.example.demoredis.entity.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);
    List<Product> findAll();
    Product findProductById(int id);
    String deleteProduct(int id);
}
