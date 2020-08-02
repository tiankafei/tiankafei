package org.tiankafei.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.blog.entity.GlobalSettingEntity;
import org.tiankafei.blog.param.GlobalSettingCheckParam;
import org.tiankafei.blog.param.GlobalSettingCountParam;
import org.tiankafei.blog.param.GlobalSettingDeleteParam;
import org.tiankafei.blog.param.GlobalSettingListParam;
import org.tiankafei.blog.param.GlobalSettingPageParam;
import org.tiankafei.blog.vo.GlobalSettingVo;

/**
 * <p>
 * 系统的博客选项设置 Mapper 接口
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface GlobalSettingMapper extends BaseMapper<GlobalSettingEntity> {

    /**
     * 校验 系统的博客选项设置 是否已经存在
     *
     * @param globalSettingCheckParam
     * @return
     * @throws Exception
     */
    boolean checkGlobalSettingServiceExists(@Param("param") GlobalSettingCheckParam globalSettingCheckParam) throws Exception;

    /**
     * 保存 系统的博客选项设置
     *
     * @param globalSettingVo
     * @return
     * @throws Exception
     */
    Object addGlobalSettingService(@Param("param") GlobalSettingVo globalSettingVo) throws Exception;

    /**
     * 批量保存 系统的博客选项设置
     *
     * @param globalSettingVoList
     * @return
     * @throws Exception
     */
    List<Object> batchAddGlobalSettingService(@Param("param") List<GlobalSettingVo> globalSettingVoList) throws Exception;

    /**
     * 删除 系统的博客选项设置
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteGlobalSettingService(@Param("param") String id) throws Exception;

    /**
     * 批量删除 系统的博客选项设置
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteGlobalSettingService(@Param("param") String ids) throws Exception;

    /**
     * 根据条件删除 系统的博客选项设置
     *
     * @param globalSettingDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteGlobalSettingService(@Param("param") GlobalSettingDeleteParam globalSettingDeleteParam) throws Exception;

    /**
     * 修改 系统的博客选项设置
     *
     * @param globalSettingVo
     * @return
     * @throws Exception
     */
    boolean updateGlobalSettingService(@Param("param") GlobalSettingVo globalSettingVo) throws Exception;

    /**
     * 根据ID获取 系统的博客选项设置 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    GlobalSettingVo getGlobalSettingServiceById(@Param("param") Serializable id) throws Exception;

    /**
     * 获取 系统的博客选项设置 对象列表
     *
     * @param globalSettingListParam
     * @return
     * @throws Exception
     */
    List<GlobalSettingVo> getGlobalSettingServiceList(@Param("param") GlobalSettingListParam globalSettingListParam) throws Exception;

    /**
     * 获取 系统的博客选项设置 分页对象列表
     *
     * @param globalSettingPageParam
     * @return
     * @throws Exception
     */
    List<GlobalSettingVo> getGlobalSettingServicePageList(@Param("param") GlobalSettingPageParam globalSettingPageParam) throws Exception;

    /**
     * 计算 系统的博客选项设置 总记录数
     *
     * @param globalSettingCountParam
     * @return
     * @throws Exception
     */
    Integer countGlobalSettingService(@Param("param") GlobalSettingCountParam globalSettingCountParam) throws Exception;

}
