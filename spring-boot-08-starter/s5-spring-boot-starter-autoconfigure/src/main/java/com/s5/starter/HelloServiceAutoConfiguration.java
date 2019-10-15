package com.s5.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Aresong
 * @Date: 2019/5/22 22:41
 * @Version 1.0
 * HelloService的自动配置类，说白了就是给HelloService设置参数用的
 */

@Configuration
@ConditionalOnWebApplication//WEB应用才生效
/*
    作用：
        @EnableConfigurationProperties注解的作用是：使使用 @ConfigurationProperties 注解的类生效。

    说明：
        如果一个配置类只配置@ConfigurationProperties注解，而没有使用@Component，
        那么在IOC容器中是获取不到properties配置文件转化的bean。
        说白了 @EnableConfigurationProperties 相当于把使用  @ConfigurationProperties 的类进行了一次注入。
*/
@EnableConfigurationProperties(HelloProperties.class)
public class HelloServiceAutoConfiguration {

    @Autowired
    HelloProperties helloProperties;

    //通过容器注入的方式为HelloService注入helloProperties，这里个人感觉helloProperties应该是带值传过来的
    @Bean
    public HelloService helloService(){
        HelloService service = new HelloService();
        service.setHelloProperties(helloProperties);
        return service;
    }
}
