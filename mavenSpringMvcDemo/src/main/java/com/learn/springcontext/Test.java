package com.learn.springcontext;
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
/**
 * <p>Class:Test</p>
 * <p>Description:</p>
 * @author Liam
 * @Date [2012-9-6 上午10:41:34]
 */
public class Test {
	public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        
        //HelloBean hello = (HelloBean) context.getBean("helloBean");
        //hello.setApplicationContext(context);
        EmailEvent event = new EmailEvent("hello","boylmx@163.com","this is a email text!");
        context.publishEvent(event);
        //System.out.println();
    }
}
