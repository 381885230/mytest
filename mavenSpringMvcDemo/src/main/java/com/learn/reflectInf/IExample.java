package com.learn.reflectInf;
 
import java.util.Map;
 
import org.apache.ibatis.annotations.Param;
 
public interface IExample {
	public void setName(@Param("nnnnn")String name,int b);
 
	public Map<String, Object> getName();
 
	public void setDesc(String description);
 
	public String getDesc();
}