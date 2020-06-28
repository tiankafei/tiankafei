package org.tiankafei.springmvcdemo.controller;

import org.tiankafei.springmvcdemo.exception.UserNameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExceptionController {

    @RequestMapping("/exception1")
    public String exception(){
        System.out.println("exception.......");
        return "success";
    }
    @RequestMapping("/exception2")
    public String exception2(String username){
        System.out.println("exception2222.......");
        if ("admin".equals(username)){
            return "success";
        }else{
            throw new UserNameException();
        }
    }

    @RequestMapping(value = "/exception3",method = RequestMethod.POST)
    public String exception3(String username){
        System.out.println("exception3.......");
        return "success";
    }
}