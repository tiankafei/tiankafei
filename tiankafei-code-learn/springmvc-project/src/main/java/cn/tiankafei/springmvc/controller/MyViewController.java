package cn.tiankafei.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyViewController {

    @RequestMapping("/viewhandler")
    public String myViewTest(Model model){

        List<String> vnames=new ArrayList<String>();
        vnames.add("java疯狂讲义300集");
        vnames.add("java从入门到如入土！！！");
        vnames.add("Spring,SpringMVC从入门到放弃！！！");
        vnames.add("MySql从删库到跑路！！！");
        model.addAttribute("video",vnames);
        return "my:/hello";
    }
}