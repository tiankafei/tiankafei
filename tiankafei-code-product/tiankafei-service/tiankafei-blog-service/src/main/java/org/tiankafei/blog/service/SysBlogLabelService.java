package org.tiankafei.blog.service;

import org.tiankafei.blog.entity.SysBlogLabelEntity;
import org.tiankafei.blog.param.SysBlogLabelPageQueryParam;
import org.tiankafei.blog.param.SysBlogLabelQueryParam;
import org.tiankafei.blog.vo.SysBlogLabelQueryVo;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.web.common.vo.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 系统的博客标签 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface SysBlogLabelService extends BaseService<SysBlogLabelEntity> {

    /**
     * 校验 系统的博客标签 是否已经存在
     *
     * @param sysBlogLabelQueryParam
     * @return
     * @throws Exception
     */
    boolean checkSysBlogLabelExists(SysBlogLabelQueryParam sysBlogLabelQueryParam) throws Exception;

    /**
     * 保存 系统的博客标签
     *
     * @param sysBlogLabelQueryVo
     * @return
     * @throws Exception
     */
    Object addSysBlogLabel(SysBlogLabelQueryVo sysBlogLabelQueryVo) throws Exception;

    /**
     * 保存 系统的博客标签 集合
     *
     * @param sysBlogLabelQueryVoList
     * @return
     * @throws Exception
     */
    boolean addSysBlogLabelList(List<SysBlogLabelQueryVo> sysBlogLabelQueryVoList) throws Exception;

    /**
     * 修改 系统的博客标签
     *
     * @param sysBlogLabelQueryVo
     * @return
     * @throws Exception
     */
    boolean updateSysBlogLabel(SysBlogLabelQueryVo sysBlogLabelQueryVo) throws Exception;

    /**
     * 删除 系统的博客标签
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean deleteSysBlogLabel(String ids) throws Exception;

    /**
     * 根据条件删除 系统的博客标签
     *
     * @param sysBlogLabelQueryParam
     * @return
     * @throws Exception
     */
    boolean deleteSysBlogLabel(SysBlogLabelQueryParam sysBlogLabelQueryParam) throws Exception;

    /**
     * 根据ID获取 系统的博客标签 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    SysBlogLabelQueryVo getSysBlogLabelById(Serializable id) throws Exception;

    /**
     * 获取 系统的博客标签 分页对象列表
     *
     * @param sysBlogLabelPageQueryParam
     * @return
     * @throws Exception
     */
    Paging<SysBlogLabelQueryVo> getSysBlogLabelPageList(SysBlogLabelPageQueryParam sysBlogLabelPageQueryParam) throws Exception;

    /**
     * 获取 系统的博客标签 对象列表
     *
     * @param sysBlogLabelQueryParam
     * @return
     * @throws Exception
     */
    List<SysBlogLabelQueryVo> getSysBlogLabelList(SysBlogLabelQueryParam sysBlogLabelQueryParam) throws Exception;

    /**
     * 计算 系统的博客标签 总记录数
     *
     * @param sysBlogLabelQueryParam
     * @return
     * @throws Exception
     */
    int countSysBlogLabel(SysBlogLabelQueryParam sysBlogLabelQueryParam) throws Exception;

}