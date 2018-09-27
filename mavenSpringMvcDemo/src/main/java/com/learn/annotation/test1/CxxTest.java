package com.learn.annotation.test1;
 
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
 
/**
 * @Author: cxx
 * @Date: 2018/3/15 12:14
 */
public class CxxTest {
    @Cxx(value = "test1")
    public void test1(){
        System.out.println("test1()方法");
    }
    @Cxx("test2")
    public void test2(){
        System.out.println("test2()方法");
    }
 
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, IllegalArgumentException, InstantiationException {
        Class clazz = CxxTest.class;
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            boolean flag = method.isAnnotationPresent(Cxx.class);
            if (flag){
                Cxx c = method.getAnnotation(Cxx.class);
                System.out.println(c.value());
//                method.invoke(clazz.getInterfaces(),args);
                method.invoke(clazz.newInstance());


            }
        }
    }
}
