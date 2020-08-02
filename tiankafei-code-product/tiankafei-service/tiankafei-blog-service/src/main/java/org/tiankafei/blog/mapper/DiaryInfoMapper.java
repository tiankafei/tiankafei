package org.tiankafei.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.blog.entity.DiaryInfoEntity;
import org.tiankafei.blog.param.DiaryInfoCheckParam;
import org.tiankafei.blog.param.DiaryInfoCountParam;
import org.tiankafei.blog.param.DiaryInfoDeleteParam;
import org.tiankafei.blog.param.DiaryInfoListParam;
import org.tiankafei.blog.param.DiaryInfoPageParam;
import org.tiankafei.blog.vo.DiaryInfoVo;

/**
 * <p>
 * 系统的博客日记 Mapper 接口
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface DiaryInfoMapper extends BaseMapper<DiaryInfoEntity> {

    /**
     * 校验 系统的博客日记 是否已经存在
     *
     * @param diaryInfoCheckParam
     * @return
     * @throws Exception
     */
    boolean checkDiaryInfoServiceExists(@Param("param") DiaryInfoCheckParam diaryInfoCheckParam) throws Exception;

    /**
     * 保存 系统的博客日记
     *
     * @param diaryInfoVo
     * @return
     * @throws Exception
     */
    Object addDiaryInfoService(@Param("param") DiaryInfoVo diaryInfoVo) throws Exception;

    /**
     * 批量保存 系统的博客日记
     *
     * @param diaryInfoVoList
     * @return
     * @throws Exception
     */
    List<Object> batchAddDiaryInfoService(@Param("param") List<DiaryInfoVo> diaryInfoVoList) throws Exception;

    /**
     * 删除 系统的博客日记
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteDiaryInfoService(@Param("param") String id) throws Exception;

    /**
     * 批量删除 系统的博客日记
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteDiaryInfoService(@Param("param") String ids) throws Exception;

    /**
     * 根据条件删除 系统的博客日记
     *
     * @param diaryInfoDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteDiaryInfoService(@Param("param") DiaryInfoDeleteParam diaryInfoDeleteParam) throws Exception;

    /**
     * 修改 系统的博客日记
     *
     * @param diaryInfoVo
     * @return
     * @throws Exception
     */
    boolean updateDiaryInfoService(@Param("param") DiaryInfoVo diaryInfoVo) throws Exception;

    /**
     * 根据ID获取 系统的博客日记 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    DiaryInfoVo getDiaryInfoServiceById(@Param("param") Serializable id) throws Exception;

    /**
     * 获取 系统的博客日记 对象列表
     *
     * @param diaryInfoListParam
     * @return
     * @throws Exception
     */
    List<DiaryInfoVo> getDiaryInfoServiceList(@Param("param") DiaryInfoListParam diaryInfoListParam) throws Exception;

    /**
     * 获取 系统的博客日记 分页对象列表
     *
     * @param page
     * @param diaryInfoPageParam
     * @return
     * @throws Exception
     */
    List<Long> getDiaryInfoServicePageList(@Param("page") Page page, @Param("param") DiaryInfoPageParam diaryInfoPageParam) throws Exception;

    /**
     * 计算 系统的博客日记 总记录数
     *
     * @param diaryInfoCountParam
     * @return
     * @throws Exception
     */
    Integer countDiaryInfoService(@Param("param") DiaryInfoCountParam diaryInfoCountParam) throws Exception;

}
