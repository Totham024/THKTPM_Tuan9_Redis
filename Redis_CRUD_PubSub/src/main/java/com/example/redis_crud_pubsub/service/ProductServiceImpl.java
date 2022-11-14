package com.example.redis_crud_pubsub.service;

import com.example.redis_crud_pubsub.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    private static final String PRODUCT_KEY = "Product";
    private final RedisTemplate<String,Object> redisTemplate;
    private HashOperations<String,Integer, Product> hashOperations;

    public ProductServiceImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    @PostConstruct
    public void init(){
        hashOperations = redisTemplate.opsForHash();
    }
    @Override
    public void save(Product product) {
        hashOperations.put(PRODUCT_KEY, product.getId(), product);

    }

    @Override
    public List<Product> findAll() {
        return hashOperations.values(PRODUCT_KEY);
    }

    @Override
    public Product findProductById(int id) {
        return hashOperations.get(PRODUCT_KEY, id);
    }

    @Override
    public String deleteProduct(int id) {
        hashOperations.delete(PRODUCT_KEY,id);
        return "delete completed";
    }
}
