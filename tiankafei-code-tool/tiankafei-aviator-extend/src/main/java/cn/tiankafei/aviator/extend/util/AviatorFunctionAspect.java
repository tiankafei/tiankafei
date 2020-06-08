package cn.tiankafei.aviator.extend.util;

import cn.tiankafei.proxy.IAspect;
import com.googlecode.aviator.runtime.type.AviatorJavaType;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author 魏双双
 * @Date 2020/6/5
 * @Version V1.0
 **/
@Slf4j
public class AviatorFunctionAspect implements IAspect {
    @Override
    public Object executeBefore(Object object, Method method, Object[] args, Map<String, Object> paramMap) {
        try {
            if(args.length > 0){
                String name = method.getName();
                if("call".equals(name)){
                    Map<String, Object> env = (Map<String, Object>) args[0];
                    log.info("函数执行参数: {}", env);

                    Method getName = object.getClass().getMethod("getName");
                    String funName = getName.invoke(object).toString();
                    log.info("执行的函数名称: {}", funName);

                    if(args.length > 1){
                        List<Object> paramList = new ArrayList<>();
                        for (int index = 1, length = args.length; index < length; index++) {
                            if(args[index] instanceof AviatorJavaType){
                                AviatorJavaType aviatorJavaType = (AviatorJavaType) args[index];
                                paramList.add(aviatorJavaType.getName());
                            }else if(args[index] instanceof AviatorObject){
                                AviatorObject aviatorObject = (AviatorObject) args[index];
                                Object value = aviatorObject.getValue(env);
                                paramList.add(value);
                            }
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object executeAfter(Object object, Method method, Object[] args, Map<String, Object> paramMap, Object result) {
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
