package com.ln.controller;

import com.ln.entity.User;
import com.ln.service.UserFeignClient;
import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：leining
 * @description：TODO
 * @date ： 2019/7/19 10:05
 */
@Import(FeignClientsConfiguration.class)
@RestController
public class ConsumerMovieController {


    private UserFeignClient adminUserFeignClient;

    private UserFeignClient userUserFeignClient;

    @Autowired
    public ConsumerMovieController(Decoder decoder, Encoder encoder, Client client, Contract contract){
        this.userUserFeignClient = Feign.builder().client(client).decoder(decoder).encoder(encoder)
                .contract(contract).requestInterceptor(new BasicAuthRequestInterceptor("user","password1"))
                .target(UserFeignClient.class,"http://provider-user/");

        this.adminUserFeignClient = Feign.builder().client(client).decoder(decoder).encoder(encoder)
                .contract(contract).requestInterceptor(new BasicAuthRequestInterceptor("admin","password2"))
                .target(UserFeignClient.class,"http://provider-user/");
    }

    @GetMapping("user-user/{id}")
    public User findByIdUser(@PathVariable Long id){
        return this.userUserFeignClient.findById(id);
    }

    @GetMapping("user-admin/{id}")
    public User findByIdAdmin(@PathVariable Long id){
        return this.adminUserFeignClient.findById(id);
    }
}

