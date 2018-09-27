package com.yuanjin.string;
public class Test2 {

    public static void main(String args[]) {

    	//程序只创建了一个"Java"字符串对象，存放在常量池中，故s1 == s2结果为true，两个变量都指向了同一个对象。
    	//常量池专门用于管理在编译时被确定并被保存在已编译的.class文件中的一些数据。如字符串常量，类、方法中的常量。
        String s1 = "Java";
        String s2 = "Java";
        System.out.println(s1 == s2);  // true
        
        
//        "Java"直接量与new String("Java")的区别：前者只创建于常量池中。后者先在常量池中创建一个对象，再创建一个新的String对象于
//        堆内存中，换句话说new String("Java")创建了两个对象（“Java”第一次出现）。
//        String s3 = new String("Java");创建了两个String对象，一个存于常量池中，一个于堆内存中且由s3指向。
//        String s4 = new String("Java");由于常量池中已经存在"Java"对象，故只创建一个对象于对内存中由s4指向。
//        故s3 == s4的结果为false。
        String s3 = new String("Java");
        String s4 = new String("Java");
        System.out.println(s3 == s4);   // false
        
       // 由于常量的值在编译的时候就被确定(优化)了。在这里，"Hello"和"Java"都是常量，因此变量s6的值在编译时就可以确定。
      //  s6指向常量池中的"HelloJava"对象，故s5 == s6 的结果为true。
        String s5 = "HelloJava";
        String s6 = "Hello" + "Java";
        System.out.println(s5 == s6);  // true
        
//        s9由两个String变量相加的得到，不能在编译时就确定下来，故不能引用常量池中的对象，而是在堆中创建了一个新的String对象并由s9指向。
//        故s5 == s9 结果为false   
        String s7 = "HelloJava";
        String s8 = "Hello";
        String s9 = "Java";
        String s10 = s9 + s8;
        System.out.println(s7 == s10); // false

//        这里s7与s8位由final修饰为宏变量，编译器会把程序中所有用到该变量的地方直接替换成该变量的值，故s9编译时就确定了。指向
//        常量池中的对象。
        String s11 = "HelloJava";
        final String s12 = "Hello";
        final String s13 = "Java";
        String s14 = s12 + s13;
        System.out.println(s11 == s14); // true
        
    }
}