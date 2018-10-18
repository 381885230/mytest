package com.learn.file;
import java.io.File;

public class Test3 {

    /**
     *author: itmyhome
     */
    public static void main(String[] args) {
        File file = new File("c:/上海恬馨花店.zip");
        String fileName = file.getName();
        String suffix = fileName.substring(fileName.indexOf(".")+1,fileName.length());
        System.out.println(suffix);
        file.renameTo(new File("c:/上海恬馨花店.zip"));
        System.out.println(file.getName());
    }
}