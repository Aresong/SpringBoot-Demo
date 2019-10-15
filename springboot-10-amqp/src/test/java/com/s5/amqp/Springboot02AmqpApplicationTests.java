package com.s5.amqp;

import com.s5.amqp.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot02AmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void createExchange(){
        amqpAdmin.declareExchange(new DirectExchange("amqpAdmin"));
        System.out.println("创建exchange【amqpAdmin】success");
    }

    @Test
    public void createQueue(){
        amqpAdmin.declareQueue(new Queue("amqpAdmin.queue"));
        System.out.println("创建queue【amqpAdmin.queue】success");
    }

    @Test
    public void createBinding(){
        amqpAdmin.declareBinding(new Binding("amqpAdmin.queue",Binding.DestinationType.QUEUE,"amqpAdmin","amqp.haha",null));
        System.out.println("创建【Binding】success");
    }

    /**
     * 1.单播（点对点）
     * **/
    @Test
    public void contextLoads() {
        //Message需要自己构造一个；定义消息体内容和消息头
//        rabbitTemplate.send(exchange,routeKey,message);
        //object默认当成消息体,只需要传入要发送的对象，自动序列化发送给RabbitMQ
//        rabbitTemplate.convertAndSend(exchange,routeKey,object);
        Map<String,Object> map = new HashMap();
        map.put("msg","this is the first message");
        map.put("data", Arrays.asList("helloworld",123,true));
        //对象被默认序列化以后发送出去
        rabbitTemplate.convertAndSend("exchange.direct","s5.news",map);
    }

    //接收数据，如何将数据自动转为json发送出去
    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("s5.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    /**
     * 广播
     * **/
    @Test
    public void sendMsg(){
        Book book = new Book("三国演义","罗贯中");
        rabbitTemplate.convertAndSend("exchange.fanout","",book);
    }

}
