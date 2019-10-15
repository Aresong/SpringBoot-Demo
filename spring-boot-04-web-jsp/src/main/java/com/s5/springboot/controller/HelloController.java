package com.s5.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Aresong
 * @Date: 2019/4/29 23:57
 * @Version 1.0
 */
@Controller
public class HelloController {
    @GetMapping("/abc")
    public String hello(){
        return "success";
    }
}
