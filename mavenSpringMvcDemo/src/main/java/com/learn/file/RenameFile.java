package com.learn.file;
import java.io.File;

public class RenameFile {

    public static void main(String[] args) {
        String path="C://";
        String oldName="上海恬馨花店";
        String newName="上海恬馨花店.zip";

        rename(path,oldName,newName);
        System.out.println("重命名成功");

    }

    private static void rename(String path, String oldName, String newName) {

        if(!oldName.equals(newName)){
            File oldFile=new File(path+"/"+oldName);
            File newFile=new File(path+"/"+newName);
            if(!oldFile.exists()){
                return;
            }
            if(newFile.exists()){
                System.out.println(newName+" 已存在");
            }
            else {
                oldFile.renameTo(newFile);
            }
        }else {
            System.out.println("新文件名和旧文件名相同。。。");
        }   
    }
}
