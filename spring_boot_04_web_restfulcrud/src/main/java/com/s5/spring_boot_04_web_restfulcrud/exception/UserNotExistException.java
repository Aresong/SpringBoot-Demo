package com.s5.spring_boot_04_web_restfulcrud.exception;

/**
 * @Author: Aresong
 * @Date: 2019/4/25 21:08
 * @Version 1.0
 */
public class UserNotExistException extends RuntimeException{
    public UserNotExistException(){
        super("用户不存在");
    }
}
