package com.learn.retry;
public class TrycatchTest {
    public static void main(String [] args) {
        try{
            testRedo();
        } catch (Exception e) {
            testRedo();
            e.printStackTrace();
        }
    }

    private static void testRedo() {
        System.out.println("执行Redo代码");
        throw new RuntimeException();
    }

}
