package com.s5;

/**
 * @Author: Aresong
 * @Date: 2019/3/20 22:42
 * @Version 1.0
 */

/*
 * @SpringBootApplication来标注一个主程序类，说明这是一个spring-boot应用
 * */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldMainApplication {

    public static void main(String[] args) {
        //spring应用启动起来
        SpringApplication.run(HelloWorldMainApplication.class, args);
    }

}
