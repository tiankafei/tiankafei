package org.tiankafei.springbootdemo.controller;

import org.tiankafei.springbootdemo.listener.SpringBootListener;
import org.tiankafei.springbootdemo.service.SpringBootService;
import org.tiankafei.springbootdemo.spi.IService;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Service;

/**
 * @Author 魏双双
 * @Date 2020/5/20
 * @Version V1.0
 **/
@RestController
public class SpringBootController {

    @Autowired
    private SpringBootService springBootService;

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "/online")
    public String online(HttpSession session){
        session.setAttribute("username", "zhangsan");
        return "有一个用户登录了，登录用户数量：" + SpringBootListener.onLine;
    }

    @RequestMapping(value = "/getAllData")
    public List<Map<String, Object>> getAllData() {
        List<Map<String, Object>> allData = springBootService.getAllData();
        return allData;
    }

    @RequestMapping(value = "/spi/{name}")
    public String javaspi(@PathVariable(value = "name") String name){
        Iterator<IService> providers = Service.providers(IService.class);
        IService<String, String> service = providers.next();
        return service.apply(name);
    }

}
