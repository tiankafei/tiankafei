package org.tiankafei.user.service;

import java.io.Serializable;
import java.util.List;
import org.tiankafei.user.entity.UserInfoEntity;
import org.tiankafei.user.model.UserInfoDto;
import org.tiankafei.user.param.UserInfoListParam;
import org.tiankafei.user.param.UserInfoPageParam;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.web.common.vo.Paging;

/**
 * <pre>
 * 用户基本信息表 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface UserInfoService extends BaseService<UserInfoEntity> {

    /**
     * 保存 用户基本信息表
     *
     * @param userInfoDto
     * @return
     * @throws Exception
     */
    Object addSysUserInfo(UserInfoDto userInfoDto) throws Exception;

    /**
     * 保存 用户基本信息表 集合
     *
     * @param sysUserInfoList
     * @return
     * @throws Exception
     */
    boolean addSysUserInfoList(List<UserInfoDto> sysUserInfoList) throws Exception;

    /**
     * 修改 用户基本信息表
     *
     * @param userInfoDto
     * @return
     * @throws Exception
     */
    boolean updateSysUserInfo(UserInfoDto userInfoDto) throws Exception;

    /**
     * 删除 用户基本信息表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean deleteSysUserInfo(String ids) throws Exception;

    /**
     * 根据ID获取 用户基本信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    UserInfoDto getSysUserInfoById(Serializable id) throws Exception;

    /**
     * 获取 用户基本信息表 分页对象列表
     *
     * @param userInfoPageParam
     * @return
     * @throws Exception
     */
    Paging<UserInfoDto> getSysUserInfoPageList(UserInfoPageParam userInfoPageParam) throws Exception;

    /**
     * 获取 用户基本信息表 对象列表
     *
     * @param userInfoListParam
     * @return
     * @throws Exception
     */
    List<UserInfoDto> getSysUserInfoList(UserInfoListParam userInfoListParam) throws Exception;

    /**
     * 计算 用户基本信息表 总记录数
     *
     * @param userInfoListParam
     * @return
     * @throws Exception
     */
    int countSysUserInfo(UserInfoListParam userInfoListParam) throws Exception;

}