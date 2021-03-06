package org.tiankafei.web.common.service.impl;

import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.web.common.enums.DistributedIdEnum;
import org.tiankafei.web.common.service.DistributedIdService;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Service
public class MyBatisPlusSnowflakeServiceImpl implements DistributedIdService {

    /**
     * mybatis-plus的雪花算法生成类
     */
    @Autowired
    private DefaultIdentifierGenerator defaultIdentifierGenerator;

    @Override
    public DistributedIdEnum getDistributedIdType() {
        return DistributedIdEnum.MYBATIS_PLUS_SNOWFLAKE;
    }

    @Override
    public String nextStringId(Object object) {
        return String.valueOf(nextLongId(object));
    }

    @Override
    public Long nextLongId(Object object) {
        return defaultIdentifierGenerator.nextId(object);
    }

}
