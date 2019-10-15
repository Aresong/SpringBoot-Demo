package com.s5.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.s5.ticket.service.TicketService;
import org.springframework.stereotype.Service;

/**
 * @Author: Aresong
 * @Date: 2019/7/16 23:29
 * @Version 1.0
 */
@Service
public class UserService {

    @Reference
    TicketService ticketService;

    public void hello(){
        String ticket = ticketService.getTicket();
        System.out.println("买你妈了个逼："+ticket);
    }
}
