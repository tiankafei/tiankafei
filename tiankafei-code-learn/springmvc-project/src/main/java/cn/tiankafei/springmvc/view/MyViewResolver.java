package cn.tiankafei.springmvc.view;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class MyViewResolver implements ViewResolver, Ordered {

    private int order = 0;

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public int getOrder() {
        return this.order;
    }

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        if (viewName.startsWith("my:")) {
            return new MyView();
        } else {
            //不能处理就不要强行处理了，返回null让别的视图处理器来处理
            return null;
        }
    }
}
