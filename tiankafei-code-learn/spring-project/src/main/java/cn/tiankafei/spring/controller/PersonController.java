package cn.tiankafei.spring.controller;

import cn.tiankafei.spring.service.impl.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

    public PersonController() {
        System.out.println("创建对象");
    }

    public void getPerson(){
        personService.getPerson();
    }
}