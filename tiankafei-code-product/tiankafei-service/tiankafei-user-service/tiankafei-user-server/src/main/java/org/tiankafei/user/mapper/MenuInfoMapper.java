package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.user.entity.MenuInfoEntity;
import org.tiankafei.user.param.MenuInfoListParam;
import org.tiankafei.user.param.MenuInfoPageParam;
import org.tiankafei.user.vo.MenuInfoVo;

/**
 * <pre>
 * 系统功能菜单信息表 Mapper 接口
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface MenuInfoMapper extends BaseMapper<MenuInfoEntity> {

    /**
     * 根据ID获取 系统功能菜单信息表 对象
     *
     * @param id
     * @return
     */
    MenuInfoVo getSysMenuInfoById(Serializable id);

    /**
     * 获取 系统功能菜单信息表 分页对象
     *
     * @param page
     * @param menuInfoPageParam
     * @return
     */
    IPage<MenuInfoVo> getSysMenuInfoPageList(@Param("page") Page page, @Param("param") MenuInfoPageParam menuInfoPageParam);

    /**
     * 获取 系统功能菜单信息表 对象列表
     *
     * @param menuInfoListParam
     * @return
     */
    List<MenuInfoVo> getSysMenuInfoList(@Param("param") MenuInfoListParam menuInfoListParam);

}