package org.tiankafei.blog.service;

import com.ruoyi.common.core.web.service.BaseService;
import java.io.Serializable;
import java.util.List;
import org.tiankafei.blog.entity.DiaryInfoEntity;
import org.tiankafei.blog.param.DiaryInfoCheckParam;
import org.tiankafei.blog.param.DiaryInfoCountParam;
import org.tiankafei.blog.param.DiaryInfoDeleteParam;
import org.tiankafei.blog.param.DiaryInfoListParam;
import org.tiankafei.blog.param.DiaryInfoPageParam;
import org.tiankafei.blog.vo.DiaryInfoVo;
import com.ruoyi.common.core.web.page.Paging;

/**
 * <p>
 * 系统的博客日记 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface DiaryInfoService extends BaseService<DiaryInfoEntity> {

    /**
     * 校验 系统的博客日记 是否已经存在
     *
     * @param diaryInfoCheckParam
     * @return
     * @throws Exception
     */
    boolean checkDiaryInfoServiceExists(DiaryInfoCheckParam diaryInfoCheckParam) throws Exception;

    /**
     * 保存 系统的博客日记
     *
     * @param diaryInfoVo
     * @return
     * @throws Exception
     */
    Long addDiaryInfoService(DiaryInfoVo diaryInfoVo) throws Exception;

    /**
     * 批量保存 系统的博客日记
     *
     * @param diaryInfoVoList
     * @return
     * @throws Exception
     */
    List<Long> batchAddDiaryInfoService(List<DiaryInfoVo> diaryInfoVoList) throws Exception;

    /**
     * 删除 系统的博客日记
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteDiaryInfoService(String id) throws Exception;

    /**
     * 批量删除 系统的博客日记
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteDiaryInfoService(String ids) throws Exception;

    /**
     * 根据条件删除 系统的博客日记
     *
     * @param diaryInfoDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteDiaryInfoService(DiaryInfoDeleteParam diaryInfoDeleteParam) throws Exception;

    /**
     * 修改 系统的博客日记
     *
     * @param diaryInfoVo
     * @return
     * @throws Exception
     */
    boolean updateDiaryInfoService(DiaryInfoVo diaryInfoVo) throws Exception;

    /**
     * 根据ID获取 系统的博客日记 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    DiaryInfoVo getDiaryInfoServiceById(Serializable id) throws Exception;

    /**
     * 获取 系统的博客日记 对象列表
     *
     * @param diaryInfoListParam
     * @return
     * @throws Exception
     */
    List<DiaryInfoVo> getDiaryInfoServiceList(DiaryInfoListParam diaryInfoListParam) throws Exception;

    /**
     * 获取 系统的博客日记 分页对象列表
     *
     * @param diaryInfoPageParam
     * @return
     * @throws Exception
     */
    Paging<DiaryInfoVo> getDiaryInfoServicePageList(DiaryInfoPageParam diaryInfoPageParam) throws Exception;

    /**
     * 计算 系统的博客日记 总记录数
     *
     * @param diaryInfoCountParam
     * @return
     * @throws Exception
     */
    Integer countDiaryInfoService(DiaryInfoCountParam diaryInfoCountParam) throws Exception;

}
