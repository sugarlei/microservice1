package com.ln;

import com.ln.trace.CustomTraceRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author ：leining
 * @description：TODO
 */
@SpringBootApplication
public class ConfigClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class,args);
    }

    @Bean
    public CustomTraceRepositoryImpl customeTraceRepository() {
        return new CustomTraceRepositoryImpl();
    }
}
