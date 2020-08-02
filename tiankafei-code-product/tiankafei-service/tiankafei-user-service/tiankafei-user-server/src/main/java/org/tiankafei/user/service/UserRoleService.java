package org.tiankafei.user.service;

import java.io.Serializable;
import java.util.List;
import org.tiankafei.user.entity.UserRoleEntity;
import org.tiankafei.user.param.UserRoleCheckParam;
import org.tiankafei.user.param.UserRoleCountParam;
import org.tiankafei.user.param.UserRoleDeleteParam;
import org.tiankafei.user.param.UserRoleListParam;
import org.tiankafei.user.param.UserRolePageParam;
import org.tiankafei.user.vo.UserRoleVo;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 用户拥有的角色关系表 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface UserRoleService extends BaseService<UserRoleEntity> {

    /**
     * 校验 用户拥有的角色关系表 是否已经存在
     *
     * @param userRoleCheckParam
     * @return
     * @throws Exception
     */
    boolean checkUserRoleServiceExists(UserRoleCheckParam userRoleCheckParam) throws Exception;

    /**
     * 保存 用户拥有的角色关系表
     *
     * @param userRoleVo
     * @return
     * @throws Exception
     */
    Long addUserRoleService(UserRoleVo userRoleVo) throws Exception;

    /**
     * 批量保存 用户拥有的角色关系表
     *
     * @param userRoleVoList
     * @return
     * @throws Exception
     */
    List<Long> batchAddUserRoleService(List<UserRoleVo> userRoleVoList) throws Exception;

    /**
     * 删除 用户拥有的角色关系表
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteUserRoleService(String id) throws Exception;

    /**
     * 删除 用户拥有的角色关系表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteUserRoleService(String ids) throws Exception;

    /**
     * 根据条件删除 用户拥有的角色关系表
     *
     * @param userRoleDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteUserRoleService(UserRoleDeleteParam userRoleDeleteParam) throws Exception;

    /**
     * 修改 用户拥有的角色关系表
     *
     * @param userRoleVo
     * @return
     * @throws Exception
     */
    boolean updateUserRoleService(UserRoleVo userRoleVo) throws Exception;

    /**
     * 根据ID获取 用户拥有的角色关系表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    UserRoleVo getUserRoleServiceById(Serializable id) throws Exception;

    /**
     * 获取 用户拥有的角色关系表 对象列表
     *
     * @param userRoleListParam
     * @return
     * @throws Exception
     */
    List<UserRoleVo> getUserRoleServiceList(UserRoleListParam userRoleListParam) throws Exception;

    /**
     * 获取 用户拥有的角色关系表 分页对象列表
     *
     * @param userRolePageParam
     * @return
     * @throws Exception
     */
    Paging<UserRoleVo> getUserRoleServicePageList(UserRolePageParam userRolePageParam) throws Exception;

    /**
     * 计算 用户拥有的角色关系表 总记录数
     *
     * @param userRoleCountParam
     * @return
     * @throws Exception
     */
    Integer countUserRoleService(UserRoleCountParam userRoleCountParam) throws Exception;

}
