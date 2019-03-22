package com.demo.aop;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 
* @ClassName: AspectConfig 
* @Description: 切面配置 
* @author yuanjin 
* @date 2018年2月28日 上午11:07:12 
*
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AspectConfig {

}