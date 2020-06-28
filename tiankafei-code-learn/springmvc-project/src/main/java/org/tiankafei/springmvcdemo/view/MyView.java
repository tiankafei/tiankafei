package org.tiankafei.springmvcdemo.view;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * 自定义视图
 */
public class MyView implements View {

    //返回的文本类型：text/html
    @Override
    public String getContentType() {
        return "text/html";
    }

   
     // 渲染视图:在这个方法中写你对这个视图的渲染效果
    @Override
    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        System.out.println("方法中保存的数据：" + map);
        httpServletResponse.setContentType("text/html");
        PrintWriter out = httpServletResponse.getWriter();
        out.write("<h3>精彩内容即将呈现...Loading</h3>");
        List<Object> lists= (List<Object>) map.get("video");
        out.write("<ul>");
        for(Object object:lists){
            out.write("<li><a href='download'>"+object+"</a></li>");
        }
        out.write("</ul>");
    }
}