package com.ln;

import com.ln.filter.PreRequestLogFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @author ：leining
 * @description：在启动类上添加注解@EnableZuulProxy，声明-一个Zuul代理。该代理使用Ribbon来
 * 定位注册在Eureka Server中的微服务;同时，该代理还整合了Hystrix, 从而实现了
 * 容错，所有经过Zul的请求都会在Hystrix命令中执行。
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class,args);
    }
    @Bean
    public PreRequestLogFilter preRequestLogFilter(){
        return  new PreRequestLogFilter();
    }
}
