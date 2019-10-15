package com.s5.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAsync
@SpringBootApplication
public class Springboot11TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot11TaskApplication.class, args);
    }

}
