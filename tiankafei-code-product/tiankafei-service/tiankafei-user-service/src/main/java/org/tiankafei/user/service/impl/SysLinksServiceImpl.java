package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.user.entity.SysLinksEntity;
import org.tiankafei.user.mapper.SysLinksMapper;
import org.tiankafei.user.param.SysLinksPageQueryParam;
import org.tiankafei.user.param.SysLinksQueryParam;
import org.tiankafei.user.service.SysLinksService;
import org.tiankafei.user.vo.SysLinksQueryVo;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * 系统的友情链接 服务实现类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SysLinksServiceImpl extends BaseServiceImpl<SysLinksMapper, SysLinksEntity> implements SysLinksService {

    @Autowired
    private SysLinksMapper sysLinksMapper;

    @Override
    public boolean checkSysLinksExists(SysLinksQueryParam sysLinksQueryParam) throws Exception {
        LambdaQueryWrapper<SysLinksEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    @Override
    public Object addSysLinks(SysLinksQueryVo sysLinksQueryVo) throws Exception {
        SysLinksEntity sysLinksEntity = new SysLinksEntity();
        BeanUtils.copyProperties(sysLinksQueryVo, sysLinksEntity);
        super.save(sysLinksEntity);
        return sysLinksEntity.getId();
    }

    @Override
    public boolean addSysLinksList(List<SysLinksQueryVo> sysLinksQueryVoList) throws Exception {
        if (sysLinksQueryVoList != null && !sysLinksQueryVoList.isEmpty()) {
            List<SysLinksEntity> sysLinksList = new ArrayList<>();
            for (SysLinksQueryVo sysLinksQueryVo : sysLinksQueryVoList) {
                SysLinksEntity sysLinksEntity = new SysLinksEntity();
                BeanUtils.copyProperties(sysLinksQueryVo, sysLinksEntity);
                sysLinksList.add(sysLinksEntity);
            }
            super.saveBatch(sysLinksList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysLinks(SysLinksQueryVo sysLinksQueryVo) throws Exception {
        SysLinksEntity sysLinksEntity = new SysLinksEntity();
        BeanUtils.copyProperties(sysLinksQueryVo, sysLinksEntity);
        return super.updateById(sysLinksEntity);
    }

    @Override
    public boolean deleteSysLinks(String ids) throws Exception {
        String[] idArray = ids.split(",");
        return super.removeByIds(Arrays.asList(idArray));
    }

    @Override
    public boolean deleteSysLinks(SysLinksQueryParam sysLinksQueryParam) throws Exception {
        LambdaQueryWrapper<SysLinksEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

        return super.remove(lambdaQueryWrapper);
    }

    @Override
    public SysLinksQueryVo getSysLinksById(Serializable id) throws Exception {
        SysLinksEntity sysLinksEntity = super.getById(id);
        SysLinksQueryVo sysLinksQueryVo = new SysLinksQueryVo();
        BeanUtils.copyProperties(sysLinksEntity, sysLinksQueryVo);
        return sysLinksQueryVo;
    }

    @Override
    public Paging<SysLinksQueryVo> getSysLinksPageList(SysLinksPageQueryParam sysLinksPageQueryParam) throws Exception {
        Page page = setPageParam(sysLinksPageQueryParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper<SysLinksEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<SysLinksQueryVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<SysLinksQueryVo> getSysLinksList(SysLinksQueryParam sysLinksQueryParam) throws Exception {
        List<SysLinksQueryVo> sysLinksQueryVoList = sysLinksMapper.getSysLinksList(sysLinksQueryParam);
        return sysLinksQueryVoList;
    }

    @Override
    public int countSysLinks(SysLinksQueryParam sysLinksQueryParam) throws Exception {
        LambdaQueryWrapper<SysLinksEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}