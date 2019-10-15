package com.s5.spring_boot_04_web_restfulcrud.controller;

import com.s5.spring_boot_04_web_restfulcrud.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Aresong
 * @Date: 2019/4/25 21:56
 * @Version 1.0
 */
//在springmvc中要成为异常处理器处理器，需要使用@ControllerAdvice
@ControllerAdvice
public class MyExceptionHandler {

    //1.浏览器客户端返回的都是json，以下注释代码不是自适应的
/*    @ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map<String,Object> handleException(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        return map;
    }*/

    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        //传入我们自己的错误代码4xx 5xx
        /**
         * Integer statusCode = (Integer) request
         .getAttribute("javax.servlet.error.status_code");
         */
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        request.setAttribute("ext",map);
        //转发给BasicErrorController
        return "forward:/error";
    }
}
