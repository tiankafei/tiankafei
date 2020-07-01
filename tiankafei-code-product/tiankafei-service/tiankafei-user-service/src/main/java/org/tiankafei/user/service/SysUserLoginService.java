package org.tiankafei.user.service;

import org.tiankafei.user.entity.SysUserLoginEntity;
import org.tiankafei.user.param.SysUserLoginPageQueryParam;
import org.tiankafei.user.param.SysUserLoginQueryParam;
import org.tiankafei.user.vo.SysUserLoginQueryVo;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.web.common.vo.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 用户登录信息表 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 2020-06-30
 */
public interface SysUserLoginService extends BaseService<SysUserLoginEntity> {

    /**
     * 校验 用户登录信息表 是否已经存在
     *
     * @param sysUserLoginQueryParam
     * @return
     * @throws Exception
     */
    boolean checkSysUserLoginExists(SysUserLoginQueryParam sysUserLoginQueryParam) throws Exception;

    /**
     * 保存 用户登录信息表
     *
     * @param sysUserLoginQueryVo
     * @return
     * @throws Exception
     */
    Object addSysUserLogin(SysUserLoginQueryVo sysUserLoginQueryVo) throws Exception;
    
    /**
     * 保存 用户登录信息表 集合
     *
     * @param sysUserLoginQueryVoList
     * @return
     * @throws Exception
     */
    boolean addSysUserLoginList(List<SysUserLoginQueryVo> sysUserLoginQueryVoList) throws Exception;

    /**
     * 修改 用户登录信息表
     *
     * @param sysUserLoginQueryVo
     * @return
     * @throws Exception
     */
    boolean updateSysUserLogin(SysUserLoginQueryVo sysUserLoginQueryVo) throws Exception;

    /**
     * 删除 用户登录信息表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean deleteSysUserLogin(String ids) throws Exception;
	
    /**
     * 根据条件删除 用户登录信息表
     *
     * @param sysUserLoginQueryParam
     * @return
     * @throws Exception
     */
    boolean deleteSysUserLogin(SysUserLoginQueryParam sysUserLoginQueryParam) throws Exception;

    /**
     * 根据ID获取 用户登录信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
     SysUserLoginQueryVo getSysUserLoginById(Serializable id) throws Exception;

    /**
     * 获取 用户登录信息表 分页对象列表
     *
     * @param sysUserLoginPageQueryParam
     * @return
     * @throws Exception
     */
    Paging<SysUserLoginQueryVo> getSysUserLoginPageList(SysUserLoginPageQueryParam sysUserLoginPageQueryParam) throws Exception;

    /**
     * 获取 用户登录信息表 对象列表
     *
     * @param sysUserLoginQueryParam
     * @return
     * @throws Exception
     */
     List<SysUserLoginQueryVo> getSysUserLoginList(SysUserLoginQueryParam sysUserLoginQueryParam) throws Exception;
    
    /**
     * 计算 用户登录信息表 总记录数
     *
     * @param sysUserLoginQueryParam
     * @return
     * @throws Exception
     */
    int countSysUserLogin(SysUserLoginQueryParam sysUserLoginQueryParam) throws Exception;

}