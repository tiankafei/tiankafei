package org.tiankafei.blog.service;

import org.tiankafei.blog.entity.SysBlogInfoEntity;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.blog.param.SysBlogInfoQueryParam;
import org.tiankafei.blog.param.SysBlogInfoPageQueryParam;
import org.tiankafei.blog.vo.SysBlogInfoQueryVo;
import org.tiankafei.web.common.vo.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 系统的博客数据 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 2020-07-02
 */
public interface SysBlogInfoService extends BaseService<SysBlogInfoEntity> {
    
    /**
     * 校验 系统的博客数据 是否已经存在
     *
     * @param sysBlogInfoQueryParam
     * @return
     * @throws Exception
     */
    boolean checkSysBlogInfoExists(SysBlogInfoQueryParam sysBlogInfoQueryParam) throws Exception;

    /**
     * 保存 系统的博客数据
     *
     * @param sysBlogInfoQueryVo
     * @return
     * @throws Exception
     */
    Object addSysBlogInfo(SysBlogInfoQueryVo sysBlogInfoQueryVo) throws Exception;
    
    /**
     * 保存 系统的博客数据 集合
     *
     * @param sysBlogInfoQueryVoList
     * @return
     * @throws Exception
     */
    boolean addSysBlogInfoList(List<SysBlogInfoQueryVo> sysBlogInfoQueryVoList) throws Exception;

    /**
     * 修改 系统的博客数据
     *
     * @param sysBlogInfoQueryVo
     * @return
     * @throws Exception
     */
    boolean updateSysBlogInfo(SysBlogInfoQueryVo sysBlogInfoQueryVo) throws Exception;

    /**
     * 删除 系统的博客数据
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean deleteSysBlogInfo(String ids) throws Exception;
	
    /**
     * 根据条件删除 系统的博客数据
     *
     * @param sysBlogInfoQueryParam
     * @return
     * @throws Exception
     */
    boolean deleteSysBlogInfo(SysBlogInfoQueryParam sysBlogInfoQueryParam) throws Exception;

    /**
     * 根据ID获取 系统的博客数据 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
     SysBlogInfoQueryVo getSysBlogInfoById(Serializable id) throws Exception;

    /**
     * 获取 系统的博客数据 分页对象列表
     *
     * @param sysBlogInfoPageQueryParam
     * @return
     * @throws Exception
     */
    Paging<SysBlogInfoQueryVo> getSysBlogInfoPageList(SysBlogInfoPageQueryParam sysBlogInfoPageQueryParam) throws Exception;

    /**
     * 获取 系统的博客数据 对象列表
     *
     * @param sysBlogInfoQueryParam
     * @return
     * @throws Exception
     */
     List<SysBlogInfoQueryVo> getSysBlogInfoList(SysBlogInfoQueryParam sysBlogInfoQueryParam) throws Exception;
    
    /**
     * 计算 系统的博客数据 总记录数
     *
     * @param sysBlogInfoQueryParam
     * @return
     * @throws Exception
     */
    int countSysBlogInfo(SysBlogInfoQueryParam sysBlogInfoQueryParam) throws Exception;

}