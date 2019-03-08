package com.yuanjin.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender{
	@Autowired
	private AmqpTemplate rabbitTemplate;
	public void send(){
		for(int i=0;i<100;i++){
			String context ="hello,time=="+System.currentTimeMillis();
			System.out.println("Sender : "+ context);
			this.rabbitTemplate.convertAndSend("hello", context);
		}
	}
}