package org.tiankafei.springdemo.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LogUtil5 {
    @Pointcut("execution( public int org.tiankafei.springdemo.inter.impl.MyCalculator6.*(int,int))")
    public void myPoint(){}
    
    /**
     * 环绕通知是spring中功能最强大的通知
     * @param proceedingJoinPoint
     * @return
     */
    @Around("myPoint()")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint){
        Object[] args = proceedingJoinPoint.getArgs();
        String name = proceedingJoinPoint.getSignature().getName();
        Object proceed = null;
        try {
            System.out.println("环绕前置通知:"+name+"方法开始，参数是"+Arrays.asList(args));
            //利用反射调用目标方法，就是method.invoke()
            proceed = proceedingJoinPoint.proceed(args);
            System.out.println("环绕返回通知:"+name+"方法返回，返回值是"+proceed);
        } catch (Throwable e) {
            System.out.println("环绕异常通知"+name+"方法出现异常，异常信息是："+e);
        }finally {
            System.out.println("环绕后置通知"+name+"方法结束");
        }
        return proceed;
    }
}