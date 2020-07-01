package org.tiankafei.user.service;

import org.tiankafei.user.entity.SysDictInfoEntity;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.user.param.SysDictInfoQueryParam;
import org.tiankafei.user.param.SysDictInfoPageQueryParam;
import org.tiankafei.user.vo.SysDictInfoQueryVo;
import org.tiankafei.web.common.vo.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 系统数据字典表 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-01
 */
public interface SysDictInfoService extends BaseService<SysDictInfoEntity> {
    
    /**
     * 校验 系统数据字典表 是否已经存在
     *
     * @param sysDictInfoQueryParam
     * @return
     * @throws Exception
     */
    boolean checkSysDictInfoExists(SysDictInfoQueryParam sysDictInfoQueryParam) throws Exception;

    /**
     * 保存 系统数据字典表
     *
     * @param sysDictInfoQueryVo
     * @return
     * @throws Exception
     */
    Object addSysDictInfo(SysDictInfoQueryVo sysDictInfoQueryVo) throws Exception;
    
    /**
     * 保存 系统数据字典表 集合
     *
     * @param sysDictInfoQueryVoList
     * @return
     * @throws Exception
     */
    boolean addSysDictInfoList(List<SysDictInfoQueryVo> sysDictInfoQueryVoList) throws Exception;

    /**
     * 修改 系统数据字典表
     *
     * @param sysDictInfoQueryVo
     * @return
     * @throws Exception
     */
    boolean updateSysDictInfo(SysDictInfoQueryVo sysDictInfoQueryVo) throws Exception;

    /**
     * 删除 系统数据字典表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean deleteSysDictInfo(String ids) throws Exception;
	
    /**
     * 根据条件删除 系统数据字典表
     *
     * @param sysDictInfoQueryParam
     * @return
     * @throws Exception
     */
    boolean deleteSysDictInfo(SysDictInfoQueryParam sysDictInfoQueryParam) throws Exception;

    /**
     * 根据ID获取 系统数据字典表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
     SysDictInfoQueryVo getSysDictInfoById(Serializable id) throws Exception;

    /**
     * 获取 系统数据字典表 分页对象列表
     *
     * @param sysDictInfoPageQueryParam
     * @return
     * @throws Exception
     */
    Paging<SysDictInfoQueryVo> getSysDictInfoPageList(SysDictInfoPageQueryParam sysDictInfoPageQueryParam) throws Exception;

    /**
     * 获取 系统数据字典表 对象列表
     *
     * @param sysDictInfoQueryParam
     * @return
     * @throws Exception
     */
     List<SysDictInfoQueryVo> getSysDictInfoList(SysDictInfoQueryParam sysDictInfoQueryParam) throws Exception;
    
    /**
     * 计算 系统数据字典表 总记录数
     *
     * @param sysDictInfoQueryParam
     * @return
     * @throws Exception
     */
    int countSysDictInfo(SysDictInfoQueryParam sysDictInfoQueryParam) throws Exception;

}