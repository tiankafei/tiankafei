package org.tiankafei.springbootdemo.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author 魏双双
 * @Date 2020/5/20
 * @Version V1.0
 **/
@Slf4j
public class SpringBootListener implements HttpSessionListener {

    public static int onLine = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("有一个用户登录了，登录用户数量：{}", onLine++);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("有一个用户退出了，登录用户数量：{}", onLine--);
    }
}
