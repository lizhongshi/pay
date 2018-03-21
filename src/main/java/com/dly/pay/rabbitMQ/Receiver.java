package com.dly.pay.rabbitMQ;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Cache.Channel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.dly.pay.config.RabbitMQConfig;

@Component
public class Receiver {
    
//    @RabbitListener(queues = "fanOut")
//    public String processMessage1(String msg) {
//        System.out.println(Thread.currentThread().getName() + " 接收到来自hello.queue1队列的消息：" + msg);
//        return msg.toUpperCase();
//    }
    
//    @RabbitListener(queues = "fanOut")
//    public void processMessage2(String msg) {
//        System.out.println(Thread.currentThread().getName() + " 接收到来自hello.queue2队列的消息：" + msg);
//    }
}


