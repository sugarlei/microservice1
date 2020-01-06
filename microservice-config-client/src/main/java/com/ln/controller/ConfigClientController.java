package com.ln.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：leining
 * @description：TODO
 */
@RestController
public class ConfigClientController {

    @Value("${profile}")
    private  String profile;


    @GetMapping("/profile")
    public String profile(){
        return this.profile;
    }
}
