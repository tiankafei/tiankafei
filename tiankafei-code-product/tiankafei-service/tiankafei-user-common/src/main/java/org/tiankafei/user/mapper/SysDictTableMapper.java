package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.tiankafei.user.entity.SysDictTableEntity;
import org.tiankafei.user.param.SysDictTableQueryParam;
import org.tiankafei.user.param.SysDictTablePageQueryParam;
import org.tiankafei.user.vo.SysDictTableQueryVo;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 系统数据字典的数据表 Mapper 接口
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface SysDictTableMapper extends BaseMapper<SysDictTableEntity> {

    /**
     * 根据ID获取 系统数据字典的数据表 对象
     *
     * @param id
     * @return
     */
     SysDictTableQueryVo getSysDictTableById(Serializable id);

    /**
     * 获取 系统数据字典的数据表 分页对象
     *
     * @param page
     * @param sysDictTablePageQueryParam
     * @return
     */
     IPage<SysDictTableQueryVo> getSysDictTablePageList(@Param("page") Page page, @Param("param") SysDictTablePageQueryParam sysDictTablePageQueryParam);
    
    /**
     * 获取 系统数据字典的数据表 对象列表
     *
     * @param sysDictTableQueryParam
     * @return
     */
     List<SysDictTableQueryVo> getSysDictTableList(@Param("param") SysDictTableQueryParam sysDictTableQueryParam);

}