package com.yuanjin.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues ="hello")
public class Receiver{
	@RabbitHandler
	public void process(String hello){
		System.out.println("Receiver : " + hello+",revice time="+System.currentTimeMillis());
	}
}