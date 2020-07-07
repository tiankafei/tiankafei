package org.tiankafei.blog.service;

import org.tiankafei.blog.entity.SysBlogOptionsEntity;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.blog.param.SysBlogOptionsQueryParam;
import org.tiankafei.blog.param.SysBlogOptionsPageQueryParam;
import org.tiankafei.blog.vo.SysBlogOptionsQueryVo;
import org.tiankafei.web.common.vo.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 系统的博客选项设置 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface SysBlogOptionsService extends BaseService<SysBlogOptionsEntity> {
    
    /**
     * 校验 系统的博客选项设置 是否已经存在
     *
     * @param sysBlogOptionsQueryParam
     * @return
     * @throws Exception
     */
    boolean checkSysBlogOptionsExists(SysBlogOptionsQueryParam sysBlogOptionsQueryParam) throws Exception;

    /**
     * 保存 系统的博客选项设置
     *
     * @param sysBlogOptionsQueryVo
     * @return
     * @throws Exception
     */
    Object addSysBlogOptions(SysBlogOptionsQueryVo sysBlogOptionsQueryVo) throws Exception;
    
    /**
     * 保存 系统的博客选项设置 集合
     *
     * @param sysBlogOptionsQueryVoList
     * @return
     * @throws Exception
     */
    boolean addSysBlogOptionsList(List<SysBlogOptionsQueryVo> sysBlogOptionsQueryVoList) throws Exception;

    /**
     * 修改 系统的博客选项设置
     *
     * @param sysBlogOptionsQueryVo
     * @return
     * @throws Exception
     */
    boolean updateSysBlogOptions(SysBlogOptionsQueryVo sysBlogOptionsQueryVo) throws Exception;

    /**
     * 删除 系统的博客选项设置
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean deleteSysBlogOptions(String ids) throws Exception;
	
    /**
     * 根据条件删除 系统的博客选项设置
     *
     * @param sysBlogOptionsQueryParam
     * @return
     * @throws Exception
     */
    boolean deleteSysBlogOptions(SysBlogOptionsQueryParam sysBlogOptionsQueryParam) throws Exception;

    /**
     * 根据ID获取 系统的博客选项设置 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
     SysBlogOptionsQueryVo getSysBlogOptionsById(Serializable id) throws Exception;

    /**
     * 获取 系统的博客选项设置 分页对象列表
     *
     * @param sysBlogOptionsPageQueryParam
     * @return
     * @throws Exception
     */
    Paging<SysBlogOptionsQueryVo> getSysBlogOptionsPageList(SysBlogOptionsPageQueryParam sysBlogOptionsPageQueryParam) throws Exception;

    /**
     * 获取 系统的博客选项设置 对象列表
     *
     * @param sysBlogOptionsQueryParam
     * @return
     * @throws Exception
     */
     List<SysBlogOptionsQueryVo> getSysBlogOptionsList(SysBlogOptionsQueryParam sysBlogOptionsQueryParam) throws Exception;
    
    /**
     * 计算 系统的博客选项设置 总记录数
     *
     * @param sysBlogOptionsQueryParam
     * @return
     * @throws Exception
     */
    int countSysBlogOptions(SysBlogOptionsQueryParam sysBlogOptionsQueryParam) throws Exception;

}