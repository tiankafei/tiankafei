package org.tiankafei.general.user.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.tiankafei.general.user.entity.TkfUserLoginEntity;
import org.tiankafei.general.user.param.TkfUserLoginQueryParam;
import org.tiankafei.general.user.param.TkfUserLoginPageQueryParam;
import org.tiankafei.general.user.vo.TkfUserLoginQueryVo;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 用户登录信息表 Mapper 接口
 * </pre>
 *
 * @author tiankafei
 * @since 2020-06-30
 */
@Repository
public interface TkfUserLoginMapper extends BaseMapper<TkfUserLoginEntity> {

    /**
     * 根据ID获取 用户登录信息表 对象
     *
     * @param id
     * @return
     */
     TkfUserLoginQueryVo getTkfUserLoginById(Serializable id);

    /**
     * 获取 用户登录信息表 分页对象
     *
     * @param page
     * @param tkfUserLoginPageQueryParam
     * @return
     */
     IPage<TkfUserLoginQueryVo> getTkfUserLoginPageList(@Param("page") Page page, @Param("param") TkfUserLoginPageQueryParam tkfUserLoginPageQueryParam);
    
    /**
     * 获取 用户登录信息表 对象列表
     *
     * @param tkfUserLoginQueryParam
     * @return
     */
     List<TkfUserLoginQueryVo> getTkfUserLoginList(@Param("param") TkfUserLoginQueryParam tkfUserLoginQueryParam);

}