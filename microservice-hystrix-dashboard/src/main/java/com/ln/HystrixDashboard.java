package com.ln;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author ：leining
 * @description：TODO
 * @date ： 2019/8/2 17:30
 */
@SpringBootApplication
@EnableHystrixDashboard //开启HystrixDashboard可视化监控
public class HystrixDashboard {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard.class, args);
    }
}
