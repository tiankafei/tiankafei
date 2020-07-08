package org.tiankafei.user.service;

import org.tiankafei.user.entity.SysUserInfoEntity;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.user.param.SysUserInfoQueryParam;
import org.tiankafei.user.param.SysUserInfoPageQueryParam;
import org.tiankafei.user.vo.SysUserInfoQueryVo;
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
     * 校验 用户基本信息表 是否已经存在
     *
     * @param sysUserInfoQueryParam
     * @return
     * @throws Exception
     */
    boolean checkSysUserInfoExists(SysUserInfoQueryParam sysUserInfoQueryParam) throws Exception;

    /**
     * 保存 用户基本信息表
     *
     * @param sysUserInfoQueryVo
     * @return
     * @throws Exception
     */
    Object addSysUserInfo(SysUserInfoQueryVo sysUserInfoQueryVo) throws Exception;

    /**
     * 保存 用户基本信息表 集合
     *
     * @param sysUserInfoQueryVoList
     * @return
     * @throws Exception
     */
    boolean addSysUserInfoList(List<SysUserInfoQueryVo> sysUserInfoQueryVoList) throws Exception;

    /**
     * 修改 用户基本信息表
     *
     * @param sysUserInfoQueryVo
     * @return
     * @throws Exception
     */
    boolean updateSysUserInfo(SysUserInfoQueryVo sysUserInfoQueryVo) throws Exception;

    /**
     * 删除 用户基本信息表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean deleteSysUserInfo(String ids) throws Exception;

    /**
     * 根据条件删除 用户基本信息表
     *
     * @param sysUserInfoQueryParam
     * @return
     * @throws Exception
     */
    boolean deleteSysUserInfo(SysUserInfoQueryParam sysUserInfoQueryParam) throws Exception;

    /**
     * 根据ID获取 用户基本信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    SysUserInfoQueryVo getSysUserInfoById(Serializable id) throws Exception;

    /**
     * 获取用户、角色、功能的所有数据
     * @param id
     * @return
     * @throws Exception
     */
    SysUserInfoQueryVo getSysUserAndRoleAndFeatureById(Serializable id) throws Exception;

    /**
     * 获取 用户基本信息表 分页对象列表
     *
     * @param sysUserInfoPageQueryParam
     * @return
     * @throws Exception
     */
    Paging<SysUserInfoQueryVo> getSysUserInfoPageList(SysUserInfoPageQueryParam sysUserInfoPageQueryParam) throws Exception;

    /**
     * 获取 用户基本信息表 对象列表
     *
     * @param sysUserInfoQueryParam
     * @return
     * @throws Exception
     */
    List<SysUserInfoQueryVo> getSysUserInfoList(SysUserInfoQueryParam sysUserInfoQueryParam) throws Exception;

    /**
     * 计算 用户基本信息表 总记录数
     *
     * @param sysUserInfoQueryParam
     * @return
     * @throws Exception
     */
    int countSysUserInfo(SysUserInfoQueryParam sysUserInfoQueryParam) throws Exception;

}