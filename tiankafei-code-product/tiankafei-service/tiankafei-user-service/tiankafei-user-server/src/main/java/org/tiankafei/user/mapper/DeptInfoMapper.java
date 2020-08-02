package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.user.entity.DeptInfoEntity;
import org.tiankafei.user.param.DeptInfoCheckParam;
import org.tiankafei.user.param.DeptInfoCountParam;
import org.tiankafei.user.param.DeptInfoDeleteParam;
import org.tiankafei.user.param.DeptInfoListParam;
import org.tiankafei.user.param.DeptInfoPageParam;
import org.tiankafei.user.vo.DeptInfoVo;

/**
 * <p>
 * 系统部门表信息 Mapper 接口
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface DeptInfoMapper extends BaseMapper<DeptInfoEntity> {

    /**
     * 校验 系统部门表信息 是否已经存在
     *
     * @param deptInfoCheckParam
     * @return
     * @throws Exception
     */
    boolean checkDeptInfoServiceExists(@Param("param") DeptInfoCheckParam deptInfoCheckParam) throws Exception;

    /**
     * 保存 系统部门表信息
     *
     * @param deptInfoVo
     * @return
     * @throws Exception
     */
    Object addDeptInfoService(@Param("param") DeptInfoVo deptInfoVo) throws Exception;

    /**
     * 批量保存 系统部门表信息
     *
     * @param deptInfoVoList
     * @return
     * @throws Exception
     */
    List<Object> batchAddDeptInfoService(@Param("param") List<DeptInfoVo> deptInfoVoList) throws Exception;

    /**
     * 删除 系统部门表信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteDeptInfoService(@Param("param") String id) throws Exception;

    /**
     * 批量删除 系统部门表信息
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteDeptInfoService(@Param("param") String ids) throws Exception;

    /**
     * 根据条件删除 系统部门表信息
     *
     * @param deptInfoDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteDeptInfoService(@Param("param") DeptInfoDeleteParam deptInfoDeleteParam) throws Exception;

    /**
     * 修改 系统部门表信息
     *
     * @param deptInfoVo
     * @return
     * @throws Exception
     */
    boolean updateDeptInfoService(@Param("param") DeptInfoVo deptInfoVo) throws Exception;

    /**
     * 根据ID获取 系统部门表信息 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    DeptInfoVo getDeptInfoServiceById(@Param("param") Serializable id) throws Exception;

    /**
     * 获取 系统部门表信息 对象列表
     *
     * @param deptInfoListParam
     * @return
     * @throws Exception
     */
    List<DeptInfoVo> getDeptInfoServiceList(@Param("param") DeptInfoListParam deptInfoListParam) throws Exception;

    /**
     * 获取 系统部门表信息 分页对象列表
     *
     * @param page
     * @param deptInfoPageParam
     * @return
     * @throws Exception
     */
    IPage<DeptInfoVo> getDeptInfoServicePageList(@Param("page") Page page, @Param("param") DeptInfoPageParam deptInfoPageParam) throws Exception;

    /**
     * 计算 系统部门表信息 总记录数
     *
     * @param deptInfoCountParam
     * @return
     * @throws Exception
     */
    Integer countDeptInfoService(@Param("param") DeptInfoCountParam deptInfoCountParam) throws Exception;

}
