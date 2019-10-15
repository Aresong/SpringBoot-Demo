package com.s5.spring_boot_04_web_restfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author: Aresong
 * @Date: 2019/4/12 22:51
 * @Version 1.0
 */
@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
//    @RequestMapping(value = "/user/login",method = RequestMethod.POST)//老写法
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,HttpSession session){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            //登陆成功,防止表单重复提交
            session.setAttribute("loginUser","admin");
            return "redirect:/main.html";
        }else{
            //登录失败
            map.put("msg","用户名密码错误");
            return "login.html";
        }
    }
}
