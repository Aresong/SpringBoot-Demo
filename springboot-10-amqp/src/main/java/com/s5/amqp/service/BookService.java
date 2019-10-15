package com.s5.amqp.service;

import com.s5.amqp.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @Author: Aresong
 * @Date: 2019/7/3 23:35
 * @Version 1.0
 */
@Service
public class BookService {

    @RabbitListener(queues = "s5.news")
    public void receive(Book book){
        System.out.println("收到消息"+book);
    }

    @RabbitListener(queues = "s5")
    public void receive02(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }

}
