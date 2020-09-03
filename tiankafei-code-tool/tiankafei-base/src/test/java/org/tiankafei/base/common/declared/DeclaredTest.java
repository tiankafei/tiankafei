package org.tiankafei.base.common.declared;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author tiankafei
 * @Date 2020/3/17
 * @Version V1.0
 **/
@Slf4j
public class DeclaredTest {

    /**
     * 测试获取类属性的方法
     */
    @Test
    public void testGetClassField() {
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();
        //获取当前类及所有父类的修饰符是public的属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
            System.out.println(field.getType());
        }
        System.out.println("===========================");
        //获取当前类的所有的属性，不会获取父类的属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field.getName());
            System.out.println(field.getType());
        }
    }

    /**
     * 私有属性无需set方法进行赋值
     *
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    @Test
    public void testPrivateFieldSetValue() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();
        //获取当前类的所有的属性，不会获取父类的属性
        Field declaredFields = clazz.getDeclaredField("userService");
        //如果属性是私有的，必须设置为true，才能进入赋值
        declaredFields.setAccessible(true);
        declaredFields.set(userController, declaredFields.getType().newInstance());
        System.out.println(userController.getUserService());
    }

    /**
     * 公共属性赋值
     *
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    @Test
    public void testPublicFieldSetValue() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();
        //获取当前类的所有的属性，不会获取父类的属性
        Field declaredFields = clazz.getDeclaredField("service");
        declaredFields.set(userController, declaredFields.getType().newInstance());
        System.out.println(userController.getService());
    }

    /**
     * 测试私有属性通过set方法赋值
     *
     * @throws NoSuchFieldException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */
    @Test
    public void testPrivateFieldFromSetToValue() throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();
        //获取当前类的所有的属性，不会获取父类的属性
        Field declaredFields = clazz.getDeclaredField("userService");
        //如果属性是私有的，必须设置为true，才能进入赋值
        declaredFields.setAccessible(true);
        String name = declaredFields.getName();
        name = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
        Method method = clazz.getMethod(name, declaredFields.getType());
        method.invoke(userController, declaredFields.getType().newInstance());
        System.out.println(userController.getUserService());
    }

    /**
     * 测试私有属性通过注解赋值
     */
    @Test
    public void testPrivateFieldFromAnnotationToValue() {
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();

        Stream.of(clazz.getDeclaredFields()).forEach(field -> {
            field.setAccessible(true);
            Autowired annotation = field.getAnnotation(Autowired.class);
            if (annotation != null) {
                try {
                    field.set(userController, field.getType().newInstance());
                    System.out.println(userController.getUsService());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
