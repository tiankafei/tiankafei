package org.tiankafei.blog.service;

import com.ruoyi.common.core.web.service.BaseService;
import java.io.Serializable;
import java.util.List;
import org.tiankafei.blog.entity.GlobalSettingEntity;
import org.tiankafei.blog.param.GlobalSettingCheckParam;
import org.tiankafei.blog.param.GlobalSettingCountParam;
import org.tiankafei.blog.param.GlobalSettingDeleteParam;
import org.tiankafei.blog.param.GlobalSettingListParam;
import org.tiankafei.blog.param.GlobalSettingPageParam;
import org.tiankafei.blog.vo.GlobalSettingVo;
import com.ruoyi.common.core.web.page.Paging;

/**
 * <p>
 * 系统的博客选项设置 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface GlobalSettingService extends BaseService<GlobalSettingEntity> {

    /**
     * 校验 系统的博客选项设置 是否已经存在
     *
     * @param globalSettingCheckParam
     * @return
     * @throws Exception
     */
    boolean checkGlobalSettingServiceExists(GlobalSettingCheckParam globalSettingCheckParam) throws Exception;

    /**
     * 保存 系统的博客选项设置
     *
     * @param globalSettingVo
     * @return
     * @throws Exception
     */
    Long addGlobalSettingService(GlobalSettingVo globalSettingVo) throws Exception;

    /**
     * 批量保存 系统的博客选项设置
     *
     * @param globalSettingVoList
     * @return
     * @throws Exception
     */
    List<Long> batchAddGlobalSettingService(List<GlobalSettingVo> globalSettingVoList) throws Exception;

    /**
     * 删除 系统的博客选项设置
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteGlobalSettingService(String id) throws Exception;

    /**
     * 批量删除 系统的博客选项设置
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteGlobalSettingService(String ids) throws Exception;

    /**
     * 根据条件删除 系统的博客选项设置
     *
     * @param globalSettingDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteGlobalSettingService(GlobalSettingDeleteParam globalSettingDeleteParam) throws Exception;

    /**
     * 修改 系统的博客选项设置
     *
     * @param globalSettingVo
     * @return
     * @throws Exception
     */
    boolean updateGlobalSettingService(GlobalSettingVo globalSettingVo) throws Exception;

    /**
     * 根据ID获取 系统的博客选项设置 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    GlobalSettingVo getGlobalSettingServiceById(Serializable id) throws Exception;

    /**
     * 获取 系统的博客选项设置 对象列表
     *
     * @param globalSettingListParam
     * @return
     * @throws Exception
     */
    List<GlobalSettingVo> getGlobalSettingServiceList(GlobalSettingListParam globalSettingListParam) throws Exception;

    /**
     * 获取 系统的博客选项设置 分页对象列表
     *
     * @param globalSettingPageParam
     * @return
     * @throws Exception
     */
    Paging<GlobalSettingVo> getGlobalSettingServicePageList(GlobalSettingPageParam globalSettingPageParam) throws Exception;

    /**
     * 计算 系统的博客选项设置 总记录数
     *
     * @param globalSettingCountParam
     * @return
     * @throws Exception
     */
    Integer countGlobalSettingService(GlobalSettingCountParam globalSettingCountParam) throws Exception;

}
