package cn.tiankafei.springmvc.view;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class MyView implements View {

    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("保存的对象是："+model);
        response.setContentType("text/html");
        response.getWriter().write("欢迎加入马士兵教育");
    }

    /**
     * 返回数据内容的类型
     * @return
     */
    public String getContentType() {
        return "text/html";
    }
}