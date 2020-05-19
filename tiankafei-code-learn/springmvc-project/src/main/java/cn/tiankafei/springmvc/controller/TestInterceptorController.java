package cn.tiankafei.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestInterceptorController {

    @RequestMapping("test01")
    public String test01(){
        System.out.println("test01");
        return "success";
    }
}