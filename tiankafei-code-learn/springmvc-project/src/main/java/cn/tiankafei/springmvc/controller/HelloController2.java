package cn.tiankafei.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/tiankafei")
public class HelloController2 {

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("msg", "hello,SpringMVC");
        return "hello";
    }

    /**
     * Request的其他属性值
     *  value:要匹配的请求
     *  method:限制发送请求的方式： POST GET
     *  params:表示请求要接受的参数,如果定义了这个属性，那么发送的时候必须要添加参数
     *         params有几种匹配规则
     *          1、直接写参数的名称，param1,param2
     *              params = {"username"}
     *          2、表示请求不能包含的参数，！param1
     *              params = {"!username"}
     *          3、表示请求中需要要包含的参数但是可以限制值 param1=values  param1!=value
     *              params = {"username=123","age"}
     *              params = {"username!=123","age"}
     *  headers:填写请求头信息
     *          chrome：User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.79 Safari/537.36
     *          firefox:User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:73.0) Gecko/20100101 Firefox/73.0
     *
     *  consumers:只接受内容类型是哪种的请求，相当于指定Content-Type
     *  produces:返回的内容类型 Content-Type：text/html;charset=utf-8
     *
     * @return
     */
    @RequestMapping(value = "/hello2", method = RequestMethod.POST)
    public String hello2() {
        return "success";
    }

    @RequestMapping(value = "/hello3", params = {"username!=123", "age"})
    public String hello3(String username) {
        System.out.println(username);
        return "success";
    }

    @RequestMapping(value = "/hello4", headers = {"User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36"})
    public String hello4() {
        return "success";
    }

    /**
     * @Request包含三种模糊匹配的方式，分别是：
     *  ？：能替代任意一个字符
     *  *: 能替代任意多个字符和一层路径
     *  **：能代替多层路径
     * @return
     */
    @RequestMapping(value = "/**/hello5*")
    public String hello5(){
        System.out.println("hello5");
        return "hello";
    }

    @RequestMapping(value = "/pathVariable/{name}")
    public String pathVariable(@PathVariable("name") String name){
        System.out.println(name);
        return "hello";
    }

}
