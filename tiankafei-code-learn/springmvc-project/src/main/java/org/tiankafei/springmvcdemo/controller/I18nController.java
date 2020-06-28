package org.tiankafei.springmvcdemo.controller;

import java.util.Locale;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Controller
public class I18nController {

    @RequestMapping("/i18n")
    public String i18n(@RequestParam(value = "locale",defaultValue = "zh_CN") String localeStr, Locale locale, HttpSession session){

        Locale l = null;
        if(localeStr!=null && ! "".equals(localeStr)){
            l = new Locale(localeStr.split("_")[0],localeStr.split("_")[1]);
        }else{
            l = locale;
        }
        session.setAttribute(SessionLocaleResolver.class.getName() + ".LOCALE",l);
        return "login";
    }

    @RequestMapping("/i18nTest")
    public String i18nTest(@RequestParam(value = "locale", defaultValue = "zh_CN") String localeStr, Locale locale, HttpSession session){
        return "login";
    }
}