package com.learn.genericity;

/**
 * ����ͨ���һ����ʹ�� ? ������������ʵ�Ρ�ע���ˣ��˴�������ʵ�Σ������������βΣ�
 * ��Box<?>���߼�����Box<Integer>��Box<Number>...������Box<��������ʵ��>�ĸ��ࡣ
 * �ɴˣ�������Ȼ���Զ��巺�ͷ���������ɴ�������
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