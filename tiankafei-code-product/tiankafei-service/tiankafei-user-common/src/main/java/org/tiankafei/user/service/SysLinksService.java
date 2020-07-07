package org.tiankafei.user.service;

import org.tiankafei.user.entity.SysLinksEntity;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.user.param.SysLinksQueryParam;
import org.tiankafei.user.param.SysLinksPageQueryParam;
import org.tiankafei.user.vo.SysLinksQueryVo;
import org.tiankafei.web.common.vo.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 系统的友情链接 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface SysLinksService extends BaseService<SysLinksEntity> {
    
    /**
     * 校验 系统的友情链接 是否已经存在
     *
     * @param sysLinksQueryParam
     * @return
     * @throws Exception
     */
    boolean checkSysLinksExists(SysLinksQueryParam sysLinksQueryParam) throws Exception;

    /**
     * 保存 系统的友情链接
     *
     * @param sysLinksQueryVo
     * @return
     * @throws Exception
     */
    Object addSysLinks(SysLinksQueryVo sysLinksQueryVo) throws Exception;
    
    /**
     * 保存 系统的友情链接 集合
     *
     * @param sysLinksQueryVoList
     * @return
     * @throws Exception
     */
    boolean addSysLinksList(List<SysLinksQueryVo> sysLinksQueryVoList) throws Exception;

    /**
     * 修改 系统的友情链接
     *
     * @param sysLinksQueryVo
     * @return
     * @throws Exception
     */
    boolean updateSysLinks(SysLinksQueryVo sysLinksQueryVo) throws Exception;

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
     * @param sysLinksQueryParam
     * @return
     * @throws Exception
     */
    boolean deleteSysLinks(SysLinksQueryParam sysLinksQueryParam) throws Exception;

    /**
     * 根据ID获取 系统的友情链接 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
     SysLinksQueryVo getSysLinksById(Serializable id) throws Exception;

    /**
     * 获取 系统的友情链接 分页对象列表
     *
     * @param sysLinksPageQueryParam
     * @return
     * @throws Exception
     */
    Paging<SysLinksQueryVo> getSysLinksPageList(SysLinksPageQueryParam sysLinksPageQueryParam) throws Exception;

    /**
     * 获取 系统的友情链接 对象列表
     *
     * @param sysLinksQueryParam
     * @return
     * @throws Exception
     */
     List<SysLinksQueryVo> getSysLinksList(SysLinksQueryParam sysLinksQueryParam) throws Exception;
    
    /**
     * 计算 系统的友情链接 总记录数
     *
     * @param sysLinksQueryParam
     * @return
     * @throws Exception
     */
    int countSysLinks(SysLinksQueryParam sysLinksQueryParam) throws Exception;

}