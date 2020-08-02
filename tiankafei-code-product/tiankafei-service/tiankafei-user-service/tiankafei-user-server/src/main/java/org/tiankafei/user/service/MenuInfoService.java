package org.tiankafei.user.service;

import java.io.Serializable;
import java.util.List;
import org.tiankafei.user.entity.MenuInfoEntity;
import org.tiankafei.user.param.MenuInfoCheckParam;
import org.tiankafei.user.param.MenuInfoCountParam;
import org.tiankafei.user.param.MenuInfoDeleteParam;
import org.tiankafei.user.param.MenuInfoListParam;
import org.tiankafei.user.param.MenuInfoPageParam;
import org.tiankafei.user.vo.MenuInfoVo;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 系统功能菜单信息表 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface MenuInfoService extends BaseService<MenuInfoEntity> {

    /**
     * 校验 系统功能菜单信息表 是否已经存在
     *
     * @param menuInfoCheckParam
     * @return
     * @throws Exception
     */
    boolean checkMenuInfoServiceExists(MenuInfoCheckParam menuInfoCheckParam) throws Exception;

    /**
     * 保存 系统功能菜单信息表
     *
     * @param menuInfoVo
     * @return
     * @throws Exception
     */
    Long addMenuInfoService(MenuInfoVo menuInfoVo) throws Exception;

    /**
     * 批量保存 系统功能菜单信息表
     *
     * @param menuInfoVoList
     * @return
     * @throws Exception
     */
    List<Long> batchAddMenuInfoService(List<MenuInfoVo> menuInfoVoList) throws Exception;

    /**
     * 删除 系统功能菜单信息表
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteMenuInfoService(String id) throws Exception;

    /**
     * 删除 系统功能菜单信息表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteMenuInfoService(String ids) throws Exception;

    /**
     * 根据条件删除 系统功能菜单信息表
     *
     * @param menuInfoDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteMenuInfoService(MenuInfoDeleteParam menuInfoDeleteParam) throws Exception;

    /**
     * 修改 系统功能菜单信息表
     *
     * @param menuInfoVo
     * @return
     * @throws Exception
     */
    boolean updateMenuInfoService(MenuInfoVo menuInfoVo) throws Exception;

    /**
     * 根据ID获取 系统功能菜单信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    MenuInfoVo getMenuInfoServiceById(Serializable id) throws Exception;

    /**
     * 获取 系统功能菜单信息表 对象列表
     *
     * @param menuInfoListParam
     * @return
     * @throws Exception
     */
    List<MenuInfoVo> getMenuInfoServiceList(MenuInfoListParam menuInfoListParam) throws Exception;

    /**
     * 获取 系统功能菜单信息表 分页对象列表
     *
     * @param menuInfoPageParam
     * @return
     * @throws Exception
     */
    Paging<MenuInfoVo> getMenuInfoServicePageList(MenuInfoPageParam menuInfoPageParam) throws Exception;

    /**
     * 计算 系统功能菜单信息表 总记录数
     *
     * @param menuInfoCountParam
     * @return
     * @throws Exception
     */
    Integer countMenuInfoService(MenuInfoCountParam menuInfoCountParam) throws Exception;

}
