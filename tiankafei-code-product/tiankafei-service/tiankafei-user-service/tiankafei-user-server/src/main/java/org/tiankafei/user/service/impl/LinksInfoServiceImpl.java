package org.tiankafei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.ruoyi.common.core.web.service.impl.BaseServiceImpl;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiankafei.user.entity.LinksInfoEntity;
import org.tiankafei.user.mapper.LinksInfoMapper;
import org.tiankafei.user.param.LinksInfoCheckParam;
import org.tiankafei.user.param.LinksInfoCountParam;
import org.tiankafei.user.param.LinksInfoDeleteParam;
import org.tiankafei.user.param.LinksInfoListParam;
import org.tiankafei.user.param.LinksInfoPageParam;
import org.tiankafei.user.service.LinksInfoService;
import org.tiankafei.user.vo.LinksInfoVo;
import com.ruoyi.common.core.web.page.Paging;

/**
 * <p>
 * 系统的友情链接 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LinksInfoServiceImpl extends BaseServiceImpl<LinksInfoMapper, LinksInfoEntity> implements LinksInfoService {

    @Autowired
    private LinksInfoMapper linksInfoMapper;


    /**
     * 校验 系统的友情链接 是否已经存在
     *
     * @param linksInfoCheckParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkLinksInfoServiceExists(LinksInfoCheckParam linksInfoCheckParam) throws Exception {
        LambdaQueryWrapper<LinksInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (linksInfoCheckParam != null) {
            Long id = linksInfoCheckParam.getId();
            if (id != null) {
                lambdaQueryWrapper.ne(LinksInfoEntity::getId, id);
            }
        }
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    /**
     * 保存 系统的友情链接
     *
     * @param linksInfoVo
     * @return
     * @throws Exception
     */
    @Override
    public Long addLinksInfoService(LinksInfoVo linksInfoVo) throws Exception {
        LinksInfoEntity linksInfoEntity = new LinksInfoEntity();
        BeanUtils.copyProperties(linksInfoVo, linksInfoEntity);
        super.save(linksInfoEntity);
        return linksInfoEntity.getId();
    }

    /**
     * 保存 系统的友情链接 集合
     *
     * @param linksInfoVoList
     * @return
     * @throws Exception
     */
    @Override
    public List<Long> batchAddLinksInfoService(List<LinksInfoVo> linksInfoVoList) throws Exception {
        if (CollectionUtils.isNotEmpty(linksInfoVoList)) {
            List<LinksInfoEntity> linksInfoEntityList = Lists.newArrayList();
            for (LinksInfoVo linksInfoVo : linksInfoVoList) {
                LinksInfoEntity linksInfoEntity = new LinksInfoEntity();
                BeanUtils.copyProperties(linksInfoVo, linksInfoEntity);
                linksInfoEntityList.add(linksInfoEntity);
            }
            super.saveBatch(linksInfoEntityList);

            return linksInfoEntityList.stream().map(linksInfoEntity -> linksInfoEntity.getId()).collect(Collectors.toList());
        }
        return Lists.newArrayList();
    }

    /**
     * 删除 系统的友情链接
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteLinksInfoService(String id) throws Exception {
        if (StringUtils.isNotBlank(id)) {
            return super.removeById(id);
        }
        return Boolean.TRUE;
    }

    /**
     * 批量删除 系统的友情链接
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public boolean batchDeleteLinksInfoService(String ids) throws Exception {
        if (StringUtils.isNotBlank(ids)) {
            List<String> idList = Arrays.asList(ids.split(","));
            return super.removeByIds(idList);
        }
        return Boolean.TRUE;
    }

    /**
     * 根据条件删除 系统的友情链接
     *
     * @param linksInfoDeleteParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean conditionDeleteLinksInfoService(LinksInfoDeleteParam linksInfoDeleteParam) throws Exception {
        LambdaQueryWrapper<LinksInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (linksInfoDeleteParam != null) {

        }
        return super.remove(lambdaQueryWrapper);
    }

    /**
     * 修改 系统的友情链接
     *
     * @param linksInfoVo
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateLinksInfoService(LinksInfoVo linksInfoVo) throws Exception {
        LinksInfoEntity linksInfoEntity = new LinksInfoEntity();
        BeanUtils.copyProperties(linksInfoVo, linksInfoEntity);
        return super.updateById(linksInfoEntity);
    }

    /**
     * 根据ID获取 系统的友情链接 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public LinksInfoVo getLinksInfoServiceById(Serializable id) throws Exception {
        LinksInfoEntity linksInfoEntity = super.getById(id);
        if (linksInfoEntity == null) {
            return null;
        }
        LinksInfoVo linksInfoVo = new LinksInfoVo();
        BeanUtils.copyProperties(linksInfoEntity, linksInfoVo);
        return linksInfoVo;
    }

    /**
     * 获取 系统的友情链接 对象列表
     *
     * @param linksInfoListParam
     * @return
     * @throws Exception
     */
    @Override
    public List<LinksInfoVo> getLinksInfoServiceList(LinksInfoListParam linksInfoListParam) throws Exception {
        return linksInfoMapper.getLinksInfoServiceList(linksInfoListParam);
    }

    /**
     * 获取 系统的友情链接 分页对象列表
     *
     * @param linksInfoPageParam
     * @return
     * @throws Exception
     */
    @Override
    public Paging<LinksInfoVo> getLinksInfoServicePageList(LinksInfoPageParam linksInfoPageParam) throws Exception {
        Page page = setPageParam(linksInfoPageParam, OrderItem.desc("create_time"));
        // 分页查询先查询主键id
        IPage<LinksInfoVo> iPage = linksInfoMapper.getLinksInfoServicePageList(page, linksInfoPageParam);
        List<Long> idList = iPage.getRecords().stream().map(linksInfoVo -> linksInfoVo.getId()).collect(Collectors.toList());

        // 再根据查到的主键id查询数据
        Paging<LinksInfoVo> paging = new Paging();
        paging.setTotal(iPage.getTotal());
        if (CollectionUtils.isNotEmpty(idList)) {
            LinksInfoListParam linksInfoListParam = new LinksInfoListParam();
            linksInfoListParam.setIdList(idList);
            List<LinksInfoVo> linksInfoVoList = this.getLinksInfoServiceList(linksInfoListParam);
            paging.setRecords(linksInfoVoList);
        }
        return paging;
    }

    /**
     * 计算 系统的友情链接 总记录数
     *
     * @param linksInfoCountParam
     * @return
     * @throws Exception
     */
    @Override
    public Integer countLinksInfoService(LinksInfoCountParam linksInfoCountParam) throws Exception {
        LambdaQueryWrapper<LinksInfoEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (linksInfoCountParam != null) {

        }
        return super.count(lambdaQueryWrapper);
    }


}
