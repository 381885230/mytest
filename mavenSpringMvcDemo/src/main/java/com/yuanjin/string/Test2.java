package com.yuanjin.string;
public class Test2 {

    public static void main(String args[]) {

    	//����ֻ������һ��"Java"�ַ������󣬴���ڳ������У���s1 == s2���Ϊtrue������������ָ����ͬһ������
    	//������ר�����ڹ����ڱ���ʱ��ȷ�������������ѱ����.class�ļ��е�һЩ���ݡ����ַ����������ࡢ�����еĳ�����
        String s1 = "Java";
        String s2 = "Java";
        System.out.println(s1 == s2);  // true
        
        
//        "Java"ֱ������new String("Java")������ǰ��ֻ�����ڳ������С��������ڳ������д���һ�������ٴ���һ���µ�String������
//        ���ڴ��У����仰˵new String("Java")�������������󣨡�Java����һ�γ��֣���
//        String s3 = new String("Java");����������String����һ�����ڳ������У�һ���ڶ��ڴ�������s3ָ��
//        String s4 = new String("Java");���ڳ��������Ѿ�����"Java"���󣬹�ֻ����һ�������ڶ��ڴ�����s4ָ��
//        ��s3 == s4�Ľ��Ϊfalse��
        String s3 = new String("Java");
        String s4 = new String("Java");
        System.out.println(s3 == s4);   // false
        
       // ���ڳ�����ֵ�ڱ����ʱ��ͱ�ȷ��(�Ż�)�ˡ������"Hello"��"Java"���ǳ�������˱���s6��ֵ�ڱ���ʱ�Ϳ���ȷ����
      //  s6ָ�������е�"HelloJava"���󣬹�s5 == s6 �Ľ��Ϊtrue��
        String s5 = "HelloJava";
        String s6 = "Hello" + "Java";
        System.out.println(s5 == s6);  // true
        
//        s9������String������ӵĵõ��������ڱ���ʱ��ȷ���������ʲ������ó������еĶ��󣬶����ڶ��д�����һ���µ�String������s9ָ��
//        ��s5 == s9 ���Ϊfalse   
        String s7 = "HelloJava";
        String s8 = "Hello";
        String s9 = "Java";
        String s10 = s9 + s8;
        System.out.println(s7 == s10); // false

//        ����s7��s8λ��final����Ϊ���������������ѳ����������õ��ñ����ĵط�ֱ���滻�ɸñ�����ֵ����s9����ʱ��ȷ���ˡ�ָ��
//        �������еĶ���
        String s11 = "HelloJava";
        final String s12 = "Hello";
        final String s13 = "Java";
        String s14 = s12 + s13;
        System.out.println(s11 == s14); // true
        
    }
}