package com.example.springbootredismessagepublisher.publisher;

import com.example.springbootredismessagepublisher.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Publisher {
    @Autowired
    private  RedisTemplate<String,Object> redisTemplate;
    public Publisher(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    private ChannelTopic topic;
    @PostMapping("/publish")
    public String publish(@RequestBody Product product){
        redisTemplate.convertAndSend("totham",product.toString());
        return "completed publish";
    }
}
