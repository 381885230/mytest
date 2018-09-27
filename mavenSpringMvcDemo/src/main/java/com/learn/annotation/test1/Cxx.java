package com.learn.annotation.test1;
 
import java.lang.annotation.*;
 
/**
 * @Author: cxx
 * @Date: 2018/3/15 11:47
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Cxx {
    String value() default "haha";
 
}
