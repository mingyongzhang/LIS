package com.mlf.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mlf.entity.UserInfo;
import com.mlf.service.IUserService;

@Controller
public class UserController {

	private IUserService userService;  
	  
    public IUserService getUserService() {  
        return userService;  
    }  
  
    @Autowired  
    public void setUserService(IUserService userService) {  
        this.userService = userService;  
    }
    
    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public void showUser(HttpServletResponse response) throws IOException {
        response.getWriter().print("<h1>Hello SpringMVC</h1>");
        response.flushBuffer();
    }
    
    //http://localhost:8080/LIS/UserController/1/showUser.do
    @RequestMapping("/{id}/showUser")
    public String showUser(@PathVariable int id, ModelMap modelMap ,HttpServletRequest request) {  
    	UserInfo u = userService.getUserInfoById(id);  
      
        if(u == null){  
            u = new UserInfo();  
            u.setUserId(0);
            u.setUserName("showUserTest");  
        }  
        modelMap.put("user", u);  
        return "showUser";  
    }
    
    //http://localhost:8080/LIS/UserController/showUser.do?id=1
    @RequestMapping("showUser")
    public String showUserEntity(int id, ModelMap modelMap,HttpServletRequest request) {  
        UserInfo u = userService.getUserInfoById(id);  
        if(u == null){  
            u = new UserInfo();  
            u.setUserId(0);
            u.setUserName("showUserTest");
        }  
        modelMap.put("user", u);
        return "showUser";
    }
    
    @RequestMapping("/showUserExample")  
    public String showUsers(Model model){  
        return "redirect:/1/showUser.do";  
    }  
      
  //http://localhost:8080/LIS/UserController/userList
    @RequestMapping("/userList")
    public String list(ModelMap model) {  
        model.put("users", userService.getUserInfoList());  
        return "list";
    }  
      
    @RequestMapping("/user/{id}")  
    public String detail(@PathVariable(value = "id") int id, ModelMap model) {  
        model.put("user", userService.getUserInfoById(id));
        return "detail";  
    }  
    
}
