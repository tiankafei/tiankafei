package org.tiankafei.user.service;

import java.io.Serializable;
import java.util.List;
import org.tiankafei.user.entity.MenuInfoEntity;
import org.tiankafei.user.param.MenuInfoListParam;
import org.tiankafei.user.param.MenuInfoPageParam;
import org.tiankafei.user.vo.MenuInfoVo;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.web.common.vo.Paging;

/**
 * <pre>
 * 系统功能菜单信息表 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface MenuInfoService extends BaseService<MenuInfoEntity> {

    /**
     * 校验 系统功能菜单信息表 是否已经存在
     *
     * @param menuInfoListParam
     * @return
     * @throws Exception
     */
    boolean checkSysMenuInfoExists(MenuInfoListParam menuInfoListParam) throws Exception;

    /**
     * 保存 系统功能菜单信息表
     *
     * @param menuInfoVo
     * @return
     * @throws Exception
     */
    Object addSysMenuInfo(MenuInfoVo menuInfoVo) throws Exception;

    /**
     * 保存 系统功能菜单信息表 集合
     *
     * @param menuInfoVoList
     * @return
     * @throws Exception
     */
    boolean addSysMenuInfoList(List<MenuInfoVo> menuInfoVoList) throws Exception;

    /**
     * 修改 系统功能菜单信息表
     *
     * @param menuInfoVo
     * @return
     * @throws Exception
     */
    boolean updateSysMenuInfo(MenuInfoVo menuInfoVo) throws Exception;

    /**
     * 删除 系统功能菜单信息表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean deleteSysMenuInfo(String ids) throws Exception;

    /**
     * 根据条件删除 系统功能菜单信息表
     *
     * @param menuInfoListParam
     * @return
     * @throws Exception
     */
    boolean deleteSysMenuInfo(MenuInfoListParam menuInfoListParam) throws Exception;

    /**
     * 根据ID获取 系统功能菜单信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    MenuInfoVo getSysMenuInfoById(Serializable id) throws Exception;

    /**
     * 获取 系统功能菜单信息表 分页对象列表
     *
     * @param menuInfoPageParam
     * @return
     * @throws Exception
     */
    Paging<MenuInfoVo> getSysMenuInfoPageList(MenuInfoPageParam menuInfoPageParam) throws Exception;

    /**
     * 获取 系统功能菜单信息表 对象列表
     *
     * @param menuInfoListParam
     * @return
     * @throws Exception
     */
    List<MenuInfoVo> getSysMenuInfoList(MenuInfoListParam menuInfoListParam) throws Exception;

    /**
     * 计算 系统功能菜单信息表 总记录数
     *
     * @param menuInfoListParam
     * @return
     * @throws Exception
     */
    int countSysMenuInfo(MenuInfoListParam menuInfoListParam) throws Exception;

}