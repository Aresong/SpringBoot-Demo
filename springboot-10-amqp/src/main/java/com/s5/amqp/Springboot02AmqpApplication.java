package com.s5.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 自动配置
 * 1.RabbitAutoConfiguration
 * 2.自动配置了连接工厂
 * 3.RabbitProperties封装了RabbitMQ的配置
 * 4.RabbitTemplate:给RabbitMQ发送和接收消息
 * 5.AmqpAdmin  RabbitMQ系统管理功能组件
 *      AmqpAdmin:创建和删除 Queue、exchange、binding
 * 6.@EnableRabbit+@RabbitListener 监听消息队列的内容
 * **/
@EnableRabbit //开启将基于注解的RabbitMQ模式
@SpringBootApplication
public class Springboot02AmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot02AmqpApplication.class, args);
    }

}
