package org.tiankafei.web.common.service;

import org.tiankafei.web.common.enums.SnowflakeEnum;

/**
 * @author tiankafei
 * @since 1.0
 **/
public interface SnowflakeService {

    /**
     * 雪花算法的枚举类
     * @return
     */
    SnowflakeEnum getSnowflakeEnum();

    /**
     * 获取雪花算法生成的id
     * @param object
     * @return
     */
    String nextStringId(Object object);

    /**
     * 获取雪花算法生成的id
     * @param object
     * @return
     */
    Long nextLongId(Object object);

}
