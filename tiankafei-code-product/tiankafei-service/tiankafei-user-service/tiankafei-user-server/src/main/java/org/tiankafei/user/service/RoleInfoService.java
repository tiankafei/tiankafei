package org.tiankafei.user.service;

import com.ruoyi.common.core.web.service.BaseService;
import java.io.Serializable;
import java.util.List;
import org.tiankafei.user.entity.RoleInfoEntity;
import org.tiankafei.user.param.RoleInfoCheckParam;
import org.tiankafei.user.param.RoleInfoCountParam;
import org.tiankafei.user.param.RoleInfoDeleteParam;
import org.tiankafei.user.param.RoleInfoListParam;
import org.tiankafei.user.param.RoleInfoPageParam;
import org.tiankafei.user.vo.RoleInfoVo;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 角色信息表 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface RoleInfoService extends BaseService<RoleInfoEntity> {

    /**
     * 校验 角色信息表 是否已经存在
     *
     * @param roleInfoCheckParam
     * @return
     * @throws Exception
     */
    boolean checkRoleInfoServiceExists(RoleInfoCheckParam roleInfoCheckParam) throws Exception;

    /**
     * 保存 角色信息表
     *
     * @param roleInfoVo
     * @return
     * @throws Exception
     */
    Long addRoleInfoService(RoleInfoVo roleInfoVo) throws Exception;

    /**
     * 批量保存 角色信息表
     *
     * @param roleInfoVoList
     * @return
     * @throws Exception
     */
    List<Long> batchAddRoleInfoService(List<RoleInfoVo> roleInfoVoList) throws Exception;

    /**
     * 删除 角色信息表
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteRoleInfoService(String id) throws Exception;

    /**
     * 批量删除 角色信息表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteRoleInfoService(String ids) throws Exception;

    /**
     * 根据条件删除 角色信息表
     *
     * @param roleInfoDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteRoleInfoService(RoleInfoDeleteParam roleInfoDeleteParam) throws Exception;

    /**
     * 修改 角色信息表
     *
     * @param roleInfoVo
     * @return
     * @throws Exception
     */
    boolean updateRoleInfoService(RoleInfoVo roleInfoVo) throws Exception;

    /**
     * 根据ID获取 角色信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    RoleInfoVo getRoleInfoServiceById(Serializable id) throws Exception;

    /**
     * 获取 角色信息表 对象列表
     *
     * @param roleInfoListParam
     * @return
     * @throws Exception
     */
    List<RoleInfoVo> getRoleInfoServiceList(RoleInfoListParam roleInfoListParam) throws Exception;

    /**
     * 获取 角色信息表 分页对象列表
     *
     * @param roleInfoPageParam
     * @return
     * @throws Exception
     */
    Paging<RoleInfoVo> getRoleInfoServicePageList(RoleInfoPageParam roleInfoPageParam) throws Exception;

    /**
     * 计算 角色信息表 总记录数
     *
     * @param roleInfoCountParam
     * @return
     * @throws Exception
     */
    Integer countRoleInfoService(RoleInfoCountParam roleInfoCountParam) throws Exception;

}
