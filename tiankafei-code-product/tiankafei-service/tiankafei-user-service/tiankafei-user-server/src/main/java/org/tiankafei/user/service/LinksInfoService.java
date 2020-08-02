package org.tiankafei.user.service;

import java.io.Serializable;
import java.util.List;
import org.tiankafei.user.entity.LinksInfoEntity;
import org.tiankafei.user.param.LinksInfoListParam;
import org.tiankafei.user.param.LinksInfoPageParam;
import org.tiankafei.user.vo.LinksInfoVo;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.web.common.vo.Paging;

/**
 * <pre>
 * 系统的友情链接 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface LinksInfoService extends BaseService<LinksInfoEntity> {

    /**
     * 校验 系统的友情链接 是否已经存在
     *
     * @param linksInfoListParam
     * @return
     * @throws Exception
     */
    boolean checkSysLinksExists(LinksInfoListParam linksInfoListParam) throws Exception;

    /**
     * 保存 系统的友情链接
     *
     * @param linksInfoVo
     * @return
     * @throws Exception
     */
    Object addSysLinks(LinksInfoVo linksInfoVo) throws Exception;

    /**
     * 保存 系统的友情链接 集合
     *
     * @param linksInfoVoList
     * @return
     * @throws Exception
     */
    boolean addSysLinksList(List<LinksInfoVo> linksInfoVoList) throws Exception;

    /**
     * 修改 系统的友情链接
     *
     * @param linksInfoVo
     * @return
     * @throws Exception
     */
    boolean updateSysLinks(LinksInfoVo linksInfoVo) throws Exception;

    /**
     * 删除 系统的友情链接
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean deleteSysLinks(String ids) throws Exception;

    /**
     * 根据条件删除 系统的友情链接
     *
     * @param linksInfoListParam
     * @return
     * @throws Exception
     */
    boolean deleteSysLinks(LinksInfoListParam linksInfoListParam) throws Exception;

    /**
     * 根据ID获取 系统的友情链接 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    LinksInfoVo getSysLinksById(Serializable id) throws Exception;

    /**
     * 获取 系统的友情链接 分页对象列表
     *
     * @param linksInfoPageParam
     * @return
     * @throws Exception
     */
    Paging<LinksInfoVo> getSysLinksPageList(LinksInfoPageParam linksInfoPageParam) throws Exception;

    /**
     * 获取 系统的友情链接 对象列表
     *
     * @param linksInfoListParam
     * @return
     * @throws Exception
     */
    List<LinksInfoVo> getSysLinksList(LinksInfoListParam linksInfoListParam) throws Exception;

    /**
     * 计算 系统的友情链接 总记录数
     *
     * @param linksInfoListParam
     * @return
     * @throws Exception
     */
    int countSysLinks(LinksInfoListParam linksInfoListParam) throws Exception;

}