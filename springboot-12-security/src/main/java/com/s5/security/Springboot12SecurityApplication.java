package com.s5.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * 1.引入spring-security
 * 2.编写spring-security配置
 * @EnableWebSecurity
 * public class MySecurityConfig extends WebSecurityConfigurerAdapter {
 * }
 * 3.控制请求的访问权限
 * **/
public class Springboot12SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot12SecurityApplication.class, args);
    }

}
