package org.tiankafei.blog.service;

import org.tiankafei.blog.entity.SysBlogDiaryEntity;
import org.tiankafei.blog.param.SysBlogDiaryPageQueryParam;
import org.tiankafei.blog.param.SysBlogDiaryQueryParam;
import org.tiankafei.blog.vo.SysBlogDiaryQueryVo;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.web.common.vo.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 系统的博客日记 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface SysBlogDiaryService extends BaseService<SysBlogDiaryEntity> {

    /**
     * 校验 系统的博客日记 是否已经存在
     *
     * @param sysBlogDiaryQueryParam
     * @return
     * @throws Exception
     */
    boolean checkSysBlogDiaryExists(SysBlogDiaryQueryParam sysBlogDiaryQueryParam) throws Exception;

    /**
     * 保存 系统的博客日记
     *
     * @param sysBlogDiaryQueryVo
     * @return
     * @throws Exception
     */
    Object addSysBlogDiary(SysBlogDiaryQueryVo sysBlogDiaryQueryVo) throws Exception;

    /**
     * 保存 系统的博客日记 集合
     *
     * @param sysBlogDiaryQueryVoList
     * @return
     * @throws Exception
     */
    boolean addSysBlogDiaryList(List<SysBlogDiaryQueryVo> sysBlogDiaryQueryVoList) throws Exception;

    /**
     * 修改 系统的博客日记
     *
     * @param sysBlogDiaryQueryVo
     * @return
     * @throws Exception
     */
    boolean updateSysBlogDiary(SysBlogDiaryQueryVo sysBlogDiaryQueryVo) throws Exception;

    /**
     * 删除 系统的博客日记
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean deleteSysBlogDiary(String ids) throws Exception;

    /**
     * 根据条件删除 系统的博客日记
     *
     * @param sysBlogDiaryQueryParam
     * @return
     * @throws Exception
     */
    boolean deleteSysBlogDiary(SysBlogDiaryQueryParam sysBlogDiaryQueryParam) throws Exception;

    /**
     * 根据ID获取 系统的博客日记 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    SysBlogDiaryQueryVo getSysBlogDiaryById(Serializable id) throws Exception;

    /**
     * 获取 系统的博客日记 分页对象列表
     *
     * @param sysBlogDiaryPageQueryParam
     * @return
     * @throws Exception
     */
    Paging<SysBlogDiaryQueryVo> getSysBlogDiaryPageList(SysBlogDiaryPageQueryParam sysBlogDiaryPageQueryParam) throws Exception;

    /**
     * 获取 系统的博客日记 对象列表
     *
     * @param sysBlogDiaryQueryParam
     * @return
     * @throws Exception
     */
    List<SysBlogDiaryQueryVo> getSysBlogDiaryList(SysBlogDiaryQueryParam sysBlogDiaryQueryParam) throws Exception;

    /**
     * 计算 系统的博客日记 总记录数
     *
     * @param sysBlogDiaryQueryParam
     * @return
     * @throws Exception
     */
    int countSysBlogDiary(SysBlogDiaryQueryParam sysBlogDiaryQueryParam) throws Exception;

}