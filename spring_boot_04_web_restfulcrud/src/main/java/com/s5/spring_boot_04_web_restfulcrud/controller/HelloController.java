package com.s5.spring_boot_04_web_restfulcrud.controller;

import com.s5.spring_boot_04_web_restfulcrud.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author: Aresong
 * @Date: 2019/3/28 21:57
 * @Version 1.0
 */

@Controller
public class HelloController {

//    @RequestMapping({"/","/index.html"})
//    public String index() { return "index"; }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user){
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "Hello World!";
    }

    //查处一些数据，在页面展示
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","你好");
        //classpath:/template/success.html
        return "success";
    }
}
