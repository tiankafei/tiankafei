package org.tiankafei.collection.bean;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tiankafei.collection.component.CollectionComponent;
import org.tiankafei.collection.enums.ComponentTypeEnum;
import org.tiankafei.collection.param.ComponentTypeVo;
import org.tiankafei.collection.property.ComponentProperty;
import org.tiankafei.web.common.component.ApplicationContextHelper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Component
public class ComponentClient implements InitializingBean {

    /**
     * 组件集合
     */
    private Map<Integer, CollectionComponent> userExistsServiceMap = Maps.newHashMap();

    /**
     * 组件类型集合
     */
    private List<ComponentTypeVo> componentTypeList = Lists.newArrayList();

    @Autowired
    private ApplicationContextHelper applicationContextHelper;

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, CollectionComponent> beansOfType = applicationContextHelper.getBeansOfType(CollectionComponent.class);
        Set<Map.Entry<String, CollectionComponent>> entries = beansOfType.entrySet();
        for (Map.Entry<String, CollectionComponent> entry : entries) {
            CollectionComponent collectionComponent = entry.getValue();

            ComponentTypeEnum componentTypeEnum = collectionComponent.getComponentType();
            userExistsServiceMap.put(componentTypeEnum.getCode(), collectionComponent);

            ComponentTypeVo componentTypeVo = new ComponentTypeVo();
            componentTypeVo.setCode(componentTypeEnum.getCode());
            componentTypeVo.setName(componentTypeEnum.getName());
            componentTypeList.add(componentTypeVo);
        }
    }

    /**
     * 获取所有的组件类型集合
     *
     * @return
     */
    public List<ComponentTypeVo> getComponentTypeList() {
        List<ComponentTypeVo> collect = componentTypeList.stream().sorted(Comparator.comparing(ComponentTypeVo::getCode)).collect(Collectors.toList());
        collect.stream().forEach(componentTypeVo -> {
            Integer code = componentTypeVo.getCode();
            Class<? extends ComponentProperty> aClass = userExistsServiceMap.get(code).createComponentProperty().getClass();
            List<Method> methods = Arrays.asList(aClass.getMethods());
            System.out.println(aClass);
            methods.stream().forEach(method -> {

                String name = method.getName();
                if(name.startsWith("set")){
                    System.out.println(name);
                }
            });
            System.out.println("===================================");


            List<Field> fields1 = Arrays.asList(aClass.getDeclaredFields());

        });
        return collect;
    }

}
