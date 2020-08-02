package org.tiankafei.user.service;

import java.io.Serializable;
import java.util.List;
import org.tiankafei.user.entity.UserInfoEntity;
import org.tiankafei.user.param.UserInfoCheckParam;
import org.tiankafei.user.param.UserInfoCountParam;
import org.tiankafei.user.param.UserInfoDeleteParam;
import org.tiankafei.user.param.UserInfoListParam;
import org.tiankafei.user.param.UserInfoPageParam;
import org.tiankafei.user.vo.UserInfoVo;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 用户基本信息表 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface UserInfoService extends BaseService<UserInfoEntity> {

    /**
     * 校验 用户名 是否已经存在
     * @param username
     * @return
     * @throws Exception
     */
    Boolean checkUsernameExists(String username) throws Exception ;

    /**
     * 校验  邮箱 是否已经存在
     * @param email
     * @return
     * @throws Exception
     */
    Boolean checkEmailExists(String email) throws Exception ;

    /**
     * 校验 手机号码 是否已经存在
     * @param telephone
     * @return
     * @throws Exception
     */
    Boolean checkTelephoneExists(String telephone) throws Exception ;

    /**
     * 校验 用户基本信息表 是否已经存在
     *
     * @param userInfoCheckParam
     * @return
     * @throws Exception
     */
    boolean checkUserInfoServiceExists(UserInfoCheckParam userInfoCheckParam) throws Exception;

    /**
     * 保存 用户基本信息表
     *
     * @param userInfoVo
     * @return
     * @throws Exception
     */
    Long addUserInfoService(UserInfoVo userInfoVo) throws Exception;

    /**
     * 批量保存 用户基本信息表
     *
     * @param userInfoVoList
     * @return
     * @throws Exception
     */
    List<Long> batchAddUserInfoService(List<UserInfoVo> userInfoVoList) throws Exception;

    /**
     * 删除 用户基本信息表
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteUserInfoService(String id) throws Exception;

    /**
     * 删除 用户基本信息表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteUserInfoService(String ids) throws Exception;

    /**
     * 根据条件删除 用户基本信息表
     *
     * @param userInfoDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteUserInfoService(UserInfoDeleteParam userInfoDeleteParam) throws Exception;

    /**
     * 修改 用户基本信息表
     *
     * @param userInfoVo
     * @return
     * @throws Exception
     */
    boolean updateUserInfoService(UserInfoVo userInfoVo) throws Exception;

    /**
     * 根据ID获取 用户基本信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    UserInfoVo getUserInfoServiceById(Serializable id) throws Exception;

    /**
     * 获取 用户基本信息表 对象列表
     *
     * @param userInfoListParam
     * @return
     * @throws Exception
     */
    List<UserInfoVo> getUserInfoServiceList(UserInfoListParam userInfoListParam) throws Exception;

    /**
     * 获取 用户基本信息表 分页对象列表
     *
     * @param userInfoPageParam
     * @return
     * @throws Exception
     */
    Paging<UserInfoVo> getUserInfoServicePageList(UserInfoPageParam userInfoPageParam) throws Exception;

    /**
     * 计算 用户基本信息表 总记录数
     *
     * @param userInfoCountParam
     * @return
     * @throws Exception
     */
    Integer countUserInfoService(UserInfoCountParam userInfoCountParam) throws Exception;

}
