package com.ln.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author ：leining
 * @description：高版本不再在Eureka（yml文件）中配置basic认证
 *   新版本的security默认开启csrf了，一定要关掉，新建一个配置类（这一步不做的话，注册中心能启动，但是服务无法注册进来的啊！！
 * @date ： 2019/7/19 11:17
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); //关闭csrf
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic(); //开启认证
    }

}