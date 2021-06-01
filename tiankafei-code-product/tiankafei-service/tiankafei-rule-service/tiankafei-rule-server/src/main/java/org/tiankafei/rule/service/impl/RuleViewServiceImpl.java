package org.tiankafei.rule.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.ruoyi.common.core.web.page.Paging;
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
import org.tiankafei.rule.entity.RuleViewEntity;
import org.tiankafei.rule.mapper.RuleViewMapper;
import org.tiankafei.rule.param.RuleViewCheckParam;
import org.tiankafei.rule.param.RuleViewCountParam;
import org.tiankafei.rule.param.RuleViewDeleteParam;
import org.tiankafei.rule.param.RuleViewListParam;
import org.tiankafei.rule.param.RuleViewPageParam;
import org.tiankafei.rule.service.RuleViewService;
import org.tiankafei.rule.vo.RuleViewVo;

/**
 * <p>
 * 系统规则设计表达式显示对象 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RuleViewServiceImpl extends BaseServiceImpl<RuleViewMapper, RuleViewEntity> implements RuleViewService {

    @Autowired
    private RuleViewMapper ruleViewMapper;


    /**
     * 校验 系统规则设计表达式显示对象 是否已经存在
     *
     * @param ruleViewCheckParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkRuleViewServiceExists(RuleViewCheckParam ruleViewCheckParam) throws Exception {
        LambdaQueryWrapper<RuleViewEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (ruleViewCheckParam != null) {
            Long id = ruleViewCheckParam.getId();
            if (id != null) {
                lambdaQueryWrapper.ne(RuleViewEntity::getId, id);
            }
        }
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    /**
     * 保存 系统规则设计表达式显示对象
     *
     * @param ruleViewVo
     * @return
     * @throws Exception
     */
    @Override
    public Long addRuleViewService(RuleViewVo ruleViewVo) throws Exception {
        RuleViewEntity ruleViewEntity = new RuleViewEntity();
        BeanUtils.copyProperties(ruleViewVo, ruleViewEntity);
        super.save(ruleViewEntity);
        return ruleViewEntity.getId();
    }

    /**
     * 保存 系统规则设计表达式显示对象 集合
     *
     * @param ruleViewVoList
     * @return
     * @throws Exception
     */
    @Override
    public List<Long> batchAddRuleViewService(List<RuleViewVo> ruleViewVoList) throws Exception {
        if (CollectionUtils.isNotEmpty(ruleViewVoList)) {
            List<RuleViewEntity> ruleViewEntityList = Lists.newArrayList();
            for (RuleViewVo ruleViewVo : ruleViewVoList) {
                RuleViewEntity ruleViewEntity = new RuleViewEntity();
                BeanUtils.copyProperties(ruleViewVo, ruleViewEntity);
                ruleViewEntityList.add(ruleViewEntity);
            }
            super.saveBatch(ruleViewEntityList);

            return ruleViewEntityList.stream().map(ruleViewEntity -> ruleViewEntity.getId()).collect(Collectors.toList());
        }
        return Lists.newArrayList();
    }

    /**
     * 删除 系统规则设计表达式显示对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteRuleViewService(String id) throws Exception {
        if (StringUtils.isNotBlank(id)) {
            return super.removeById(id);
        }
        return Boolean.TRUE;
    }

    /**
     * 批量删除 系统规则设计表达式显示对象
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public boolean batchDeleteRuleViewService(String ids) throws Exception {
        if (StringUtils.isNotBlank(ids)) {
            List<String> idList = Arrays.asList(ids.split(","));
            return super.removeByIds(idList);
        }
        return Boolean.TRUE;
    }

    /**
     * 根据条件删除 系统规则设计表达式显示对象
     *
     * @param ruleViewDeleteParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean conditionDeleteRuleViewService(RuleViewDeleteParam ruleViewDeleteParam) throws Exception {
        LambdaQueryWrapper<RuleViewEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (ruleViewDeleteParam != null) {

        }
        return super.remove(lambdaQueryWrapper);
    }

    /**
     * 修改 系统规则设计表达式显示对象
     *
     * @param ruleViewVo
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateRuleViewService(RuleViewVo ruleViewVo) throws Exception {
        RuleViewEntity ruleViewEntity = new RuleViewEntity();
        BeanUtils.copyProperties(ruleViewVo, ruleViewEntity);
        return super.updateById(ruleViewEntity);
    }

    /**
     * 根据ID获取 系统规则设计表达式显示对象 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public RuleViewVo getRuleViewServiceById(Serializable id) throws Exception {
        RuleViewEntity ruleViewEntity = super.getById(id);
        if (ruleViewEntity == null) {
            return null;
        }
        RuleViewVo ruleViewVo = new RuleViewVo();
        BeanUtils.copyProperties(ruleViewEntity, ruleViewVo);
        return ruleViewVo;
    }

    /**
     * 获取 系统规则设计表达式显示对象 对象列表
     *
     * @param ruleViewListParam
     * @return
     * @throws Exception
     */
    @Override
    public List<RuleViewVo> getRuleViewServiceList(RuleViewListParam ruleViewListParam) throws Exception {
        return ruleViewMapper.getRuleViewServiceList(ruleViewListParam);
    }

    /**
     * 获取 系统规则设计表达式显示对象 分页对象列表
     *
     * @param ruleViewPageParam
     * @return
     * @throws Exception
     */
    @Override
    public Paging<RuleViewVo> getRuleViewServicePageList(RuleViewPageParam ruleViewPageParam) throws Exception {
        Page page = setPageParam(ruleViewPageParam, OrderItem.desc("create_time"));
        // 分页查询先查询主键id
        IPage<RuleViewVo> iPage = ruleViewMapper.getRuleViewServicePageList(page, ruleViewPageParam);
        List<Long> idList = iPage.getRecords().stream().map(ruleViewVo -> ruleViewVo.getId()).collect(Collectors.toList());

        // 再根据查到的主键id查询数据
        Paging<RuleViewVo> paging = new Paging();
        paging.setTotal(iPage.getTotal());
        if (CollectionUtils.isNotEmpty(idList)) {
            RuleViewListParam ruleViewListParam = new RuleViewListParam();
            ruleViewListParam.setIdList(idList);
            List<RuleViewVo> ruleViewVoList = this.getRuleViewServiceList(ruleViewListParam);
            paging.setRecords(ruleViewVoList);
        }
        return paging;
    }

    /**
     * 计算 系统规则设计表达式显示对象 总记录数
     *
     * @param ruleViewCountParam
     * @return
     * @throws Exception
     */
    @Override
    public Integer countRuleViewService(RuleViewCountParam ruleViewCountParam) throws Exception {
        LambdaQueryWrapper<RuleViewEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (ruleViewCountParam != null) {

        }
        return super.count(lambdaQueryWrapper);
    }


}
