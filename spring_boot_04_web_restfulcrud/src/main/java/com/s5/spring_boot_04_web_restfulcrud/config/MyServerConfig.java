package com.s5.spring_boot_04_web_restfulcrud.config;

import com.s5.spring_boot_04_web_restfulcrud.filter.MyFilter;
import com.s5.spring_boot_04_web_restfulcrud.listener.MyListener;
import com.s5.spring_boot_04_web_restfulcrud.servlet.MyServlet;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @Author: Aresong
 * @Date: 2019/4/26 22:48
 * @Version 1.0
 */
@Configuration
public class MyServerConfig {

    //配置嵌入式的Servlet容器
    @Bean
    public ConfigurableServletWebServerFactory configurableServletWebServerFactory(){
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setPort(8083);
        return factory;
    }
//    public TomcatServletWebServerFactory test(){
//        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
//        factory.setPort(8085);
//        return factory;
//    }
    //注册三大组件
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet(),"/myServlet");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return registrationBean;
    }
}
