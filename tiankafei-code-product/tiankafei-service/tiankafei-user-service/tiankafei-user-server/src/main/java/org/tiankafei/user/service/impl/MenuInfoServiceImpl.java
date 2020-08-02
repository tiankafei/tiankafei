package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.user.entity.MenuInfoEntity;
import org.tiankafei.user.mapper.MenuInfoMapper;
import org.tiankafei.user.param.MenuInfoListParam;
import org.tiankafei.user.param.MenuInfoPageParam;
import org.tiankafei.user.service.MenuInfoService;
import org.tiankafei.user.vo.MenuInfoVo;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

/**
 * <pre>
 * 系统功能菜单信息表 服务实现类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class MenuInfoServiceImpl extends BaseServiceImpl<MenuInfoMapper, MenuInfoEntity> implements MenuInfoService {

    @Autowired
    private MenuInfoMapper menuInfoMapper;

    @Override
    public boolean checkSysMenuInfoExists(MenuInfoListParam menuInfoListParam) throws Exception {
        LambdaQueryWrapper<MenuInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    @Override
    public Object addSysMenuInfo(MenuInfoVo menuInfoVo) throws Exception {
        MenuInfoEntity menuInfoEntity = new MenuInfoEntity();
        BeanUtils.copyProperties(menuInfoVo, menuInfoEntity);
        super.save(menuInfoEntity);
        return menuInfoEntity.getId();
    }

    @Override
    public boolean addSysMenuInfoList(List<MenuInfoVo> menuInfoVoList) throws Exception {
        if (menuInfoVoList != null && !menuInfoVoList.isEmpty()) {
            List<MenuInfoEntity> sysMenuInfoList = new ArrayList<>();
            for (MenuInfoVo menuInfoVo : menuInfoVoList) {
                MenuInfoEntity menuInfoEntity = new MenuInfoEntity();
                BeanUtils.copyProperties(menuInfoVo, menuInfoEntity);
                sysMenuInfoList.add(menuInfoEntity);
            }
            super.saveBatch(sysMenuInfoList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysMenuInfo(MenuInfoVo menuInfoVo) throws Exception {
        MenuInfoEntity menuInfoEntity = new MenuInfoEntity();
        BeanUtils.copyProperties(menuInfoVo, menuInfoEntity);
        return super.updateById(menuInfoEntity);
    }

    @Override
    public boolean deleteSysMenuInfo(String ids) throws Exception {
        String[] idArray = ids.split(",");
        return super.removeByIds(Arrays.asList(idArray));
    }

    @Override
    public boolean deleteSysMenuInfo(MenuInfoListParam menuInfoListParam) throws Exception {
        LambdaQueryWrapper<MenuInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

        return super.remove(lambdaQueryWrapper);
    }

    @Override
    public MenuInfoVo getSysMenuInfoById(Serializable id) throws Exception {
        //SysMenuInfoQueryVo sysMenuInfoQueryVo = sysMenuInfoMapper.getSysMenuInfoById(id);

        MenuInfoEntity menuInfoEntity = super.getById(id);
        MenuInfoVo menuInfoVo = new MenuInfoVo();
        BeanUtils.copyProperties(menuInfoEntity, menuInfoVo);
        return menuInfoVo;
    }

    @Override
    public Paging<MenuInfoVo> getSysMenuInfoPageList(MenuInfoPageParam menuInfoPageParam) throws Exception {
        //IPage<SysMenuInfoQueryVo> iPage = sysMenuInfoMapper.getSysMenuInfoPageList(page, sysMenuInfoPageQueryParam);

        Page page = setPageParam(menuInfoPageParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper<MenuInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<MenuInfoVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<MenuInfoVo> getSysMenuInfoList(MenuInfoListParam menuInfoListParam) throws Exception {
        List<MenuInfoVo> menuInfoVoList = menuInfoMapper.getSysMenuInfoList(menuInfoListParam);

        // 按照getParentId进行分组
        Map<Integer, List<MenuInfoVo>> sysMenuInfoQueryVoListMap = menuInfoVoList.stream().filter(sysMenuInfoQueryVo -> sysMenuInfoQueryVo.getParentId() != null).collect(Collectors.groupingBy(MenuInfoVo::getParentId));

        List<MenuInfoVo> resultList = menuInfoVoList.stream().map(sysMenuInfoQueryVo -> {
            Integer id = sysMenuInfoQueryVo.getId();
            List<MenuInfoVo> tempMenuInfoVoList = sysMenuInfoQueryVoListMap.get(id);
            if (CollectionUtils.isNotEmpty(tempMenuInfoVoList)) {
                List<MenuInfoVo> menuInfoList = tempMenuInfoVoList.stream().sorted(Comparator.comparing(MenuInfoVo::getSerialNumber)).collect(Collectors.toList());
                sysMenuInfoQueryVo.setMenuInfoList(menuInfoList);
            }
            return sysMenuInfoQueryVo;
        }).filter(sysMenuInfoQueryVo -> sysMenuInfoQueryVo.getId() == null).collect(Collectors.toList());

        return resultList;
    }

    @Override
    public int countSysMenuInfo(MenuInfoListParam menuInfoListParam) throws Exception {
        LambdaQueryWrapper<MenuInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}