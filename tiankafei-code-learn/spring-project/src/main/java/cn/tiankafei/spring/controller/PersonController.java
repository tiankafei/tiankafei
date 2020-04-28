package cn.tiankafei.spring.controller;

import org.springframework.stereotype.Controller;

@Controller
public class PersonController {
    public PersonController() {
        System.out.println("创建对象");
    }
}