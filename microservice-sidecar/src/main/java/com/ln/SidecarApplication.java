package com.ln;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

/**
 * @author ：leining
 * @description：@EnableSidecar是一- 个组合注解，它整合了三个注解，分别是: @EnableCircui tBreaker、
 * @EnableDiscoveryClient和@EnableZuulProxy。
 * @date ： 2019/8/12 15:18
 */
@SpringBootApplication
@EnableSidecar //@EnableSidecar注解， 声明这是一 个Sidecar
public class SidecarApplication {
    public static void main(String[] args) {
        SpringApplication.run(SidecarApplication.class,args);
    }
}
