package com.s5.deploy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: Aresong
 * @Date: 2019/7/17 22:51
 * @Version 1.0
 */

@Controller
public class HelloController {
    @GetMapping("/cnm")
    public String hello(){
        return "hello";
    }
}
