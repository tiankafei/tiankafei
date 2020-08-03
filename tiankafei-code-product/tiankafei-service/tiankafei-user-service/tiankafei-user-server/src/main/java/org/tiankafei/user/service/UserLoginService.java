package org.tiankafei.user.service;

import java.io.Serializable;
import java.util.List;
import org.tiankafei.user.entity.UserLoginEntity;
import org.tiankafei.user.param.UserLoginCheckParam;
import org.tiankafei.user.param.UserLoginCountParam;
import org.tiankafei.user.param.UserLoginDeleteParam;
import org.tiankafei.user.param.UserLoginListParam;
import org.tiankafei.user.param.UserLoginPageParam;
import org.tiankafei.user.vo.UserLoginVo;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 用户登录信息表 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface UserLoginService extends BaseService<UserLoginEntity> {

    /**
     * 校验 用户名 是否已经存在
     *
     * @param username
     * @return
     * @throws Exception
     */
    Boolean checkUsernameExists(String username) throws Exception;

    /**
     * 校验  邮箱 是否已经存在
     *
     * @param email
     * @return
     * @throws Exception
     */
    Boolean checkEmailExists(String email) throws Exception;

    /**
     * 校验 手机号码 是否已经存在
     *
     * @param telephone
     * @return
     * @throws Exception
     */
    Boolean checkTelephoneExists(String telephone) throws Exception;

    /**
     * 校验 用户登录信息表 是否已经存在
     *
     * @param userLoginCheckParam
     * @return
     * @throws Exception
     */
    boolean checkUserLoginServiceExists(UserLoginCheckParam userLoginCheckParam) throws Exception;

    /**
     * 保存 用户登录信息表
     *
     * @param userLoginVo
     * @return
     * @throws Exception
     */
    Long addUserLoginService(UserLoginVo userLoginVo) throws Exception;

    /**
     * 批量保存 用户登录信息表
     *
     * @param userLoginVoList
     * @return
     * @throws Exception
     */
    List<Long> batchAddUserLoginService(List<UserLoginVo> userLoginVoList) throws Exception;

    /**
     * 删除 用户登录信息表
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteUserLoginService(String id) throws Exception;

    /**
     * 删除 用户登录信息表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteUserLoginService(String ids) throws Exception;

    /**
     * 根据条件删除 用户登录信息表
     *
     * @param userLoginDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteUserLoginService(UserLoginDeleteParam userLoginDeleteParam) throws Exception;

    /**
     * 修改 用户登录信息表
     *
     * @param userLoginVo
     * @return
     * @throws Exception
     */
    boolean updateUserLoginService(UserLoginVo userLoginVo) throws Exception;

    /**
     * 根据ID获取 用户登录信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    UserLoginVo getUserLoginServiceById(Serializable id) throws Exception;

    /**
     * 获取 用户登录信息表 对象列表
     *
     * @param userLoginListParam
     * @return
     * @throws Exception
     */
    List<UserLoginVo> getUserLoginServiceList(UserLoginListParam userLoginListParam) throws Exception;

    /**
     * 获取 用户登录信息表 分页对象列表
     *
     * @param userLoginPageParam
     * @return
     * @throws Exception
     */
    Paging<UserLoginVo> getUserLoginServicePageList(UserLoginPageParam userLoginPageParam) throws Exception;

    /**
     * 计算 用户登录信息表 总记录数
     *
     * @param userLoginCountParam
     * @return
     * @throws Exception
     */
    Integer countUserLoginService(UserLoginCountParam userLoginCountParam) throws Exception;

}
