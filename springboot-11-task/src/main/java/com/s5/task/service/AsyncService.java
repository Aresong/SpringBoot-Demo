package com.s5.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author: Aresong
 * @Date: 2019/7/9 22:59
 * @Version 1.0
 */
@Service
public class AsyncService {
    //告诉spring这是一个异步方法
    @Async
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
