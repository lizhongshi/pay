package com.dly.pay.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class RabbitMQConfig {
	 @Bean
	    public Queue queue1() {
	        return new Queue("hello.queue1",false);
	    }
	 @Bean
	    public Queue queue2() {
	        return new Queue("hello.queue2");
	    }
	 @Bean
	    public Queue fanOut() {
	        return new Queue("fanOut");
	    }
	//声明交互器
	    @Bean
	    TopicExchange topicExchange() {
	        return new TopicExchange("topicExchange");
	    }
//		//声明直连交互器
//	    @Bean
//	    DirectExchange directExchange  () {
//	        return new DirectExchange("directExchange");
//	    }
	  //声明直连交互器
	    @Bean
	    FanoutExchange fanoutExchange() {
	        return new FanoutExchange("fanoutExchange");
	    }
	  //绑定
	    @Bean
	    public Binding binding1() {
	        return BindingBuilder.bind(queue1()).to(topicExchange()).with("key.1");
	    }
	    
//	    @Bean
//	    public Binding binding2() {
//	        return BindingBuilder.bind(queue2()).to(topicExchange()).with("key.#");
//	    }
	    
	    @Bean
	    public Binding binding3() {
	        return BindingBuilder.bind(fanOut()).to(fanoutExchange());
	    }
}
