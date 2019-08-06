package com.ln.controller;

import com.ln.entity.User;
import com.ln.service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ：leining
 * @description：TODO
 * @date ： 2019/7/19 10:05
 */
@RestController
public class ConsumerMovieController {
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return userFeignClient.findById(id);
    }
}

