package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.user.entity.DeptInfoEntity;
import org.tiankafei.user.param.DeptInfoListParam;
import org.tiankafei.user.param.DeptInfoPageParam;
import org.tiankafei.user.vo.DeptInfoVo;

/**
 * <pre>
 * 系统部门表信息 Mapper 接口
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface DeptInfoMapper extends BaseMapper<DeptInfoEntity> {

    /**
     * 根据ID获取 系统部门表信息 对象
     *
     * @param id
     * @return
     */
    DeptInfoVo getSysDepartmentById(Serializable id);

    /**
     * 获取 系统部门表信息 分页对象
     *
     * @param page
     * @param deptInfoPageParam
     * @return
     */
    IPage<DeptInfoVo> getSysDepartmentPageList(@Param("page") Page page, @Param("param") DeptInfoPageParam deptInfoPageParam);

    /**
     * 获取 系统部门表信息 对象列表
     *
     * @param deptInfoListParam
     * @return
     */
    List<DeptInfoVo> getSysDepartmentList(@Param("param") DeptInfoListParam deptInfoListParam);

}