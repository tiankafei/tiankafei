package org.tiankafei.user.service;

import com.ruoyi.common.core.web.service.BaseService;
import java.io.Serializable;
import java.util.List;
import org.tiankafei.user.entity.DeptInfoEntity;
import org.tiankafei.user.param.DeptInfoCheckParam;
import org.tiankafei.user.param.DeptInfoCountParam;
import org.tiankafei.user.param.DeptInfoDeleteParam;
import org.tiankafei.user.param.DeptInfoListParam;
import org.tiankafei.user.param.DeptInfoPageParam;
import org.tiankafei.user.vo.DeptInfoVo;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 系统部门表信息 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface DeptInfoService extends BaseService<DeptInfoEntity> {

    /**
     * 校验 系统部门表信息 是否已经存在
     *
     * @param deptInfoCheckParam
     * @return
     * @throws Exception
     */
    boolean checkDeptInfoServiceExists(DeptInfoCheckParam deptInfoCheckParam) throws Exception;

    /**
     * 保存 系统部门表信息
     *
     * @param deptInfoVo
     * @return
     * @throws Exception
     */
    Long addDeptInfoService(DeptInfoVo deptInfoVo) throws Exception;

    /**
     * 批量保存 系统部门表信息
     *
     * @param deptInfoVoList
     * @return
     * @throws Exception
     */
    List<Long> batchAddDeptInfoService(List<DeptInfoVo> deptInfoVoList) throws Exception;

    /**
     * 删除 系统部门表信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteDeptInfoService(String id) throws Exception;

    /**
     * 批量删除 系统部门表信息
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteDeptInfoService(String ids) throws Exception;

    /**
     * 根据条件删除 系统部门表信息
     *
     * @param deptInfoDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteDeptInfoService(DeptInfoDeleteParam deptInfoDeleteParam) throws Exception;

    /**
     * 修改 系统部门表信息
     *
     * @param deptInfoVo
     * @return
     * @throws Exception
     */
    boolean updateDeptInfoService(DeptInfoVo deptInfoVo) throws Exception;

    /**
     * 根据ID获取 系统部门表信息 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    DeptInfoVo getDeptInfoServiceById(Serializable id) throws Exception;

    /**
     * 获取 系统部门表信息 对象列表
     *
     * @param deptInfoListParam
     * @return
     * @throws Exception
     */
    List<DeptInfoVo> getDeptInfoServiceList(DeptInfoListParam deptInfoListParam) throws Exception;

    /**
     * 获取 系统部门表信息 分页对象列表
     *
     * @param deptInfoPageParam
     * @return
     * @throws Exception
     */
    Paging<DeptInfoVo> getDeptInfoServicePageList(DeptInfoPageParam deptInfoPageParam) throws Exception;

    /**
     * 计算 系统部门表信息 总记录数
     *
     * @param deptInfoCountParam
     * @return
     * @throws Exception
     */
    Integer countDeptInfoService(DeptInfoCountParam deptInfoCountParam) throws Exception;

}
