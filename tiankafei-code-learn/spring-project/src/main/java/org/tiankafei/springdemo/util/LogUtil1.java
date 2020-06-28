package org.tiankafei.springdemo.util;

import java.lang.reflect.Method;
import java.util.Arrays;

public class LogUtil1 {

    public static void start(Method method, Object ... objects){
//        System.out.println("XXX方法开始执行，使用的参数是："+ Arrays.asList(objects));
        System.out.println(method.getName()+"方法开始执行，参数是："+ Arrays.asList(objects));
    }

    public static void stop(Method method,Object ... objects){
//        System.out.println("XXX方法执行结束，结果是："+ Arrays.asList(objects));
        System.out.println(method.getName()+"方法开始执行，参数是："+ Arrays.asList(objects));

    }

    public static void logException(Method method,Exception e){
        System.out.println(method.getName()+"方法出现异常："+ e.getMessage());
    }
    
    public static void end(Method method){
        System.out.println(method.getName()+"方法执行结束了......");
    }
}