package com.example.redis_crud_pubsub.service;

import com.example.redis_crud_pubsub.entity.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);

    List<Product> findAll();

    Product findProductById(int id);

    String deleteProduct(int id);
}
