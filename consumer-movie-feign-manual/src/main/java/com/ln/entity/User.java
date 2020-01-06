package com.ln.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author ：leining
 * @description：TODO
 * @date ： 2019/10/18 17:54
 */
@Getter
@Setter
public class User {
    private Long id;
    private String username;
    private String name;
    private Integer age;
    private BigDecimal balance;

}
