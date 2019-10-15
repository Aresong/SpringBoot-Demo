package com.s5.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @Author: Aresong
 * @Date: 2019/7/10 22:58
 * @Version 1.0
 */
@Service
public class ScheduledService {
    /**
     *  on the second as well as minute, hour, day of month, month and day of week.
     * 	<p>E.g. {@code "0 * * * * MON-FRI"} means once per minute on weekdays
     * **/
//    @Scheduled(cron = "0 * * * * MON-FRI")
//    @Scheduled(cron = "0,1,2,3,4 * * * * MON-FRI")//枚举
//    @Scheduled(cron = "0-4 * * * * MON-FRI")//区间
    @Scheduled(cron = "0/4 * * * * MON-FRI")//每4秒
    public void hello(){
        System.out.println("hello...");
    }
}
