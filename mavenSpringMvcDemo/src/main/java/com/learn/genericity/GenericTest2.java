package com.learn.genericity;

/**
 * 类型通配符一般是使用 ? 代替具体的类型实参。注意了，此处是类型实参，而不是类型形参！
 * 且Box<?>在逻辑上是Box<Integer>、Box<Number>...等所有Box<具体类型实参>的父类。
 * 由此，我们依然可以定义泛型方法，来完成此类需求。
 * @author admin
 *
 */
public class GenericTest2 {

    public static void main(String[] args) {

        Box<String> name = new Box<String>("corn");
        Box<Integer> age = new Box<Integer>(712);
        Box<Number> number = new Box<Number>(314);

        getData(name);
        getData(age);
        getData(number);
    }

    public static void getData(Box<?> data) {
        System.out.println("data :" + data.getData());
    }

}