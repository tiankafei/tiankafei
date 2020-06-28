package org.tiankafei.springbootdemo.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author 魏双双
 * @Date 2020/5/20
 * @Version V1.0
 **/
@Slf4j
//@WebServlet(name = "springBootServlet", urlPatterns = "/*")
public class SpringBootServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        log.info("执行了 springBootServlet 的初始化--------------------------");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        log.info("请求的url：{}", requestURI);
        log.info("执行了 springBootServlet 的过滤：doGet--------------------------");
    }

}
