package com.mlf.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mlf.entity.UserInfo;
import com.mlf.service.UserService;

@Controller
public class UserController {

	private UserService userService;  
	  
    public UserService getUserService() {  
        return userService;  
    }  
  
    @Autowired  
    public void setUserService(UserService userService) {  
        this.userService = userService;  
    }  
      
    //http://localhost:8080/LIS/userController/1/showUser.do  
    @RequestMapping("/{id}/showUser")  
    public String showUser(@PathVariable String id, ModelMap modelMap ,HttpServletRequest request) {  
        UserInfo u = userService.getUserInfoById(id);  
      
        if(u == null){  
            u = new UserInfo();  
            u.setUserId(1000);
            u.setUserName("test name");
        }  
        modelMap.put("user", u);  
        return "showUser";  
    }  
      
    //http://localhost:8080/LIS/userController/showUser.do?id=1  
    @RequestMapping("showUser")  
    public String showUserInfo(String id, ModelMap modelMap,HttpServletRequest request) {  
        UserInfo u = userService.getUserInfoById(id);
        if(u == null){  
            u = new UserInfo();  
            u.setUserId(1000);
            u.setUserName("test name");
        }  
        modelMap.put("user", u);  
        return "showUser";  
    }  
      
 @RequestMapping("/showUserExample")  
    public String showUsers(Model model){  
        return "redirect:/1/showUser.do";  
    }  
      
//    @RequestMapping("/userList")  
//    public String list(ModelMap model) {  
//        model.put("users", userService.getUserEntities());  
//        return "list";  
//    }  
      
    @RequestMapping("/user/{id}")  
    public String detail(@PathVariable(value = "id") String id, ModelMap model) {  
        model.put("user", userService.getUserInfoById(id));  
        return "detail";
    }   
    
}
