package org.tiankafei.base.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

/**
 * @author tiankafei
 * @since 1.0
 */
public class JdkSpiUtil {

    public static <T> Iterator<T> service(Class<T> clazz){
        if(JdkVersionUtil.isJdk11()){
            try {
                Class<?> serviceClazz = Class.forName("java.util.ServiceLoader");
                Method method = serviceClazz.getMethod("load", clazz.getClass());
                // 静态方法反射
                Object serviceLoader = method.invoke(null, clazz);

                Method method1 = serviceLoader.getClass().getMethod("iterator");
                // 动态方法反射
                return (Iterator<T>) method1.invoke(serviceLoader);
            } catch (ClassNotFoundException | NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }else if(JdkVersionUtil.isJdk8()){
            try {
                Class<?> serviceClazz = Class.forName("sun.misc.Service");
                Method method = serviceClazz.getMethod("providers", clazz.getClass());
                return (Iterator<T>) method.invoke(null, clazz);
            } catch (ClassNotFoundException | NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
