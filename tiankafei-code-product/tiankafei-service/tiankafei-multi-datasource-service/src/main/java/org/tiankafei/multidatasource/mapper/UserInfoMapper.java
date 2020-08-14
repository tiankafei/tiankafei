package org.tiankafei.multidatasource.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.io.Serializable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.multidatasource.entity.UserInfoEntity;

/**
 * <p>
 * 用户基本信息表 Mapper 接口
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface UserInfoMapper extends BaseMapper<UserInfoEntity> {

    /**
     * 根据ID获取 用户基本信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    UserInfoEntity getUserInfoServiceById(@Param("param") Serializable id) throws Exception;

}
