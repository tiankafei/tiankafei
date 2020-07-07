package org.tiankafei.user.service;

import org.tiankafei.user.entity.SysDepartmentEntity;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.user.param.SysDepartmentQueryParam;
import org.tiankafei.user.param.SysDepartmentPageQueryParam;
import org.tiankafei.user.vo.SysDepartmentQueryVo;
import org.tiankafei.web.common.vo.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 系统部门表信息 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface SysDepartmentService extends BaseService<SysDepartmentEntity> {
    
    /**
     * 校验 系统部门表信息 是否已经存在
     *
     * @param sysDepartmentQueryParam
     * @return
     * @throws Exception
     */
    boolean checkSysDepartmentExists(SysDepartmentQueryParam sysDepartmentQueryParam) throws Exception;

    /**
     * 保存 系统部门表信息
     *
     * @param sysDepartmentQueryVo
     * @return
     * @throws Exception
     */
    Object addSysDepartment(SysDepartmentQueryVo sysDepartmentQueryVo) throws Exception;
    
    /**
     * 保存 系统部门表信息 集合
     *
     * @param sysDepartmentQueryVoList
     * @return
     * @throws Exception
     */
    boolean addSysDepartmentList(List<SysDepartmentQueryVo> sysDepartmentQueryVoList) throws Exception;

    /**
     * 修改 系统部门表信息
     *
     * @param sysDepartmentQueryVo
     * @return
     * @throws Exception
     */
    boolean updateSysDepartment(SysDepartmentQueryVo sysDepartmentQueryVo) throws Exception;

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
     * @param sysDepartmentQueryParam
     * @return
     * @throws Exception
     */
    boolean deleteSysDepartment(SysDepartmentQueryParam sysDepartmentQueryParam) throws Exception;

    /**
     * 根据ID获取 系统部门表信息 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
     SysDepartmentQueryVo getSysDepartmentById(Serializable id) throws Exception;

    /**
     * 获取 系统部门表信息 分页对象列表
     *
     * @param sysDepartmentPageQueryParam
     * @return
     * @throws Exception
     */
    Paging<SysDepartmentQueryVo> getSysDepartmentPageList(SysDepartmentPageQueryParam sysDepartmentPageQueryParam) throws Exception;

    /**
     * 获取 系统部门表信息 对象列表
     *
     * @param sysDepartmentQueryParam
     * @return
     * @throws Exception
     */
     List<SysDepartmentQueryVo> getSysDepartmentList(SysDepartmentQueryParam sysDepartmentQueryParam) throws Exception;
    
    /**
     * 计算 系统部门表信息 总记录数
     *
     * @param sysDepartmentQueryParam
     * @return
     * @throws Exception
     */
    int countSysDepartment(SysDepartmentQueryParam sysDepartmentQueryParam) throws Exception;

}