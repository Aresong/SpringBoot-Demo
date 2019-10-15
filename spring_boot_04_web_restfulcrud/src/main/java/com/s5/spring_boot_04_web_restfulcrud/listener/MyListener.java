package com.s5.spring_boot_04_web_restfulcrud.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Author: Aresong
 * @Date: 2019/4/26 23:36
 * @Version 1.0
 */
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextDestroyed……web应用启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed……当前web项目销毁");
    }
}
