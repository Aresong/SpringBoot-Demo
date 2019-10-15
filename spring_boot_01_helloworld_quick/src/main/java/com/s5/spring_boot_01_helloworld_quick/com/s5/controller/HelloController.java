package com.s5.spring_boot_01_helloworld_quick.com.s5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Aresong
 * @Date: 2019/3/21 22:11
 * @Version 1.0
 */

//这个类的所有方法直接写给浏览器，（如果是对象转为json数据）
//@ResponseBody
//@Controller
@RestController//这个就是上面两个的合体
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world quick";
    }
}
