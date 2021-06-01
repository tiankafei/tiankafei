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
import org.tiankafei.rule.entity.RuleExecuteEntity;
import org.tiankafei.rule.mapper.RuleExecuteMapper;
import org.tiankafei.rule.param.RuleExecuteCheckParam;
import org.tiankafei.rule.param.RuleExecuteCountParam;
import org.tiankafei.rule.param.RuleExecuteDeleteParam;
import org.tiankafei.rule.param.RuleExecuteListParam;
import org.tiankafei.rule.param.RuleExecutePageParam;
import org.tiankafei.rule.service.RuleExecuteService;
import org.tiankafei.rule.vo.RuleExecuteVo;

/**
 * <p>
 * 系统规则设计执行的对象 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RuleExecuteServiceImpl extends BaseServiceImpl<RuleExecuteMapper, RuleExecuteEntity> implements RuleExecuteService {

    @Autowired
    private RuleExecuteMapper ruleExecuteMapper;


    /**
     * 校验 系统规则设计执行的对象 是否已经存在
     *
     * @param ruleExecuteCheckParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkRuleExecuteServiceExists(RuleExecuteCheckParam ruleExecuteCheckParam) throws Exception {
        LambdaQueryWrapper<RuleExecuteEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (ruleExecuteCheckParam != null) {
            Long id = ruleExecuteCheckParam.getId();
            if (id != null) {
                lambdaQueryWrapper.ne(RuleExecuteEntity::getId, id);
            }
        }
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    /**
     * 保存 系统规则设计执行的对象
     *
     * @param ruleExecuteVo
     * @return
     * @throws Exception
     */
    @Override
    public Long addRuleExecuteService(RuleExecuteVo ruleExecuteVo) throws Exception {
        RuleExecuteEntity ruleExecuteEntity = new RuleExecuteEntity();
        BeanUtils.copyProperties(ruleExecuteVo, ruleExecuteEntity);
        super.save(ruleExecuteEntity);
        return ruleExecuteEntity.getId();
    }

    /**
     * 保存 系统规则设计执行的对象 集合
     *
     * @param ruleExecuteVoList
     * @return
     * @throws Exception
     */
    @Override
    public List<Long> batchAddRuleExecuteService(List<RuleExecuteVo> ruleExecuteVoList) throws Exception {
        if (CollectionUtils.isNotEmpty(ruleExecuteVoList)) {
            List<RuleExecuteEntity> ruleExecuteEntityList = Lists.newArrayList();
            for (RuleExecuteVo ruleExecuteVo : ruleExecuteVoList) {
                RuleExecuteEntity ruleExecuteEntity = new RuleExecuteEntity();
                BeanUtils.copyProperties(ruleExecuteVo, ruleExecuteEntity);
                ruleExecuteEntityList.add(ruleExecuteEntity);
            }
            super.saveBatch(ruleExecuteEntityList);

            return ruleExecuteEntityList.stream().map(ruleExecuteEntity -> ruleExecuteEntity.getId()).collect(Collectors.toList());
        }
        return Lists.newArrayList();
    }

    /**
     * 删除 系统规则设计执行的对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteRuleExecuteService(String id) throws Exception {
        if (StringUtils.isNotBlank(id)) {
            return super.removeById(id);
        }
        return Boolean.TRUE;
    }

    /**
     * 批量删除 系统规则设计执行的对象
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public boolean batchDeleteRuleExecuteService(String ids) throws Exception {
        if (StringUtils.isNotBlank(ids)) {
            List<String> idList = Arrays.asList(ids.split(","));
            return super.removeByIds(idList);
        }
        return Boolean.TRUE;
    }

    /**
     * 根据条件删除 系统规则设计执行的对象
     *
     * @param ruleExecuteDeleteParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean conditionDeleteRuleExecuteService(RuleExecuteDeleteParam ruleExecuteDeleteParam) throws Exception {
        LambdaQueryWrapper<RuleExecuteEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (ruleExecuteDeleteParam != null) {

        }
        return super.remove(lambdaQueryWrapper);
    }

    /**
     * 修改 系统规则设计执行的对象
     *
     * @param ruleExecuteVo
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateRuleExecuteService(RuleExecuteVo ruleExecuteVo) throws Exception {
        RuleExecuteEntity ruleExecuteEntity = new RuleExecuteEntity();
        BeanUtils.copyProperties(ruleExecuteVo, ruleExecuteEntity);
        return super.updateById(ruleExecuteEntity);
    }

    /**
     * 根据ID获取 系统规则设计执行的对象 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public RuleExecuteVo getRuleExecuteServiceById(Serializable id) throws Exception {
        RuleExecuteEntity ruleExecuteEntity = super.getById(id);
        if (ruleExecuteEntity == null) {
            return null;
        }
        RuleExecuteVo ruleExecuteVo = new RuleExecuteVo();
        BeanUtils.copyProperties(ruleExecuteEntity, ruleExecuteVo);
        return ruleExecuteVo;
    }

    /**
     * 获取 系统规则设计执行的对象 对象列表
     *
     * @param ruleExecuteListParam
     * @return
     * @throws Exception
     */
    @Override
    public List<RuleExecuteVo> getRuleExecuteServiceList(RuleExecuteListParam ruleExecuteListParam) throws Exception {
        return ruleExecuteMapper.getRuleExecuteServiceList(ruleExecuteListParam);
    }

    /**
     * 获取 系统规则设计执行的对象 分页对象列表
     *
     * @param ruleExecutePageParam
     * @return
     * @throws Exception
     */
    @Override
    public Paging<RuleExecuteVo> getRuleExecuteServicePageList(RuleExecutePageParam ruleExecutePageParam) throws Exception {
        Page page = setPageParam(ruleExecutePageParam, OrderItem.desc("create_time"));
        // 分页查询先查询主键id
        IPage<RuleExecuteVo> iPage = ruleExecuteMapper.getRuleExecuteServicePageList(page, ruleExecutePageParam);
        List<Long> idList = iPage.getRecords().stream().map(ruleExecuteVo -> ruleExecuteVo.getId()).collect(Collectors.toList());

        // 再根据查到的主键id查询数据
        Paging<RuleExecuteVo> paging = new Paging();
        paging.setTotal(iPage.getTotal());
        if (CollectionUtils.isNotEmpty(idList)) {
            RuleExecuteListParam ruleExecuteListParam = new RuleExecuteListParam();
            ruleExecuteListParam.setIdList(idList);
            List<RuleExecuteVo> ruleExecuteVoList = this.getRuleExecuteServiceList(ruleExecuteListParam);
            paging.setRecords(ruleExecuteVoList);
        }
        return paging;
    }

    /**
     * 计算 系统规则设计执行的对象 总记录数
     *
     * @param ruleExecuteCountParam
     * @return
     * @throws Exception
     */
    @Override
    public Integer countRuleExecuteService(RuleExecuteCountParam ruleExecuteCountParam) throws Exception {
        LambdaQueryWrapper<RuleExecuteEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (ruleExecuteCountParam != null) {

        }
        return super.count(lambdaQueryWrapper);
    }


}
