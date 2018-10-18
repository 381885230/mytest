package com.learn.file;
//File oldFile = new File(oldFileName);//包括路径
//oldFile.renameTo(new File(newFileName);//包含路径
 
import java.io.File;
 
public class RenameFilename {
	static File file;
	static String path = "C:/";
	static String picName;
	static String newName;
 
	public static void main(String[] args) {
		singleChange();//改一个文件
//		moreChange();//循环多个
	}
	
	static void singleChange(){
		picName = "上海恬馨花店";
		newName = "big0.zip";
		file=new File(path + picName); //指定文件名及路径
		
		if (file.renameTo(new File(path+newName))) {
			System.out.println("修改成功!");
		} 
		else{
			System.out.println("修改失败");
		}
		
	}
	
	static void moreChange(){
		for(int i=1; i<=822; i++){
			if(i>99){
				picName = "big0" + i +".bmp";
				newName = "big0" + i +".jpg";
			}
			else if(i>9){
				picName = "big00" + i + ".bmp";
				newName = "big00" + i +".jpg";
			}
			else{
				picName = "big000" + i + ".bmp";
				newName = "big000" + i +".jpg";
			}
			file=new File(path + picName); //指定文件名及路径
 
			//改名
			if (file.renameTo(new File(path+newName))) {
				System.out.println("修改"+ i +"成功!");
			} 
			else{
				System.out.println("修改失败");
			}
			
		}
		
	}
 
}
