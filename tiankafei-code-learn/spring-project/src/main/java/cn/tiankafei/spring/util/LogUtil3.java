package cn.tiankafei.spring.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LogUtil3 {

    @Before("execution( public int cn.tiankafei.spring.inter.impl.MyCalculator4.*(int,int))")
    public static void start(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        String name = joinPoint.getSignature().getName();
        System.out.println(name+"方法开始执行，参数是："+ Arrays.asList(args));
    }

    @AfterReturning(value = "execution( public int cn.tiankafei.spring.inter.impl.MyCalculator4.*(int,int))", returning = "result")
    public static void stop(JoinPoint joinPoint, Object result){
        String name = joinPoint.getSignature().getName();
        System.out.println(name+"方法执行完成，结果是：" + result);

    }

    @AfterThrowing(value = "execution( public int cn.tiankafei.spring.inter.impl.MyCalculator4.*(int,int))", throwing = "exception")
    public static void logException(JoinPoint joinPoint, Exception exception){
        String name = joinPoint.getSignature().getName();
        System.out.println(name+"方法出现异常：" + exception.getMessage());
    }

    @After("execution( public int cn.tiankafei.spring.inter.impl.MyCalculator4.*(int,int))")
    public static void end(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        System.out.println(name+"方法执行结束了......");
    }
}