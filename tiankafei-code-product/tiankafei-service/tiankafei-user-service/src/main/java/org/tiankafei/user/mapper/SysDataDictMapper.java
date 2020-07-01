package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.tiankafei.user.entity.SysDataDictEntity;
import org.tiankafei.user.param.SysDataDictQueryParam;
import org.tiankafei.user.param.SysDataDictPageQueryParam;
import org.tiankafei.user.vo.SysDataDictQueryVo;
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
 * @since 2020-07-01
 */
@Repository
public interface SysDataDictMapper extends BaseMapper<SysDataDictEntity> {

    /**
     * 根据ID获取 系统数据字典表 对象
     *
     * @param id
     * @return
     */
     SysDataDictQueryVo getSysDataDictById(Serializable id);

    /**
     * 获取 系统数据字典表 分页对象
     *
     * @param page
     * @param sysDataDictPageQueryParam
     * @return
     */
     IPage<SysDataDictQueryVo> getSysDataDictPageList(@Param("page") Page page, @Param("param") SysDataDictPageQueryParam sysDataDictPageQueryParam);
    
    /**
     * 获取 系统数据字典表 对象列表
     *
     * @param sysDataDictQueryParam
     * @return
     */
     List<SysDataDictQueryVo> getSysDataDictList(@Param("param") SysDataDictQueryParam sysDataDictQueryParam);

}