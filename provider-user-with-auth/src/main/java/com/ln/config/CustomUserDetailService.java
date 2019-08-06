package com.ln.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author ：leining
 * @description：TODO
 * @date ： 2019/8/1 16:12
 */
@Component
public class CustomUserDetailService implements UserDetailsService {
    /**
     * 模拟两个账户:
     * ①账号是user,密码是password1, 角色是user-role
     * ②账号是admin，密码是password2, 角色是admin-role
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("user".equals(username)) {
            return new SecurityUser("user", "password1", "user-role");
        } else if ("admin".equals(username)) {
            return new SecurityUser("admin", "password2", "admin-role");
        } else {
            return null;
        }
    }
}
