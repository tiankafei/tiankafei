package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.user.entity.SysDepartmentEntity;
import org.tiankafei.user.param.SysDepartmentPageQueryParam;
import org.tiankafei.user.param.SysDepartmentQueryParam;
import org.tiankafei.user.vo.SysDepartmentQueryVo;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 系统部门表信息 Mapper 接口
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface SysDepartmentMapper extends BaseMapper<SysDepartmentEntity> {

    /**
     * 根据ID获取 系统部门表信息 对象
     *
     * @param id
     * @return
     */
    SysDepartmentQueryVo getSysDepartmentById(Serializable id);

    /**
     * 获取 系统部门表信息 分页对象
     *
     * @param page
     * @param sysDepartmentPageQueryParam
     * @return
     */
    IPage<SysDepartmentQueryVo> getSysDepartmentPageList(@Param("page") Page page, @Param("param") SysDepartmentPageQueryParam sysDepartmentPageQueryParam);

    /**
     * 获取 系统部门表信息 对象列表
     *
     * @param sysDepartmentQueryParam
     * @return
     */
    List<SysDepartmentQueryVo> getSysDepartmentList(@Param("param") SysDepartmentQueryParam sysDepartmentQueryParam);

}