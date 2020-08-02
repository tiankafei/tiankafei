package org.tiankafei.web.common.bean;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tiankafei.web.common.enums.DistributedIdEnum;
import org.tiankafei.web.common.service.DistributedIdService;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Component
public class DistributedIdClient implements InitializingBean {

    /**
     * 默认生成id的雪花算法
     */
    private Integer defaultType = DistributedIdEnum.MYBATIS_PLUS_SNOWFLAKE.getCode();

    private Map<Integer, DistributedIdService> distributedIdServiceMap = Maps.newHashMap();

    @Autowired
    private ApplicationContextHelper applicationContextHelper;

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, DistributedIdService> beansOfType = applicationContextHelper.getBeansOfType(DistributedIdService.class);
        Set<Map.Entry<String, DistributedIdService>> entries = beansOfType.entrySet();
        for (Map.Entry<String, DistributedIdService> entry : entries) {
            DistributedIdService distributedIdService = entry.getValue();
            distributedIdServiceMap.put(distributedIdService.getDistributedIdType().getCode(), distributedIdService);
        }
    }

    /**
     * 获取雪花算法生成的id
     *
     * @return
     */
    public String nextStringId() {
        return nextStringId(null);
    }

    /**
     * 获取雪花算法生成的id
     *
     * @param object
     * @return
     */
    public String nextStringId(Object object) {
        return nextStringId(defaultType, object);
    }

    /**
     * 获取雪花算法生成的id
     *
     * @param type
     * @param object
     * @return
     */
    public String nextStringId(Integer type, Object object) {
        String id = distributedIdServiceMap.get(type).nextStringId(object);
        return id;
    }

    /**
     * 获取雪花算法生成的id
     *
     * @return
     */
    public Long nextLongId() {
        return nextLongId(null);
    }

    /**
     * 获取雪花算法生成的id
     *
     * @param object
     * @return
     */
    public Long nextLongId(Object object) {
        return nextLongId(defaultType, object);
    }

    /**
     * 获取雪花算法生成的id
     *
     * @param type
     * @param object
     * @return
     */
    public Long nextLongId(Integer type, Object object) {
        Long id = distributedIdServiceMap.get(type).nextLongId(object);
        return id;
    }

}
