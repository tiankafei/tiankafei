package org.tiankafei.collection.bean;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tiankafei.collection.component.CollectionComponent;
import org.tiankafei.web.common.component.ApplicationContextHelper;

/**
 * @author 魏双双
 * @since 1.0
 **/
@Component
public class ComponentClient implements InitializingBean {

    private Map<Integer, CollectionComponent> userExistsServiceMap = Maps.newHashMap();

    @Autowired
    private ApplicationContextHelper applicationContextHelper;

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, CollectionComponent> beansOfType = applicationContextHelper.getBeansOfType(CollectionComponent.class);
        Set<Map.Entry<String, CollectionComponent>> entries = beansOfType.entrySet();
        for (Map.Entry<String, CollectionComponent> entry : entries) {
            CollectionComponent collectionComponent = entry.getValue();
            userExistsServiceMap.put(collectionComponent.getComponentType(), collectionComponent);
        }
    }

}
