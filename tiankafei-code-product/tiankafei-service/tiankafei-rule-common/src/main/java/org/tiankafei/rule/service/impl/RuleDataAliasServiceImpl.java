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
import org.tiankafei.rule.entity.RuleDataAliasEntity;
import org.tiankafei.rule.mapper.RuleDataAliasMapper;
import org.tiankafei.rule.param.RuleDataAliasCheckParam;
import org.tiankafei.rule.param.RuleDataAliasCountParam;
import org.tiankafei.rule.param.RuleDataAliasDeleteParam;
import org.tiankafei.rule.param.RuleDataAliasListParam;
import org.tiankafei.rule.param.RuleDataAliasPageParam;
import org.tiankafei.rule.service.RuleDataAliasService;
import org.tiankafei.rule.vo.RuleDataAliasVo;

/**
 * <p>
 * 规则中用到的数据的别名 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RuleDataAliasServiceImpl extends BaseServiceImpl<RuleDataAliasMapper, RuleDataAliasEntity> implements RuleDataAliasService {

    @Autowired
    private RuleDataAliasMapper ruleDataAliasMapper;


    /**
     * 校验 规则中用到的数据的别名 是否已经存在
     *
     * @param ruleDataAliasCheckParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkRuleDataAliasServiceExists(RuleDataAliasCheckParam ruleDataAliasCheckParam) throws Exception {
        LambdaQueryWrapper<RuleDataAliasEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (ruleDataAliasCheckParam != null) {
            Long id = ruleDataAliasCheckParam.getId();
            if (id != null) {
                lambdaQueryWrapper.ne(RuleDataAliasEntity::getId, id);
            }
        }
        int count = super.count(lambdaQueryWrapper);
        return count > 0;
    }

    /**
     * 保存 规则中用到的数据的别名
     *
     * @param ruleDataAliasVo
     * @return
     * @throws Exception
     */
    @Override
    public Long addRuleDataAliasService(RuleDataAliasVo ruleDataAliasVo) throws Exception {
        RuleDataAliasEntity ruleDataAliasEntity = new RuleDataAliasEntity();
        BeanUtils.copyProperties(ruleDataAliasVo, ruleDataAliasEntity);
        super.save(ruleDataAliasEntity);
        return ruleDataAliasEntity.getId();
    }

    /**
     * 保存 规则中用到的数据的别名 集合
     *
     * @param ruleDataAliasVoList
     * @return
     * @throws Exception
     */
    @Override
    public List<Long> batchAddRuleDataAliasService(List<RuleDataAliasVo> ruleDataAliasVoList) throws Exception {
        if (CollectionUtils.isNotEmpty(ruleDataAliasVoList)) {
            List<RuleDataAliasEntity> ruleDataAliasEntityList = Lists.newArrayList();
            for (RuleDataAliasVo ruleDataAliasVo : ruleDataAliasVoList) {
                RuleDataAliasEntity ruleDataAliasEntity = new RuleDataAliasEntity();
                BeanUtils.copyProperties(ruleDataAliasVo, ruleDataAliasEntity);
                ruleDataAliasEntityList.add(ruleDataAliasEntity);
            }
            super.saveBatch(ruleDataAliasEntityList);

            return ruleDataAliasEntityList.stream().map(ruleDataAliasEntity -> ruleDataAliasEntity.getId()).collect(Collectors.toList());
        }
        return Lists.newArrayList();
    }

    /**
     * 删除 规则中用到的数据的别名
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteRuleDataAliasService(String id) throws Exception {
        if (StringUtils.isNotBlank(id)) {
            return super.removeById(id);
        }
        return Boolean.TRUE;
    }

    /**
     * 批量删除 规则中用到的数据的别名
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public boolean batchDeleteRuleDataAliasService(String ids) throws Exception {
        if (StringUtils.isNotBlank(ids)) {
            List<String> idList = Arrays.asList(ids.split(","));
            return super.removeByIds(idList);
        }
        return Boolean.TRUE;
    }

    /**
     * 根据条件删除 规则中用到的数据的别名
     *
     * @param ruleDataAliasDeleteParam
     * @return
     * @throws Exception
     */
    @Override
    public boolean conditionDeleteRuleDataAliasService(RuleDataAliasDeleteParam ruleDataAliasDeleteParam) throws Exception {
        LambdaQueryWrapper<RuleDataAliasEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (ruleDataAliasDeleteParam != null) {

        }
        return super.remove(lambdaQueryWrapper);
    }

    /**
     * 修改 规则中用到的数据的别名
     *
     * @param ruleDataAliasVo
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateRuleDataAliasService(RuleDataAliasVo ruleDataAliasVo) throws Exception {
        RuleDataAliasEntity ruleDataAliasEntity = new RuleDataAliasEntity();
        BeanUtils.copyProperties(ruleDataAliasVo, ruleDataAliasEntity);
        return super.updateById(ruleDataAliasEntity);
    }

    /**
     * 根据ID获取 规则中用到的数据的别名 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public RuleDataAliasVo getRuleDataAliasServiceById(Serializable id) throws Exception {
        RuleDataAliasEntity ruleDataAliasEntity = super.getById(id);
        if (ruleDataAliasEntity == null) {
            return null;
        }
        RuleDataAliasVo ruleDataAliasVo = new RuleDataAliasVo();
        BeanUtils.copyProperties(ruleDataAliasEntity, ruleDataAliasVo);
        return ruleDataAliasVo;
    }

    /**
     * 获取 规则中用到的数据的别名 对象列表
     *
     * @param ruleDataAliasListParam
     * @return
     * @throws Exception
     */
    @Override
    public List<RuleDataAliasVo> getRuleDataAliasServiceList(RuleDataAliasListParam ruleDataAliasListParam) throws Exception {
        return ruleDataAliasMapper.getRuleDataAliasServiceList(ruleDataAliasListParam);
    }

    /**
     * 获取 规则中用到的数据的别名 分页对象列表
     *
     * @param ruleDataAliasPageParam
     * @return
     * @throws Exception
     */
    @Override
    public Paging<RuleDataAliasVo> getRuleDataAliasServicePageList(RuleDataAliasPageParam ruleDataAliasPageParam) throws Exception {
        Page page = setPageParam(ruleDataAliasPageParam, OrderItem.desc("create_time"));
        // 分页查询先查询主键id
        IPage<RuleDataAliasVo> iPage = ruleDataAliasMapper.getRuleDataAliasServicePageList(page, ruleDataAliasPageParam);
        List<Long> idList = iPage.getRecords().stream().map(ruleDataAliasVo -> ruleDataAliasVo.getId()).collect(Collectors.toList());

        // 再根据查到的主键id查询数据
        Paging<RuleDataAliasVo> paging = new Paging();
        paging.setTotal(iPage.getTotal());
        if (CollectionUtils.isNotEmpty(idList)) {
            RuleDataAliasListParam ruleDataAliasListParam = new RuleDataAliasListParam();
            ruleDataAliasListParam.setIdList(idList);
            List<RuleDataAliasVo> ruleDataAliasVoList = this.getRuleDataAliasServiceList(ruleDataAliasListParam);
            paging.setRecords(ruleDataAliasVoList);
        }
        return paging;
    }

    /**
     * 计算 规则中用到的数据的别名 总记录数
     *
     * @param ruleDataAliasCountParam
     * @return
     * @throws Exception
     */
    @Override
    public Integer countRuleDataAliasService(RuleDataAliasCountParam ruleDataAliasCountParam) throws Exception {
        LambdaQueryWrapper<RuleDataAliasEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (ruleDataAliasCountParam != null) {

        }
        return super.count(lambdaQueryWrapper);
    }


}
