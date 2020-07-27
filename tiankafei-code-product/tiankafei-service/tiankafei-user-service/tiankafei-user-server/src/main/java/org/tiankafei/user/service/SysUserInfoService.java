package org.tiankafei.user.service;

import org.tiankafei.user.entity.SysUserInfoEntity;
import org.tiankafei.user.model.SysUserInfoDto;
import org.tiankafei.user.param.SysUserInfoPageQueryParam;
import org.tiankafei.user.param.SysUserInfoQueryParam;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.web.common.vo.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 用户基本信息表 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface SysUserInfoService extends BaseService<SysUserInfoEntity> {

    /**
     * 保存 用户基本信息表
     *
     * @param sysUserInfoDto
     * @return
     * @throws Exception
     */
    Object addSysUserInfo(SysUserInfoDto sysUserInfoDto) throws Exception;

    /**
     * 保存 用户基本信息表 集合
     *
     * @param sysUserInfoList
     * @return
     * @throws Exception
     */
    boolean addSysUserInfoList(List<SysUserInfoDto> sysUserInfoList) throws Exception;

    /**
     * 修改 用户基本信息表
     *
     * @param sysUserInfoDto
     * @return
     * @throws Exception
     */
    boolean updateSysUserInfo(SysUserInfoDto sysUserInfoDto) throws Exception;

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
    SysUserInfoDto getSysUserInfoById(Serializable id) throws Exception;

    /**
     * 获取 用户基本信息表 分页对象列表
     *
     * @param sysUserInfoPageQueryParam
     * @return
     * @throws Exception
     */
    Paging<SysUserInfoDto> getSysUserInfoPageList(SysUserInfoPageQueryParam sysUserInfoPageQueryParam) throws Exception;

    /**
     * 获取 用户基本信息表 对象列表
     *
     * @param sysUserInfoQueryParam
     * @return
     * @throws Exception
     */
    List<SysUserInfoDto> getSysUserInfoList(SysUserInfoQueryParam sysUserInfoQueryParam) throws Exception;

    /**
     * 计算 用户基本信息表 总记录数
     *
     * @param sysUserInfoQueryParam
     * @return
     * @throws Exception
     */
    int countSysUserInfo(SysUserInfoQueryParam sysUserInfoQueryParam) throws Exception;

}