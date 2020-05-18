package cn.tiankafei.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyViewController {

    @RequestMapping("/myview")
    public String myView(Model model){
        model.addAttribute("msb","马士兵");
        return "msb:/index";
    }
}