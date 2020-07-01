package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.tiankafei.user.entity.SysRuleInfoEntity;
import org.tiankafei.user.param.SysRuleInfoQueryParam;
import org.tiankafei.user.param.SysRuleInfoPageQueryParam;
import org.tiankafei.user.vo.SysRuleInfoQueryVo;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 角色信息表 Mapper 接口
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
@Repository
public interface SysRuleInfoMapper extends BaseMapper<SysRuleInfoEntity> {

    /**
     * 根据ID获取 角色信息表 对象
     *
     * @param id
     * @return
     */
     SysRuleInfoQueryVo getSysRuleInfoById(Serializable id);

    /**
     * 获取 角色信息表 分页对象
     *
     * @param page
     * @param sysRuleInfoPageQueryParam
     * @return
     */
     IPage<SysRuleInfoQueryVo> getSysRuleInfoPageList(@Param("page") Page page, @Param("param") SysRuleInfoPageQueryParam sysRuleInfoPageQueryParam);
    
    /**
     * 获取 角色信息表 对象列表
     *
     * @param sysRuleInfoQueryParam
     * @return
     */
     List<SysRuleInfoQueryVo> getSysRuleInfoList(@Param("param") SysRuleInfoQueryParam sysRuleInfoQueryParam);

}