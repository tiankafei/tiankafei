package cn.tiankafei.springbootproject.controller;

import cn.tiankafei.springbootproject.listener.SpringBootListener;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 魏双双
 * @Date 2020/5/20
 * @Version V1.0
 **/
@RestController
public class SpringBootController {

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "/online")
    public String online(HttpSession session){
        session.setAttribute("username", "zhangsan");
        return "有一个用户登录了，登录用户数量：" + SpringBootListener.onLine;
    }

}
