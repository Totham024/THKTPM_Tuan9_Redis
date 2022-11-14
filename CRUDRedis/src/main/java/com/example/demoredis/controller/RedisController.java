package com.example.demoredis.controller;

import com.example.demoredis.entity.Product;
import com.example.demoredis.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/product")
public class RedisController {
    @Autowired
    private final ProductService dao;

    public RedisController(ProductService dao) {
        this.dao = dao;
    }
    @PostMapping("/save")
    public String save(@RequestBody Product product){
        dao.save(product);
        return "save completed";
    }
    @GetMapping("/getall")
    public List<Product> getall(){
        return dao.findAll();
    }
    @GetMapping("/getbyid/{id}")
    public Product getbyid(@PathVariable int id){
        return dao.findProductById(id);
    }
    @GetMapping("/delete/{id}")
    public String remove(@PathVariable int id){
        return dao.deleteProduct(id);
    }
}
