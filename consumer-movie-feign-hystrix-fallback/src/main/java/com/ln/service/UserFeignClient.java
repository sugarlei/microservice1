package com.ln.service;

import com.ln.entity.User;
import com.ln.service.fallback.UserFeginClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Feign的fallback测试
 * 使用@FeignClient的fallback属性指定回退类
 */
@Service
@FeignClient(name = "provider-user",fallback = UserFeginClientFallback.class)
//由代码可知，只须使用@FeignClient注解的fallback属性,就可为指定名称的Feign客户端添加回退。
public interface UserFeignClient {
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);
}
