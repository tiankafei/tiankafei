package org.tiankafei.user.service;

import java.io.Serializable;
import java.util.List;
import org.tiankafei.user.entity.DeptInfoEntity;
import org.tiankafei.user.param.DeptInfoListParam;
import org.tiankafei.user.param.DeptInfoPageParam;
import org.tiankafei.user.vo.DeptInfoVo;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.web.common.vo.Paging;

/**
 * <pre>
 * 系统部门表信息 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface DeptInfoService extends BaseService<DeptInfoEntity> {

    /**
     * 校验 系统部门表信息 是否已经存在
     *
     * @param deptInfoListParam
     * @return
     * @throws Exception
     */
    boolean checkSysDepartmentExists(DeptInfoListParam deptInfoListParam) throws Exception;

    /**
     * 保存 系统部门表信息
     *
     * @param deptInfoVo
     * @return
     * @throws Exception
     */
    Object addSysDepartment(DeptInfoVo deptInfoVo) throws Exception;

    /**
     * 保存 系统部门表信息 集合
     *
     * @param deptInfoVoList
     * @return
     * @throws Exception
     */
    boolean addSysDepartmentList(List<DeptInfoVo> deptInfoVoList) throws Exception;

    /**
     * 修改 系统部门表信息
     *
     * @param deptInfoVo
     * @return
     * @throws Exception
     */
    boolean updateSysDepartment(DeptInfoVo deptInfoVo) throws Exception;

    /**
     * 删除 系统部门表信息
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean deleteSysDepartment(String ids) throws Exception;

    /**
     * 根据条件删除 系统部门表信息
     *
     * @param deptInfoListParam
     * @return
     * @throws Exception
     */
    boolean deleteSysDepartment(DeptInfoListParam deptInfoListParam) throws Exception;

    /**
     * 根据ID获取 系统部门表信息 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    DeptInfoVo getSysDepartmentById(Serializable id) throws Exception;

    /**
     * 获取 系统部门表信息 分页对象列表
     *
     * @param deptInfoPageParam
     * @return
     * @throws Exception
     */
    Paging<DeptInfoVo> getSysDepartmentPageList(DeptInfoPageParam deptInfoPageParam) throws Exception;

    /**
     * 获取 系统部门表信息 对象列表
     *
     * @param deptInfoListParam
     * @return
     * @throws Exception
     */
    List<DeptInfoVo> getSysDepartmentList(DeptInfoListParam deptInfoListParam) throws Exception;

    /**
     * 计算 系统部门表信息 总记录数
     *
     * @param deptInfoListParam
     * @return
     * @throws Exception
     */
    int countSysDepartment(DeptInfoListParam deptInfoListParam) throws Exception;

}