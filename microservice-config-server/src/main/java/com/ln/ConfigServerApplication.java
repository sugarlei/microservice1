package com.ln;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author ：leining
 * @description：TODO
 * @date ： 2019/8/13 11:16
 */
@SpringBootApplication
@EnableConfigServer //添加注解@EnableConfigServer ,声明这是一个Config Server
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class,args);
    }
}
