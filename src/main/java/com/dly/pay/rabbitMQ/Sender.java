package com.dly.pay.rabbitMQ;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender implements RabbitTemplate.ConfirmCallback, ReturnCallback {
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
    }

    /**
     * 如果消息没有到exchange,则confirm回调,ack=false

如果消息到达exchange,则confirm回调,ack=true

exchange到queue成功,则不回调return

exchange到queue失败,则回调return(需设置mandatory=true,否则不回回调,消息就丢了)
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {  
            System.out.println("消息发送成功:" + correlationData);  
        } else {  
            System.out.println("消息发送失败:" + cause);  
        }  
        
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println(message.getMessageProperties().getCorrelationIdString() + " 发送失败");
        
    }

    //发送消息，不需要实现任何接口，供外部调用。
    public void send(String msg){
        
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        
        System.out.println("开始发送消息 : " + msg.toLowerCase());
        String response = rabbitTemplate.convertSendAndReceive("fanoutExchange", "f", msg, correlationId).toString();
        System.out.println("结束发送消息 : " + msg.toLowerCase());
        System.out.println("消费者响应 : " + response + " 消息处理完成");
        
        
    }
}

