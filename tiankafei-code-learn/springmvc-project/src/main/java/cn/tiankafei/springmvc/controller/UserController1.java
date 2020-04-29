package cn.tiankafei.springmvc.controller;

import cn.tiankafei.springmvc.entity.User1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("u")
public class UserController1 {

    Object o1 = null;
    Object o2 = null;
    Object o3 = null;
    Object o4 = null;

    @RequestMapping("update")
//    public String update(@ModelAttribute("user1") User1 user1, Model model){
    public String update(User1 user1, Model model){
        System.out.println(user1);
        o2 = model;
        //可以看到所有的model都是同一个对象
        System.out.println(o1==o2);
        //可以看到存储的user1对象也是同一个
        System.out.println(user1 == o3);
        return "success";
    }

    @RequestMapping("update1")
    public String update1(@ModelAttribute("u") User1 user1,Model model){
        System.out.println(user1);
        o2 = model;
        //可以看到所有的model都是同一个对象
        System.out.println(o1==o2);
        //可以看到存储的user对象也是同一个
        System.out.println(user1 == o4);
        return "success";
    }

    @ModelAttribute
    public void MyModelAttribute(Model model){
        o1 = model;
        User1 user1 = new User1();
        user1.setId(1);
        user1.setName("张三");
        user1.setAge(12);
        user1.setPassword("123");
        model.addAttribute("user1",user1);
        System.out.println("modelAttribute:"+user1);
        o3 = user1;
    }

    @ModelAttribute("u")
    public User1 MyModelAttribute1(Model model){
        o1 = model;
        User1 user1 = new User1();
        user1.setId(1);
        user1.setName("张三");
        user1.setAge(12);
        user1.setPassword("123");
//        model.addAttribute("user1",user1);
        System.out.println("modelAttribute:"+user1);
        o4 = user1;
        return user1;
    }

}