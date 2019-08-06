package com.ln;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ：leining
 * @description：TODO
 * @date ： 2019/7/19 11:17
 */
@SpringBootApplication
@EnableEurekaServer
public class EurakaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurakaApplication.class, args);
    }
}
