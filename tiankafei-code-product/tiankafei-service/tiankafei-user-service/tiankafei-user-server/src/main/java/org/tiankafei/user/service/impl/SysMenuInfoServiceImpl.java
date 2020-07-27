package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.user.entity.SysMenuInfoEntity;
import org.tiankafei.user.mapper.SysMenuInfoMapper;
import org.tiankafei.user.param.SysMenuInfoPageQueryParam;
import org.tiankafei.user.param.SysMenuInfoQueryParam;
import org.tiankafei.user.service.SysMenuInfoService;
import org.tiankafei.user.vo.SysMenuInfoQueryVo;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class SysMenuInfoServiceImpl extends BaseServiceImpl<SysMenuInfoMapper, SysMenuInfoEntity> implements SysMenuInfoService {

    @Autowired
    private SysMenuInfoMapper sysMenuInfoMapper;

    @Override
    public boolean checkSysMenuInfoExists(SysMenuInfoQueryParam sysMenuInfoQueryParam) throws Exception {
        LambdaQueryWrapper<SysMenuInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    @Override
    public Object addSysMenuInfo(SysMenuInfoQueryVo sysMenuInfoQueryVo) throws Exception {
        SysMenuInfoEntity sysMenuInfoEntity = new SysMenuInfoEntity();
        BeanUtils.copyProperties(sysMenuInfoQueryVo, sysMenuInfoEntity);
        super.save(sysMenuInfoEntity);
        return sysMenuInfoEntity.getId();
    }

    @Override
    public boolean addSysMenuInfoList(List<SysMenuInfoQueryVo> sysMenuInfoQueryVoList) throws Exception {
        if (sysMenuInfoQueryVoList != null && !sysMenuInfoQueryVoList.isEmpty()) {
            List<SysMenuInfoEntity> sysMenuInfoList = new ArrayList<>();
            for (SysMenuInfoQueryVo sysMenuInfoQueryVo : sysMenuInfoQueryVoList) {
                SysMenuInfoEntity sysMenuInfoEntity = new SysMenuInfoEntity();
                BeanUtils.copyProperties(sysMenuInfoQueryVo, sysMenuInfoEntity);
                sysMenuInfoList.add(sysMenuInfoEntity);
            }
            super.saveBatch(sysMenuInfoList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysMenuInfo(SysMenuInfoQueryVo sysMenuInfoQueryVo) throws Exception {
        SysMenuInfoEntity sysMenuInfoEntity = new SysMenuInfoEntity();
        BeanUtils.copyProperties(sysMenuInfoQueryVo, sysMenuInfoEntity);
        return super.updateById(sysMenuInfoEntity);
    }

    @Override
    public boolean deleteSysMenuInfo(String ids) throws Exception {
        String[] idArray = ids.split(",");
        return super.removeByIds(Arrays.asList(idArray));
    }

    @Override
    public boolean deleteSysMenuInfo(SysMenuInfoQueryParam sysMenuInfoQueryParam) throws Exception {
        LambdaQueryWrapper<SysMenuInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

        return super.remove(lambdaQueryWrapper);
    }

    @Override
    public SysMenuInfoQueryVo getSysMenuInfoById(Serializable id) throws Exception {
        //SysMenuInfoQueryVo sysMenuInfoQueryVo = sysMenuInfoMapper.getSysMenuInfoById(id);

        SysMenuInfoEntity sysMenuInfoEntity = super.getById(id);
        SysMenuInfoQueryVo sysMenuInfoQueryVo = new SysMenuInfoQueryVo();
        BeanUtils.copyProperties(sysMenuInfoEntity, sysMenuInfoQueryVo);
        return sysMenuInfoQueryVo;
    }

    @Override
    public Paging<SysMenuInfoQueryVo> getSysMenuInfoPageList(SysMenuInfoPageQueryParam sysMenuInfoPageQueryParam) throws Exception {
        //IPage<SysMenuInfoQueryVo> iPage = sysMenuInfoMapper.getSysMenuInfoPageList(page, sysMenuInfoPageQueryParam);

        Page page = setPageParam(sysMenuInfoPageQueryParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper<SysMenuInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<SysMenuInfoQueryVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<SysMenuInfoQueryVo> getSysMenuInfoList(SysMenuInfoQueryParam sysMenuInfoQueryParam) throws Exception {
        List<SysMenuInfoQueryVo> sysMenuInfoQueryVoList = sysMenuInfoMapper.getSysMenuInfoList(sysMenuInfoQueryParam);

        // 按照getParentId进行分组
        Map<Integer, List<SysMenuInfoQueryVo>> sysMenuInfoQueryVoListMap = sysMenuInfoQueryVoList.stream().filter(sysMenuInfoQueryVo -> sysMenuInfoQueryVo.getParentId() != null).collect(Collectors.groupingBy(SysMenuInfoQueryVo::getParentId));

        List<SysMenuInfoQueryVo> resultList = sysMenuInfoQueryVoList.stream().map(sysMenuInfoQueryVo -> {
            Integer id = sysMenuInfoQueryVo.getId();
            List<SysMenuInfoQueryVo> tempSysMenuInfoQueryVoList = sysMenuInfoQueryVoListMap.get(id);
            if (CollectionUtils.isNotEmpty(tempSysMenuInfoQueryVoList)) {
                List<SysMenuInfoQueryVo> menuInfoList = tempSysMenuInfoQueryVoList.stream().sorted(Comparator.comparing(SysMenuInfoQueryVo::getSerialNumber)).collect(Collectors.toList());
                sysMenuInfoQueryVo.setMenuInfoList(menuInfoList);
            }
            return sysMenuInfoQueryVo;
        }).filter(sysMenuInfoQueryVo -> sysMenuInfoQueryVo.getId() == null).collect(Collectors.toList());

        return resultList;
    }

    @Override
    public int countSysMenuInfo(SysMenuInfoQueryParam sysMenuInfoQueryParam) throws Exception {
        LambdaQueryWrapper<SysMenuInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}