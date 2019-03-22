package com.demo.aop;
import java.lang.reflect.Method;
import java.text.MessageFormat;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

	
	/**
	 * 切入点
	 */
	@Pointcut("execution(public * com.demo.student.*.*(..))&&@annotation(com.demo.aop.LogAnnotation) ")
	public void entryPoint() {	}

	@After("entryPoint()")
	public void after(JoinPoint joinPoint) {
		try {
			String targetName = joinPoint.getTarget().getClass().getName();
			String methodName = joinPoint.getSignature().getName();
			Object[] arguments = joinPoint.getArgs();
			Class<?> targetClass = Class.forName(targetName);
			Method[] methods = targetClass.getMethods();
			String operation = "";
			String moduleName="";
			String logLevel="";
			for (Method method : methods) {
				if (method.getName().equals(methodName)) {
					Class<?>[] clazzs = method.getParameterTypes();
					if (clazzs.length == arguments.length) {
						operation = method.getAnnotation(LogAnnotation.class).operation();// 操作名称
						moduleName = method.getAnnotation(LogAnnotation.class).moduleName();// 模块名称
						break;
					}
				}
			}
			StringBuilder paramsBuf = new StringBuilder();
			for (Object arg : arguments) {
				paramsBuf.append(arg);
				paramsBuf.append("&");
			}

			String logContent=MessageFormat.format("用户【{0}】执行了【{1}】操作，类【{2}】，方法名【{3}】",operation,targetName,methodName,paramsBuf.toString());
			System.out.println(logContent);
			System.out.println("targetName="+targetName);
		} catch (Throwable e) {
			log.error("around " + joinPoint + " with exception : ",e);
			log.error("around " + joinPoint + " with exception : " + e.getMessage());
		}
	}
	
	
	
	
	
}