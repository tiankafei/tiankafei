package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.user.entity.LinksInfoEntity;
import org.tiankafei.user.mapper.LinksInfoMapper;
import org.tiankafei.user.param.LinksInfoListParam;
import org.tiankafei.user.param.LinksInfoPageParam;
import org.tiankafei.user.service.LinksInfoService;
import org.tiankafei.user.vo.LinksInfoVo;
import org.tiankafei.web.common.constants.CommonConstant;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;
import org.tiankafei.web.common.vo.Paging;

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
public class LinksInfoServiceImpl extends BaseServiceImpl<LinksInfoMapper, LinksInfoEntity> implements LinksInfoService {

    @Autowired
    private LinksInfoMapper linksInfoMapper;

    @Override
    public boolean checkSysLinksExists(LinksInfoListParam linksInfoListParam) throws Exception {
        LambdaQueryWrapper<LinksInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    @Override
    public Object addSysLinks(LinksInfoVo linksInfoVo) throws Exception {
        LinksInfoEntity linksInfoEntity = new LinksInfoEntity();
        BeanUtils.copyProperties(linksInfoVo, linksInfoEntity);
        super.save(linksInfoEntity);
        return linksInfoEntity.getId();
    }

    @Override
    public boolean addSysLinksList(List<LinksInfoVo> linksInfoVoList) throws Exception {
        if (linksInfoVoList != null && !linksInfoVoList.isEmpty()) {
            List<LinksInfoEntity> sysLinksList = new ArrayList<>();
            for (LinksInfoVo linksInfoVo : linksInfoVoList) {
                LinksInfoEntity linksInfoEntity = new LinksInfoEntity();
                BeanUtils.copyProperties(linksInfoVo, linksInfoEntity);
                sysLinksList.add(linksInfoEntity);
            }
            super.saveBatch(sysLinksList, CommonConstant.BATCH_SAVE_COUNT);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean updateSysLinks(LinksInfoVo linksInfoVo) throws Exception {
        LinksInfoEntity linksInfoEntity = new LinksInfoEntity();
        BeanUtils.copyProperties(linksInfoVo, linksInfoEntity);
        return super.updateById(linksInfoEntity);
    }

    @Override
    public boolean deleteSysLinks(String ids) throws Exception {
        String[] idArray = ids.split(",");
        return super.removeByIds(Arrays.asList(idArray));
    }

    @Override
    public boolean deleteSysLinks(LinksInfoListParam linksInfoListParam) throws Exception {
        LambdaQueryWrapper<LinksInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();

        return super.remove(lambdaQueryWrapper);
    }

    @Override
    public LinksInfoVo getSysLinksById(Serializable id) throws Exception {
        //SysLinksQueryVo sysLinksQueryVo = sysLinksMapper.getSysLinksById(id);

        LinksInfoEntity linksInfoEntity = super.getById(id);
        LinksInfoVo linksInfoVo = new LinksInfoVo();
        BeanUtils.copyProperties(linksInfoEntity, linksInfoVo);
        return linksInfoVo;
    }

    @Override
    public Paging<LinksInfoVo> getSysLinksPageList(LinksInfoPageParam linksInfoPageParam) throws Exception {
        //IPage<SysLinksQueryVo> iPage = sysLinksMapper.getSysLinksPageList(page, sysLinksPageQueryParam);

        Page page = setPageParam(linksInfoPageParam, OrderItem.desc("create_time"));
        LambdaQueryWrapper<LinksInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        IPage<LinksInfoVo> iPage = super.page(page, lambdaQueryWrapper);
        return new Paging(iPage);
    }

    @Override
    public List<LinksInfoVo> getSysLinksList(LinksInfoListParam linksInfoListParam) throws Exception {
        List<LinksInfoVo> linksInfoVoList = linksInfoMapper.getSysLinksList(linksInfoListParam);
        return linksInfoVoList;
    }

    @Override
    public int countSysLinks(LinksInfoListParam linksInfoListParam) throws Exception {
        LambdaQueryWrapper<LinksInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        int count = super.count(lambdaQueryWrapper);
        return count;
    }

}