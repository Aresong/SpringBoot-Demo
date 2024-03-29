package com.s5.spring_boot_02_config.config;

import com.s5.spring_boot_02_config.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Aresong
 * @Date: 2019/3/24 20:56
 * @Version 1.0
 */

/*
* 指明当前类是一个配置类，就是来代替之前的Spring配置文件
* 在配置文件中<bean></bean>标签加组件
* */
@Configuration
public class MyAppConfig {

    //将方法的返回值添加到容器中：容器中这个组件默认的id就是方法名
    @Bean
    public HelloService helloService(){
        System.out.println("配置类@Bean给容器中添加组件了……");
        return new HelloService();
    }
}
