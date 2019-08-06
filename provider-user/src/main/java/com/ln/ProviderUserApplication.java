package com.ln;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ：leining
 * @description：TODO
 * @date ： 2019/7/18 18:03
 */
@SpringBootApplication
//@EnableEurekaClient //只支持 eureka
@EnableDiscoveryClient //支持eureka ,consol,zookeepr
public class ProviderUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderUserApplication.class, args);
    }
}
