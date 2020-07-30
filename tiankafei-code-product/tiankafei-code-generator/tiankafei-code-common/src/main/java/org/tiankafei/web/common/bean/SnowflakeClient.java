package org.tiankafei.web.common.bean;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tiankafei.web.common.enums.SnowflakeEnum;
import org.tiankafei.web.common.service.SnowflakeService;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Component
public class SnowflakeClient implements InitializingBean {

    /**
     * 默认生成id的雪花算法
     */
    private Integer defaultType = SnowflakeEnum.MYBATIS_PLUS.getCode();

    private Map<Integer, SnowflakeService> snowflakeServiceMap = Maps.newHashMap();

    @Autowired
    private ApplicationContextHelper applicationContextHelper;

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, SnowflakeService> beansOfType = applicationContextHelper.getBeansOfType(SnowflakeService.class);
        Set<Map.Entry<String, SnowflakeService>> entries = beansOfType.entrySet();
        for (Map.Entry<String, SnowflakeService> entry : entries) {
            SnowflakeService snowflakeService = entry.getValue();
            snowflakeServiceMap.put(snowflakeService.getSnowflakeEnum().getCode(), snowflakeService);
        }
    }

    /**
     * 获取雪花算法生成的id
     * @return
     */
    public String nextStringId() {
        return nextStringId(null);
    }

    /**
     * 获取雪花算法生成的id
     * @param object
     * @return
     */
    public String nextStringId(Object object) {
        return nextStringId(defaultType, object);
    }

    /**
     * 获取雪花算法生成的id
     * @param type
     * @param object
     * @return
     */
    public String nextStringId(Integer type, Object object) {
        String id = snowflakeServiceMap.get(type).nextStringId(object);
        return id;
    }

    /**
     * 获取雪花算法生成的id
     * @return
     */
    public Long nextLongId() {
        return nextLongId(null);
    }

    /**
     * 获取雪花算法生成的id
     * @param object
     * @return
     */
    public Long nextLongId(Object object) {
        return nextLongId(defaultType, object);
    }

    /**
     * 获取雪花算法生成的id
     * @param type
     * @param object
     * @return
     */
    public Long nextLongId(Integer type, Object object) {
        Long id = snowflakeServiceMap.get(type).nextLongId(object);
        return id;
    }

}
