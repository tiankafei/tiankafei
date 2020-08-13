package org.tiankafei.multidatasource.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.io.Serializable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.multidatasource.mp.entity.BlogInfoEntity;

/**
 * <p>
 * 系统的博客数据 Mapper 接口
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface BlogInfoMapper extends BaseMapper<BlogInfoEntity> {

    /**
     * 根据ID获取 系统的博客数据 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    BlogInfoEntity getBlogInfoServiceById(@Param("param") Serializable id) throws Exception;

}
