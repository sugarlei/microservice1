package com.ln.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：leining
 * @description：TODO
 * @date ： 2019/8/13 11:50
 */
@RestController
@RefreshScope //添加@RefreshScope的类会在配置更改时得到特殊的处理
public class ConfigClientController {

    @Value("${profile}")
    private  String profile;


    @GetMapping("/profile")
    public String profile(){
        return this.profile;
    }
}
