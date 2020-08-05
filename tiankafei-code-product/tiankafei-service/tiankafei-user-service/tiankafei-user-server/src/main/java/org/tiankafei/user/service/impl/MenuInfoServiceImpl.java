package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.user.entity.MenuInfoEntity;
import org.tiankafei.user.mapper.MenuInfoMapper;
import org.tiankafei.user.param.MenuInfoCheckParam;
import org.tiankafei.user.param.MenuInfoCountParam;
import org.tiankafei.user.param.MenuInfoDeleteParam;
import org.tiankafei.user.param.MenuInfoListParam;
import org.tiankafei.user.param.MenuInfoPageParam;
import org.tiankafei.user.service.MenuInfoService;
import org.tiankafei.user.vo.MenuInfoVo;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 系统功能菜单信息表 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
public class MenuInfoServiceImpl extends BaseServiceImpl<MenuInfoMapper, MenuInfoEntity> implements MenuInfoService {

    @Autowired
    private MenuInfoMapper menuInfoMapper;


    /**
     * 校验 系统功能菜单信息表 是否已经存在
     *
     * @param menuInfoCheckParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkMenuInfoServiceExists(MenuInfoCheckParam menuInfoCheckParam) throws Exception {
        LambdaQueryWrapper<MenuInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (menuInfoCheckParam != null) {
            Long id = menuInfoCheckParam.getId();
            if (id != null) {
                lambdaQueryWrapper.ne(MenuInfoEntity::getId, id);
            }
        }
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    /**
     * 保存 系统功能菜单信息表
     *
     * @param menuInfoVo
     * @return
     * @throws Exception
     */
    @Override
    public Long addMenuInfoService(MenuInfoVo menuInfoVo) throws Exception {
        MenuInfoEntity menuInfoEntity = new MenuInfoEntity();
        BeanUtils.copyProperties(menuInfoVo, menuInfoEntity);
        super.save(menuInfoEntity);
        return menuInfoEntity.getId();
    }

    /**
     * 保存 系统功能菜单信息表 集合
     *
     * @param menuInfoVoList
     * @return
     * @throws Exception
     */
    @Override
    public List<Long> batchAddMenuInfoService(List<MenuInfoVo> menuInfoVoList) throws Exception {
        if (CollectionUtils.isNotEmpty(menuInfoVoList)) {
            List<MenuInfoEntity> menuInfoEntityList = Lists.newArrayList();
            for (MenuInfoVo menuInfoVo : menuInfoVoList) {
                MenuInfoEntity menuInfoEntity = new MenuInfoEntity();
                BeanUtils.copyProperties(menuInfoVo, menuInfoEntity);
                menuInfoEntityList.add(menuInfoEntity);
            }
            super.saveBatch(menuInfoEntityList);

            return menuInfoEntityList.stream().map(menuInfoEntity -> menuInfoEntity.getId()).collect(Collectors.toList());
        }
        return Lists.newArrayList();
    }

    /**
     * 删除 系统功能菜单信息表
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteMenuInfoService(String id) throws Exception {
        if (StringUtils.isNotBlank(id)) {
            return super.removeById(id);
        }
        return Boolean.TRUE;
    }

    /**
     * 删除 系统功能菜单信息表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public boolean batchDeleteMenuInfoService(String ids) throws Exception {
        if (StringUtils.isNotBlank(ids)) {
            List<String> idList = Arrays.asList(ids.split(","));
            return super.removeByIds(idList);
        }
        return Boolean.TRUE;
    }

    /**
     * 根据条件删除 系统功能菜单信息表
     *
     * @param menuInfoDeleteParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean conditionDeleteMenuInfoService(MenuInfoDeleteParam menuInfoDeleteParam) throws Exception {
        LambdaQueryWrapper<MenuInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (menuInfoDeleteParam != null) {

        }
        return super.remove(lambdaQueryWrapper);
    }

    /**
     * 修改 系统功能菜单信息表
     *
     * @param menuInfoVo
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateMenuInfoService(MenuInfoVo menuInfoVo) throws Exception {
        MenuInfoEntity menuInfoEntity = new MenuInfoEntity();
        BeanUtils.copyProperties(menuInfoVo, menuInfoEntity);
        return super.updateById(menuInfoEntity);
    }

    /**
     * 根据ID获取 系统功能菜单信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public MenuInfoVo getMenuInfoServiceById(Serializable id) throws Exception {
        MenuInfoEntity menuInfoEntity = super.getById(id);
        if (menuInfoEntity == null) {
            return null;
        }
        MenuInfoVo menuInfoVo = new MenuInfoVo();
        BeanUtils.copyProperties(menuInfoEntity, menuInfoVo);
        return menuInfoVo;
    }

    /**
     * 获取 系统功能菜单信息表 对象列表
     *
     * @param menuInfoListParam
     * @return
     * @throws Exception
     */
    @Override
    public List<MenuInfoVo> getMenuInfoServiceList(MenuInfoListParam menuInfoListParam) throws Exception {
        return menuInfoMapper.getMenuInfoServiceList(menuInfoListParam);
    }

    /**
     * 获取 系统功能菜单信息表 分页对象列表
     *
     * @param menuInfoPageParam
     * @return
     * @throws Exception
     */
    @Override
    public Paging<MenuInfoVo> getMenuInfoServicePageList(MenuInfoPageParam menuInfoPageParam) throws Exception {
        Page page = setPageParam(menuInfoPageParam, OrderItem.desc("create_time"));
        // 分页查询先查询主键id
        IPage<MenuInfoVo> iPage = menuInfoMapper.getMenuInfoServicePageList(page, menuInfoPageParam);
        List<Long> idList = iPage.getRecords().stream().map(menuInfoVo -> menuInfoVo.getId()).collect(Collectors.toList());

        // 再根据查到的主键id查询数据
        Paging<MenuInfoVo> paging = new Paging();
        paging.setTotal(iPage.getTotal());
        if (CollectionUtils.isNotEmpty(idList)) {
            MenuInfoListParam menuInfoListParam = new MenuInfoListParam();
            menuInfoListParam.setIdList(idList);
            List<MenuInfoVo> menuInfoVoList = this.getMenuInfoServiceList(menuInfoListParam);
            paging.setRecords(menuInfoVoList);
        }
        return paging;
    }

    /**
     * 计算 系统功能菜单信息表 总记录数
     *
     * @param menuInfoCountParam
     * @return
     * @throws Exception
     */
    @Override
    public Integer countMenuInfoService(MenuInfoCountParam menuInfoCountParam) throws Exception {
        LambdaQueryWrapper<MenuInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (menuInfoCountParam != null) {

        }
        return super.count(lambdaQueryWrapper);
    }


}
