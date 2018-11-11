什么是ApplicationContext? 
它是Spring的核心，Context我们通常解释为上下文环境，但是理解成容器会更好些。 
ApplicationContext则是应用的容器。

Spring把Bean（object）放在容器中，需要用就通过get方法取出来。


ApplicationEvent

是个抽象类，里面只有一个构造函数和一个长整型的timestamp。

ApplicationListener

是一个接口，里面只有一个onApplicationEvent方法。

所以自己的类在实现该接口的时候，要实装该方法。



如果在上下文中部署一个实现了ApplicationListener接口的bean,

那么每当在一个ApplicationEvent发布到 ApplicationContext时，
这个bean得到通知。其实这就是标准的Oberver设计模式。

下面给出例子：

首先创建一个ApplicationEvent实现类：

package com.spring.event;
 
import org.springframework.context.ApplicationEvent;
 
/**
 * <p>Class:EmailListEvent</p>
 * <p>Description:</p>
 * @author Liam
 * @Date [2012-9-7 上午8:42:07]
 */
public class EmailEvent extends ApplicationEvent {
	/**
	 * <p>Description：</p>
	 */
	private static final long serialVersionUID = 1L;
	public String address;  
	public String text;
	
	public EmailEvent(Object source) {
		super(source);
	}
	
	public EmailEvent(Object source, String address, String text) {
		super(source);
		this.address = address;
		this.text = text;
	}
	
	public void print(){
		System.out.println("hello spring event!");
	}
 
}
给出监听器：

package com.spring.event;
 
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
 
/**
 * <p>Class:EmailListener</p>
 * <p>Description:</p>
 * @author Liam
 * @Date [2012-9-7 上午8:44:53]
 */
public class EmailListener implements ApplicationListener {
 
	public void onApplicationEvent(ApplicationEvent  event) {
		if(event instanceof EmailEvent){
			EmailEvent emailEvent = (EmailEvent)event;
			emailEvent.print();
			System.out.println("the source is:"+emailEvent.getSource());
			System.out.println("the address is:"+emailEvent.address);
			System.out.println("the email's context is:"+emailEvent.text);
		}
		
	}
 
}
applicationContext.xml文件配置：

<bean id="emailListener" class="com.spring.event.EmailListener"></bean>

测试类：

package com.spring.event;
 
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
测试结果：
[html] view plain copy
<code class="language-html">hello spring event!  
the source is:hello  
the address is:boylmx@163.com  
the email's context is:this is a email text!  
</code>  
