package org.tiankafei.user.service;

import com.ruoyi.common.core.web.service.BaseService;
import java.io.Serializable;
import java.util.List;
import org.tiankafei.user.entity.LinksInfoEntity;
import org.tiankafei.user.param.LinksInfoCheckParam;
import org.tiankafei.user.param.LinksInfoCountParam;
import org.tiankafei.user.param.LinksInfoDeleteParam;
import org.tiankafei.user.param.LinksInfoListParam;
import org.tiankafei.user.param.LinksInfoPageParam;
import org.tiankafei.user.vo.LinksInfoVo;
import com.ruoyi.common.core.web.page.Paging;

/**
 * <p>
 * 系统的友情链接 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface LinksInfoService extends BaseService<LinksInfoEntity> {

    /**
     * 校验 系统的友情链接 是否已经存在
     *
     * @param linksInfoCheckParam
     * @return
     * @throws Exception
     */
    boolean checkLinksInfoServiceExists(LinksInfoCheckParam linksInfoCheckParam) throws Exception;

    /**
     * 保存 系统的友情链接
     *
     * @param linksInfoVo
     * @return
     * @throws Exception
     */
    Long addLinksInfoService(LinksInfoVo linksInfoVo) throws Exception;

    /**
     * 批量保存 系统的友情链接
     *
     * @param linksInfoVoList
     * @return
     * @throws Exception
     */
    List<Long> batchAddLinksInfoService(List<LinksInfoVo> linksInfoVoList) throws Exception;

    /**
     * 删除 系统的友情链接
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteLinksInfoService(String id) throws Exception;

    /**
     * 批量删除 系统的友情链接
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteLinksInfoService(String ids) throws Exception;

    /**
     * 根据条件删除 系统的友情链接
     *
     * @param linksInfoDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteLinksInfoService(LinksInfoDeleteParam linksInfoDeleteParam) throws Exception;

    /**
     * 修改 系统的友情链接
     *
     * @param linksInfoVo
     * @return
     * @throws Exception
     */
    boolean updateLinksInfoService(LinksInfoVo linksInfoVo) throws Exception;

    /**
     * 根据ID获取 系统的友情链接 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    LinksInfoVo getLinksInfoServiceById(Serializable id) throws Exception;

    /**
     * 获取 系统的友情链接 对象列表
     *
     * @param linksInfoListParam
     * @return
     * @throws Exception
     */
    List<LinksInfoVo> getLinksInfoServiceList(LinksInfoListParam linksInfoListParam) throws Exception;

    /**
     * 获取 系统的友情链接 分页对象列表
     *
     * @param linksInfoPageParam
     * @return
     * @throws Exception
     */
    Paging<LinksInfoVo> getLinksInfoServicePageList(LinksInfoPageParam linksInfoPageParam) throws Exception;

    /**
     * 计算 系统的友情链接 总记录数
     *
     * @param linksInfoCountParam
     * @return
     * @throws Exception
     */
    Integer countLinksInfoService(LinksInfoCountParam linksInfoCountParam) throws Exception;

}
