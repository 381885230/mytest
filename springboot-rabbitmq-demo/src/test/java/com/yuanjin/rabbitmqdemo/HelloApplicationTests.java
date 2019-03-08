package com.yuanjin.rabbitmqdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yuanjin.rabbitmq.RabbitmqDemoApplication;
import com.yuanjin.rabbitmq.Sender;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RabbitmqDemoApplication.class)
public class HelloApplicationTests{

	@Autowired
	private Sender sender;

	@Test
	public void hello() throws Exception{
		sender.send();
	}
}