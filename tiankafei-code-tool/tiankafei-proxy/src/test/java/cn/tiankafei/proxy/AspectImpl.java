package cn.tiankafei.proxy;

import cn.tiankafei.base.util.SystemTimeUtil;
import cn.tiankafei.proxy.interfaces.IAspect;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
public class AspectImpl implements IAspect {

    @Override
    public Object executeBefore(Object object, Method method, Object[] args, Map<String, Object> paramMap) {
        long currentTime = SystemTimeUtil.now();
        paramMap.put("startTime", currentTime);
        log.info("方法执行开始==============执行的类名：{}, 执行的方法：{}, 执行的参数：{}, 执行开始时间：{}", object.getClass(), method.getName(), args, currentTime);
        return null;
    }

    @Override
    public Object executeAfter(Object object, Method method, Object[] args, Map<String, Object> paramMap, Object result) {
        log.info("方法执行完成==============执行的类名：{}, 执行的方法：{}, 执行的参数：{}, 执行的结果为：{}", object.getClass(), method.getName(), args, result);
        return null;
    }

    @Override
    public Object executeThrowing(Object object, Method method, Object[] args, Map<String, Object> paramMap, Exception exception) {
        log.info("方法执行发生异常==============执行的类名：{}, 执行的方法：{}, 执行的参数：{}, 异常信息：{}", object.getClass(), method.getName(), args, exception.getMessage());
        return null;
    }

    @Override
    public Object returnBefore(Object object, Method method, Object[] args, Map<String, Object> paramMap, Object result) {
        long currentTime = (long) paramMap.get("startTime");
        long useTime = SystemTimeUtil.now() - currentTime;
        log.info("方法执行完成后的返回=============执行的类名：{}, 执行的方法：{}, 执行的参数：{}, 执行用时：{}ms, 执行的结果为：{}", object.getClass(), method.getName(), args, useTime, result);
        return null;
    }

}
