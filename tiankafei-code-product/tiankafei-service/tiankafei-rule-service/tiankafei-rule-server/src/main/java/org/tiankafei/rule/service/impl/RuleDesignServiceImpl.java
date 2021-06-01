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
import org.tiankafei.rule.entity.RuleDesignEntity;
import org.tiankafei.rule.mapper.RuleDesignMapper;
import org.tiankafei.rule.param.RuleDesignCheckParam;
import org.tiankafei.rule.param.RuleDesignCountParam;
import org.tiankafei.rule.param.RuleDesignDeleteParam;
import org.tiankafei.rule.param.RuleDesignListParam;
import org.tiankafei.rule.param.RuleDesignPageParam;
import org.tiankafei.rule.service.RuleDesignService;
import org.tiankafei.rule.vo.RuleDesignVo;

/**
 * <p>
 * 系统规则设计表达式用户新增的对象 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RuleDesignServiceImpl extends BaseServiceImpl<RuleDesignMapper, RuleDesignEntity> implements RuleDesignService {

    @Autowired
    private RuleDesignMapper ruleDesignMapper;


    /**
     * 校验 系统规则设计表达式用户新增的对象 是否已经存在
     *
     * @param ruleDesignCheckParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkRuleDesignServiceExists(RuleDesignCheckParam ruleDesignCheckParam) throws Exception {
        LambdaQueryWrapper<RuleDesignEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (ruleDesignCheckParam != null) {
            Long id = ruleDesignCheckParam.getId();
            if (id != null) {
                lambdaQueryWrapper.ne(RuleDesignEntity::getId, id);
            }
        }
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    /**
     * 保存 系统规则设计表达式用户新增的对象
     *
     * @param ruleDesignVo
     * @return
     * @throws Exception
     */
    @Override
    public Long addRuleDesignService(RuleDesignVo ruleDesignVo) throws Exception {
        RuleDesignEntity ruleDesignEntity = new RuleDesignEntity();
        BeanUtils.copyProperties(ruleDesignVo, ruleDesignEntity);
        super.save(ruleDesignEntity);
        return ruleDesignEntity.getId();
    }

    /**
     * 保存 系统规则设计表达式用户新增的对象 集合
     *
     * @param ruleDesignVoList
     * @return
     * @throws Exception
     */
    @Override
    public List<Long> batchAddRuleDesignService(List<RuleDesignVo> ruleDesignVoList) throws Exception {
        if (CollectionUtils.isNotEmpty(ruleDesignVoList)) {
            List<RuleDesignEntity> ruleDesignEntityList = Lists.newArrayList();
            for (RuleDesignVo ruleDesignVo : ruleDesignVoList) {
                RuleDesignEntity ruleDesignEntity = new RuleDesignEntity();
                BeanUtils.copyProperties(ruleDesignVo, ruleDesignEntity);
                ruleDesignEntityList.add(ruleDesignEntity);
            }
            super.saveBatch(ruleDesignEntityList);

            return ruleDesignEntityList.stream().map(ruleDesignEntity -> ruleDesignEntity.getId()).collect(Collectors.toList());
        }
        return Lists.newArrayList();
    }

    /**
     * 删除 系统规则设计表达式用户新增的对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteRuleDesignService(String id) throws Exception {
        if (StringUtils.isNotBlank(id)) {
            return super.removeById(id);
        }
        return Boolean.TRUE;
    }

    /**
     * 批量删除 系统规则设计表达式用户新增的对象
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public boolean batchDeleteRuleDesignService(String ids) throws Exception {
        if (StringUtils.isNotBlank(ids)) {
            List<String> idList = Arrays.asList(ids.split(","));
            return super.removeByIds(idList);
        }
        return Boolean.TRUE;
    }

    /**
     * 根据条件删除 系统规则设计表达式用户新增的对象
     *
     * @param ruleDesignDeleteParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean conditionDeleteRuleDesignService(RuleDesignDeleteParam ruleDesignDeleteParam) throws Exception {
        LambdaQueryWrapper<RuleDesignEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (ruleDesignDeleteParam != null) {

        }
        return super.remove(lambdaQueryWrapper);
    }

    /**
     * 修改 系统规则设计表达式用户新增的对象
     *
     * @param ruleDesignVo
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateRuleDesignService(RuleDesignVo ruleDesignVo) throws Exception {
        RuleDesignEntity ruleDesignEntity = new RuleDesignEntity();
        BeanUtils.copyProperties(ruleDesignVo, ruleDesignEntity);
        return super.updateById(ruleDesignEntity);
    }

    /**
     * 根据ID获取 系统规则设计表达式用户新增的对象 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public RuleDesignVo getRuleDesignServiceById(Serializable id) throws Exception {
        RuleDesignEntity ruleDesignEntity = super.getById(id);
        if (ruleDesignEntity == null) {
            return null;
        }
        RuleDesignVo ruleDesignVo = new RuleDesignVo();
        BeanUtils.copyProperties(ruleDesignEntity, ruleDesignVo);
        return ruleDesignVo;
    }

    /**
     * 获取 系统规则设计表达式用户新增的对象 对象列表
     *
     * @param ruleDesignListParam
     * @return
     * @throws Exception
     */
    @Override
    public List<RuleDesignVo> getRuleDesignServiceList(RuleDesignListParam ruleDesignListParam) throws Exception {
        return ruleDesignMapper.getRuleDesignServiceList(ruleDesignListParam);
    }

    /**
     * 获取 系统规则设计表达式用户新增的对象 分页对象列表
     *
     * @param ruleDesignPageParam
     * @return
     * @throws Exception
     */
    @Override
    public Paging<RuleDesignVo> getRuleDesignServicePageList(RuleDesignPageParam ruleDesignPageParam) throws Exception {
        Page page = setPageParam(ruleDesignPageParam, OrderItem.desc("create_time"));
        // 分页查询先查询主键id
        IPage<RuleDesignVo> iPage = ruleDesignMapper.getRuleDesignServicePageList(page, ruleDesignPageParam);
        List<Long> idList = iPage.getRecords().stream().map(ruleDesignVo -> ruleDesignVo.getId()).collect(Collectors.toList());

        // 再根据查到的主键id查询数据
        Paging<RuleDesignVo> paging = new Paging();
        paging.setTotal(iPage.getTotal());
        if (CollectionUtils.isNotEmpty(idList)) {
            RuleDesignListParam ruleDesignListParam = new RuleDesignListParam();
            ruleDesignListParam.setIdList(idList);
            List<RuleDesignVo> ruleDesignVoList = this.getRuleDesignServiceList(ruleDesignListParam);
            paging.setRecords(ruleDesignVoList);
        }
        return paging;
    }

    /**
     * 计算 系统规则设计表达式用户新增的对象 总记录数
     *
     * @param ruleDesignCountParam
     * @return
     * @throws Exception
     */
    @Override
    public Integer countRuleDesignService(RuleDesignCountParam ruleDesignCountParam) throws Exception {
        LambdaQueryWrapper<RuleDesignEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (ruleDesignCountParam != null) {

        }
        return super.count(lambdaQueryWrapper);
    }


}
