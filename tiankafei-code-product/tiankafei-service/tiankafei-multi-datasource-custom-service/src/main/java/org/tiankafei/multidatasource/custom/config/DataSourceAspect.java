package org.tiankafei.multidatasource.custom.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.tiankafei.multidatasource.custom.annotation.DataSource;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Aspect
@Order(1)
@Component
public class DataSourceAspect {

    @Pointcut("@annotation(org.tiankafei.multidatasource.custom.annotation.DataSource)"
            + "|| @within(org.tiankafei.multidatasource.custom.annotation.DataSource)")
    public void dsPointCut() {

    }

    @Around("dsPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        DataSource dataSource = getDataSource(point);

        if (dataSource != null) {
            DynamicDataSourceHolder.setDataSourceType(dataSource.value().name());
        }

        try {
            return point.proceed();
        } finally {
            // 销毁数据源 在执行方法之后
            DynamicDataSourceHolder.clearDataSourceType();
        }
    }

    /**
     * 获取需要切换的数据源
     */
    public DataSource getDataSource(ProceedingJoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        DataSource dataSource = AnnotationUtils.findAnnotation(signature.getMethod(), DataSource.class);
        if (dataSource != null) {
            return dataSource;
        }

        Class declaringType = signature.getDeclaringType();
        System.out.println(declaringType);
        return AnnotationUtils.findAnnotation(declaringType, DataSource.class);
    }

}
