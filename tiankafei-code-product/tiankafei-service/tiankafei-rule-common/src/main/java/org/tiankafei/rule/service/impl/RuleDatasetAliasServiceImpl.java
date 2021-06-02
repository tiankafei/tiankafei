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
import org.tiankafei.rule.entity.RuleDatasetAliasEntity;
import org.tiankafei.rule.mapper.RuleDatasetAliasMapper;
import org.tiankafei.rule.param.RuleDatasetAliasCheckParam;
import org.tiankafei.rule.param.RuleDatasetAliasCountParam;
import org.tiankafei.rule.param.RuleDatasetAliasDeleteParam;
import org.tiankafei.rule.param.RuleDatasetAliasListParam;
import org.tiankafei.rule.param.RuleDatasetAliasPageParam;
import org.tiankafei.rule.service.RuleDatasetAliasService;
import org.tiankafei.rule.vo.RuleDatasetAliasVo;

/**
 * <p>
 * 规则数据集的别名 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RuleDatasetAliasServiceImpl extends BaseServiceImpl<RuleDatasetAliasMapper, RuleDatasetAliasEntity> implements RuleDatasetAliasService {

    @Autowired
    private RuleDatasetAliasMapper ruleDatasetAliasMapper;


    /**
     * 校验 规则数据集的别名 是否已经存在
     *
     * @param ruleDatasetAliasCheckParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkRuleDatasetAliasServiceExists(RuleDatasetAliasCheckParam ruleDatasetAliasCheckParam) throws Exception {
        LambdaQueryWrapper<RuleDatasetAliasEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (ruleDatasetAliasCheckParam != null) {
            Long id = ruleDatasetAliasCheckParam.getId();
            if (id != null) {
                lambdaQueryWrapper.ne(RuleDatasetAliasEntity::getId, id);
            }
        }
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    /**
     * 保存 规则数据集的别名
     *
     * @param ruleDatasetAliasVo
     * @return
     * @throws Exception
     */
    @Override
    public Long addRuleDatasetAliasService(RuleDatasetAliasVo ruleDatasetAliasVo) throws Exception {
        RuleDatasetAliasEntity ruleDatasetAliasEntity = new RuleDatasetAliasEntity();
        BeanUtils.copyProperties(ruleDatasetAliasVo, ruleDatasetAliasEntity);
        super.save(ruleDatasetAliasEntity);
        return ruleDatasetAliasEntity.getId();
    }

    /**
     * 保存 规则数据集的别名 集合
     *
     * @param ruleDatasetAliasVoList
     * @return
     * @throws Exception
     */
    @Override
    public List<Long> batchAddRuleDatasetAliasService(List<RuleDatasetAliasVo> ruleDatasetAliasVoList) throws Exception {
        if (CollectionUtils.isNotEmpty(ruleDatasetAliasVoList)) {
            List<RuleDatasetAliasEntity> ruleDatasetAliasEntityList = Lists.newArrayList();
            for (RuleDatasetAliasVo ruleDatasetAliasVo : ruleDatasetAliasVoList) {
                RuleDatasetAliasEntity ruleDatasetAliasEntity = new RuleDatasetAliasEntity();
                BeanUtils.copyProperties(ruleDatasetAliasVo, ruleDatasetAliasEntity);
                ruleDatasetAliasEntityList.add(ruleDatasetAliasEntity);
            }
            super.saveBatch(ruleDatasetAliasEntityList);

            return ruleDatasetAliasEntityList.stream().map(ruleDatasetAliasEntity -> ruleDatasetAliasEntity.getId()).collect(Collectors.toList());
        }
        return Lists.newArrayList();
    }

    /**
     * 删除 规则数据集的别名
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteRuleDatasetAliasService(String id) throws Exception {
        if (StringUtils.isNotBlank(id)) {
            return super.removeById(id);
        }
        return Boolean.TRUE;
    }

    /**
     * 批量删除 规则数据集的别名
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public boolean batchDeleteRuleDatasetAliasService(String ids) throws Exception {
        if (StringUtils.isNotBlank(ids)) {
            List<String> idList = Arrays.asList(ids.split(","));
            return super.removeByIds(idList);
        }
        return Boolean.TRUE;
    }

    /**
     * 根据条件删除 规则数据集的别名
     *
     * @param ruleDatasetAliasDeleteParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean conditionDeleteRuleDatasetAliasService(RuleDatasetAliasDeleteParam ruleDatasetAliasDeleteParam) throws Exception {
        LambdaQueryWrapper<RuleDatasetAliasEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (ruleDatasetAliasDeleteParam != null) {

        }
        return super.remove(lambdaQueryWrapper);
    }

    /**
     * 修改 规则数据集的别名
     *
     * @param ruleDatasetAliasVo
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateRuleDatasetAliasService(RuleDatasetAliasVo ruleDatasetAliasVo) throws Exception {
        RuleDatasetAliasEntity ruleDatasetAliasEntity = new RuleDatasetAliasEntity();
        BeanUtils.copyProperties(ruleDatasetAliasVo, ruleDatasetAliasEntity);
        return super.updateById(ruleDatasetAliasEntity);
    }

    /**
     * 根据ID获取 规则数据集的别名 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public RuleDatasetAliasVo getRuleDatasetAliasServiceById(Serializable id) throws Exception {
        RuleDatasetAliasEntity ruleDatasetAliasEntity = super.getById(id);
        if (ruleDatasetAliasEntity == null) {
            return null;
        }
        RuleDatasetAliasVo ruleDatasetAliasVo = new RuleDatasetAliasVo();
        BeanUtils.copyProperties(ruleDatasetAliasEntity, ruleDatasetAliasVo);
        return ruleDatasetAliasVo;
    }

    /**
     * 获取 规则数据集的别名 对象列表
     *
     * @param ruleDatasetAliasListParam
     * @return
     * @throws Exception
     */
    @Override
    public List<RuleDatasetAliasVo> getRuleDatasetAliasServiceList(RuleDatasetAliasListParam ruleDatasetAliasListParam) throws Exception {
        return ruleDatasetAliasMapper.getRuleDatasetAliasServiceList(ruleDatasetAliasListParam);
    }

    /**
     * 获取 规则数据集的别名 分页对象列表
     *
     * @param ruleDatasetAliasPageParam
     * @return
     * @throws Exception
     */
    @Override
    public Paging<RuleDatasetAliasVo> getRuleDatasetAliasServicePageList(RuleDatasetAliasPageParam ruleDatasetAliasPageParam) throws Exception {
        Page page = setPageParam(ruleDatasetAliasPageParam, OrderItem.desc("create_time"));
        // 分页查询先查询主键id
        IPage<RuleDatasetAliasVo> iPage = ruleDatasetAliasMapper.getRuleDatasetAliasServicePageList(page, ruleDatasetAliasPageParam);
        List<Long> idList = iPage.getRecords().stream().map(ruleDatasetAliasVo -> ruleDatasetAliasVo.getId()).collect(Collectors.toList());

        // 再根据查到的主键id查询数据
        Paging<RuleDatasetAliasVo> paging = new Paging();
        paging.setTotal(iPage.getTotal());
        if (CollectionUtils.isNotEmpty(idList)) {
            RuleDatasetAliasListParam ruleDatasetAliasListParam = new RuleDatasetAliasListParam();
            ruleDatasetAliasListParam.setIdList(idList);
            List<RuleDatasetAliasVo> ruleDatasetAliasVoList = this.getRuleDatasetAliasServiceList(ruleDatasetAliasListParam);
            paging.setRecords(ruleDatasetAliasVoList);
        }
        return paging;
    }

    /**
     * 计算 规则数据集的别名 总记录数
     *
     * @param ruleDatasetAliasCountParam
     * @return
     * @throws Exception
     */
    @Override
    public Integer countRuleDatasetAliasService(RuleDatasetAliasCountParam ruleDatasetAliasCountParam) throws Exception {
        LambdaQueryWrapper<RuleDatasetAliasEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (ruleDatasetAliasCountParam != null) {

        }
        return super.count(lambdaQueryWrapper);
    }


}
