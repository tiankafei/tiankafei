package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.user.entity.UserRoleEntity;
import org.tiankafei.user.param.UserRoleCheckParam;
import org.tiankafei.user.param.UserRoleCountParam;
import org.tiankafei.user.param.UserRoleDeleteParam;
import org.tiankafei.user.param.UserRoleListParam;
import org.tiankafei.user.param.UserRolePageParam;
import org.tiankafei.user.vo.UserRoleVo;

/**
 * <p>
 * 用户拥有的角色关系表 Mapper 接口
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface UserRoleMapper extends BaseMapper<UserRoleEntity> {

    /**
     * 校验 用户拥有的角色关系表 是否已经存在
     *
     * @param userRoleCheckParam
     * @return
     * @throws Exception
     */
    boolean checkUserRoleServiceExists(@Param("param") UserRoleCheckParam userRoleCheckParam) throws Exception;

    /**
     * 保存 用户拥有的角色关系表
     *
     * @param userRoleVo
     * @return
     * @throws Exception
     */
    Object addUserRoleService(@Param("param") UserRoleVo userRoleVo) throws Exception;

    /**
     * 批量保存 用户拥有的角色关系表
     *
     * @param userRoleVoList
     * @return
     * @throws Exception
     */
    List<Object> batchAddUserRoleService(@Param("param") List<UserRoleVo> userRoleVoList) throws Exception;

    /**
     * 删除 用户拥有的角色关系表
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteUserRoleService(@Param("param") String id) throws Exception;

    /**
     * 批量删除 用户拥有的角色关系表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteUserRoleService(@Param("param") String ids) throws Exception;

    /**
     * 根据条件删除 用户拥有的角色关系表
     *
     * @param userRoleDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteUserRoleService(@Param("param") UserRoleDeleteParam userRoleDeleteParam) throws Exception;

    /**
     * 修改 用户拥有的角色关系表
     *
     * @param userRoleVo
     * @return
     * @throws Exception
     */
    boolean updateUserRoleService(@Param("param") UserRoleVo userRoleVo) throws Exception;

    /**
     * 根据ID获取 用户拥有的角色关系表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    UserRoleVo getUserRoleServiceById(@Param("param") Serializable id) throws Exception;

    /**
     * 获取 用户拥有的角色关系表 对象列表
     *
     * @param userRoleListParam
     * @return
     * @throws Exception
     */
    List<UserRoleVo> getUserRoleServiceList(@Param("param") UserRoleListParam userRoleListParam) throws Exception;

    /**
     * 获取 用户拥有的角色关系表 分页对象列表
     *
     * @param page
     * @param userRolePageParam
     * @return
     * @throws Exception
     */
    IPage<UserRoleVo> getUserRoleServicePageList(@Param("page") Page page, @Param("param") UserRolePageParam userRolePageParam) throws Exception;

    /**
     * 计算 用户拥有的角色关系表 总记录数
     *
     * @param userRoleCountParam
     * @return
     * @throws Exception
     */
    Integer countUserRoleService(@Param("param") UserRoleCountParam userRoleCountParam) throws Exception;

}
