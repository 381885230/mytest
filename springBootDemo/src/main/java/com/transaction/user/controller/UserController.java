package com.transaction.user.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.transaction.user.model.User;
import com.transaction.user.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	 @RequestMapping("/hello")  
     public String index() {  
          return "Hello World";  
     } 
	 
	 
	 @RequestMapping("/get")  
	 @ResponseBody
     public String get(User user) {  
		 User u=userService.getNameById(user);
         return JSONObject.toJSONString(u);     
     }
	 
	 
	 

}
