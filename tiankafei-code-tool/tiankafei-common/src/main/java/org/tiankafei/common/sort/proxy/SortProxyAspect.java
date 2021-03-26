package org.tiankafei.common.sort.proxy;

import org.tiankafei.proxy.IAspect;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Author 魏双双
 * @Date 2020/5/22
 * @Version V1.0
 **/
@Slf4j
public class SortProxyAspect implements IAspect {

    private String funName;

    public SortProxyAspect(String funName) {
        this.funName = funName;
    }

    @Override
    public Object executeBefore(Object object, Method method, Object[] args, Map<String, Object> paramMap) {
        log.info("{}：浮点型：从小到大：start============", this.funName);
        return null;
    }

    @Override
    public Object executeAfter(Object object, Method method, Object[] args, Map<String, Object> paramMap, Object result) {
        log.info("{}：浮点型：从小到大：finished============", this.funName);
        return null;
    }

    @Override
    public Object executeThrowing(Object object, Method method, Object[] args, Map<String, Object> paramMap, Exception exception) {
        return null;
    }

    @Override
    public Object returnBefore(Object object, Method method, Object[] args, Map<String, Object> paramMap, Object result) {
        return null;
    }
}
