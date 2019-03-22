package com.demo.aop;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
* @author yuanjin 
* @date 2018年2月28日 上午11:08:06 
*
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
	/**
	 * 操作类型：新增用户、删除用户
	 * @return
	 */
	public String operation();

	/**
	 * 模块名称：用户管理、发布中心
	 * @return
	 */
	public String moduleName();	

}