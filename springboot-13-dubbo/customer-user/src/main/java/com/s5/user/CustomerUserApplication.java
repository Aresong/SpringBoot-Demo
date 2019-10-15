package com.s5.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 *  1.引入dubbo和zkclient相关依赖
 *  2.配置dubbo的扫描包和注册中心地址
 *  3使用@Service引用服务
 * **/
@SpringBootApplication
public class CustomerUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerUserApplication.class, args);
    }

}
