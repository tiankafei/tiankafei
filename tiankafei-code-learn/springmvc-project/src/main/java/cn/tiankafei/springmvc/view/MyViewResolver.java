package cn.tiankafei.springmvc.view;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

public class MyViewResolver implements ViewResolver, Ordered {
    private int order = 0;
    public View resolveViewName(String viewName, Locale locale) throws Exception {

        //如果前缀是msb:开头的就进行解析
        if (viewName.startsWith("msb:")){
            System.out.println("msb:");
            return new MyView();
        }else{
            //如果不是，则直接返回null
            return null;
        }
    }

    public int getOrder() {
        return this.order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
