package com.s5.ticket.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.stereotype.Component;

/**
 * @Author: Aresong
 * @Date: 2019/7/16 23:27
 * @Version 1.0
 */
@EnableDubbo
@Component
//dubbo的service
@Service//讲服务发布出去
public class TicketServiceImpl implements TicketService {
    public String getTicket(){
        return "cnmlgb";
    }
}
