package com.s5.spring_boot_02_config02.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Aresong
 * @Date: 2019/3/25 22:16
 * @Version 1.0
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello Word!";
    }
}
