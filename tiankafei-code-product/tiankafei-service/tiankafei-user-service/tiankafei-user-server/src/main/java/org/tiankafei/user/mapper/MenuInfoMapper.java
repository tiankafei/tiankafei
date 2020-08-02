package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.user.entity.MenuInfoEntity;
import org.tiankafei.user.param.MenuInfoCheckParam;
import org.tiankafei.user.param.MenuInfoCountParam;
import org.tiankafei.user.param.MenuInfoDeleteParam;
import org.tiankafei.user.param.MenuInfoListParam;
import org.tiankafei.user.param.MenuInfoPageParam;
import org.tiankafei.user.vo.MenuInfoVo;

/**
 * <p>
 * 系统功能菜单信息表 Mapper 接口
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface MenuInfoMapper extends BaseMapper<MenuInfoEntity> {

    /**
     * 校验 系统功能菜单信息表 是否已经存在
     *
     * @param menuInfoCheckParam
     * @return
     * @throws Exception
     */
    boolean checkMenuInfoServiceExists(@Param("param") MenuInfoCheckParam menuInfoCheckParam) throws Exception;

    /**
     * 保存 系统功能菜单信息表
     *
     * @param menuInfoVo
     * @return
     * @throws Exception
     */
    Object addMenuInfoService(@Param("param") MenuInfoVo menuInfoVo) throws Exception;

    /**
     * 批量保存 系统功能菜单信息表
     *
     * @param menuInfoVoList
     * @return
     * @throws Exception
     */
    List<Object> batchAddMenuInfoService(@Param("param") List<MenuInfoVo> menuInfoVoList) throws Exception;

    /**
     * 删除 系统功能菜单信息表
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteMenuInfoService(@Param("param") String id) throws Exception;

    /**
     * 批量删除 系统功能菜单信息表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteMenuInfoService(@Param("param") String ids) throws Exception;

    /**
     * 根据条件删除 系统功能菜单信息表
     *
     * @param menuInfoDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteMenuInfoService(@Param("param") MenuInfoDeleteParam menuInfoDeleteParam) throws Exception;

    /**
     * 修改 系统功能菜单信息表
     *
     * @param menuInfoVo
     * @return
     * @throws Exception
     */
    boolean updateMenuInfoService(@Param("param") MenuInfoVo menuInfoVo) throws Exception;

    /**
     * 根据ID获取 系统功能菜单信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    MenuInfoVo getMenuInfoServiceById(@Param("param") Serializable id) throws Exception;

    /**
     * 获取 系统功能菜单信息表 对象列表
     *
     * @param menuInfoListParam
     * @return
     * @throws Exception
     */
    List<MenuInfoVo> getMenuInfoServiceList(@Param("param") MenuInfoListParam menuInfoListParam) throws Exception;

    /**
     * 获取 系统功能菜单信息表 分页对象列表
     *
     * @param page
     * @param menuInfoPageParam
     * @return
     * @throws Exception
     */
    IPage<MenuInfoVo> getMenuInfoServicePageList(@Param("page") Page page, @Param("param") MenuInfoPageParam menuInfoPageParam) throws Exception;

    /**
     * 计算 系统功能菜单信息表 总记录数
     *
     * @param menuInfoCountParam
     * @return
     * @throws Exception
     */
    Integer countMenuInfoService(@Param("param") MenuInfoCountParam menuInfoCountParam) throws Exception;

}
