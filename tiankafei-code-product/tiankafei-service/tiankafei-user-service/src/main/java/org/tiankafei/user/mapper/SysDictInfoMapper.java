package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.tiankafei.user.entity.SysDictInfoEntity;
import org.tiankafei.user.param.SysDictInfoQueryParam;
import org.tiankafei.user.param.SysDictInfoPageQueryParam;
import org.tiankafei.user.vo.SysDictInfoQueryVo;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 系统数据字典表 Mapper 接口
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface SysDictInfoMapper extends BaseMapper<SysDictInfoEntity> {

    /**
     * 根据ID获取 系统数据字典表 对象
     *
     * @param id
     * @return
     */
     SysDictInfoQueryVo getSysDictInfoById(Serializable id);

    /**
     * 获取 系统数据字典表 分页对象
     *
     * @param page
     * @param sysDictInfoPageQueryParam
     * @return
     */
     IPage<SysDictInfoQueryVo> getSysDictInfoPageList(@Param("page") Page page, @Param("param") SysDictInfoPageQueryParam sysDictInfoPageQueryParam);
    
    /**
     * 获取 系统数据字典表 对象列表
     *
     * @param sysDictInfoQueryParam
     * @return
     */
     List<SysDictInfoQueryVo> getSysDictInfoList(@Param("param") SysDictInfoQueryParam sysDictInfoQueryParam);

}