package org.tiankafei.rule.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.tiankafei.rule.entity.RuleAliasEntity;
import org.tiankafei.rule.param.RuleAliasCheckParam;
import org.tiankafei.rule.param.RuleAliasCountParam;
import org.tiankafei.rule.param.RuleAliasDeleteParam;
import org.tiankafei.rule.param.RuleAliasPageParam;
import org.tiankafei.rule.param.RuleAliasListParam;
import org.tiankafei.rule.vo.RuleAliasVo;
import org.tiankafei.rule.mapper.RuleAliasMapper;
import org.tiankafei.rule.service.RuleAliasService;
import com.ruoyi.common.core.web.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.common.core.web.page.Paging;

/**
 * <p>
 * 规则的别名 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RuleAliasServiceImpl extends BaseServiceImpl<RuleAliasMapper, RuleAliasEntity> implements RuleAliasService {

    @Autowired
    private RuleAliasMapper ruleAliasMapper;


    /**
     * 校验 规则的别名 是否已经存在
     *
     * @param ruleAliasCheckParam
     * @return
     * @throws Exception
     */
	@Override
    public boolean checkRuleAliasServiceExists(RuleAliasCheckParam ruleAliasCheckParam) throws Exception {
		LambdaQueryWrapper<RuleAliasEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
		if (ruleAliasCheckParam != null) {
			Long id = ruleAliasCheckParam.getId();
			if(id != null){
				lambdaQueryWrapper.ne(RuleAliasEntity::getId, id);
			}
		}
		int count = super.count(lambdaQueryWrapper);
		return count > 0;
	}

    /**
     * 保存 规则的别名
     *
     * @param ruleAliasVo
     * @return
     * @throws Exception
     */
	@Override
    public Long addRuleAliasService(RuleAliasVo ruleAliasVo) throws Exception {
		RuleAliasEntity ruleAliasEntity = new RuleAliasEntity();
		BeanUtils.copyProperties(ruleAliasVo, ruleAliasEntity);
		super.save(ruleAliasEntity);
		return ruleAliasEntity.getId();
	}

    /**
     * 保存 规则的别名 集合
     *
     * @param ruleAliasVoList
     * @return
     * @throws Exception
     */
	@Override
    public List<Long> batchAddRuleAliasService(List<RuleAliasVo> ruleAliasVoList) throws Exception {
		if (CollectionUtils.isNotEmpty(ruleAliasVoList)) {
			List<RuleAliasEntity> ruleAliasEntityList = Lists.newArrayList();
			for (RuleAliasVo ruleAliasVo : ruleAliasVoList) {
				RuleAliasEntity ruleAliasEntity = new RuleAliasEntity();
				BeanUtils.copyProperties(ruleAliasVo, ruleAliasEntity);
				ruleAliasEntityList.add(ruleAliasEntity);
			}
			super.saveBatch(ruleAliasEntityList);

			return ruleAliasEntityList.stream().map(ruleAliasEntity -> ruleAliasEntity.getId()).collect(Collectors.toList());
		}
		return Lists.newArrayList();
	}

    /**
     * 删除 规则的别名
     *
     * @param id
     * @return
     * @throws Exception
     */
	@Override
    public boolean deleteRuleAliasService(String id) throws Exception {
		if(StringUtils.isNotBlank(id)){
			return super.removeById(id);
		}
		return Boolean.TRUE;
	}
	
    /**
     * 批量删除 规则的别名
     *
     * @param ids
     * @return
     * @throws Exception
     */
	@Override
    public boolean batchDeleteRuleAliasService(String ids) throws Exception {
		if(StringUtils.isNotBlank(ids)){
			List<String> idList = Arrays.asList(ids.split(","));
			return super.removeByIds(idList);
		}
		return Boolean.TRUE;
	}

    /**
     * 根据条件删除 规则的别名
     *
     * @param ruleAliasDeleteParam
     * @return
     * @throws Exception
     */
	@Override
    public boolean conditionDeleteRuleAliasService(RuleAliasDeleteParam ruleAliasDeleteParam) throws Exception {
		LambdaQueryWrapper<RuleAliasEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
		if (ruleAliasDeleteParam != null) {

		}
		return super.remove(lambdaQueryWrapper);
	}

    /**
     * 修改 规则的别名
     *
     * @param ruleAliasVo
     * @return
     * @throws Exception
     */
	@Override
    public boolean updateRuleAliasService(RuleAliasVo ruleAliasVo) throws Exception {
		RuleAliasEntity ruleAliasEntity = new RuleAliasEntity();
		BeanUtils.copyProperties(ruleAliasVo, ruleAliasEntity);
		return super.updateById(ruleAliasEntity);
	}

    /**
     * 根据ID获取 规则的别名 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
	@Override
    public RuleAliasVo getRuleAliasServiceById(Serializable id) throws Exception {
		RuleAliasEntity ruleAliasEntity = super.getById(id);
		if (ruleAliasEntity == null) {
			return null;
		}
		RuleAliasVo ruleAliasVo = new RuleAliasVo();
		BeanUtils.copyProperties(ruleAliasEntity, ruleAliasVo);
		return ruleAliasVo;
	}

    /**
     * 获取 规则的别名 对象列表
     *
     * @param ruleAliasListParam
     * @return
     * @throws Exception
     */
	@Override
    public List<RuleAliasVo> getRuleAliasServiceList(RuleAliasListParam ruleAliasListParam) throws Exception {
		return ruleAliasMapper.getRuleAliasServiceList(ruleAliasListParam);
	}

    /**
     * 获取 规则的别名 分页对象列表
     *
     * @param ruleAliasPageParam
     * @return
     * @throws Exception
     */
	@Override
    public Paging<RuleAliasVo> getRuleAliasServicePageList(RuleAliasPageParam ruleAliasPageParam) throws Exception {
		Page page = setPageParam(ruleAliasPageParam, OrderItem.desc("create_time"));
		// 分页查询先查询主键id
		IPage<RuleAliasVo> iPage = ruleAliasMapper.getRuleAliasServicePageList(page, ruleAliasPageParam);
		List<Long> idList = iPage.getRecords().stream().map(ruleAliasVo -> ruleAliasVo.getId()).collect(Collectors.toList());

		// 再根据查到的主键id查询数据
		Paging<RuleAliasVo> paging = new Paging();
		paging.setTotal(iPage.getTotal());
		if (CollectionUtils.isNotEmpty(idList)) {
			RuleAliasListParam ruleAliasListParam = new RuleAliasListParam();
			ruleAliasListParam.setIdList(idList);
			List<RuleAliasVo> ruleAliasVoList = this.getRuleAliasServiceList(ruleAliasListParam);
			paging.setRecords(ruleAliasVoList);
		}
		return paging;
	}

    /**
     * 计算 规则的别名 总记录数
     *
     * @param ruleAliasCountParam
     * @return
     * @throws Exception
     */
	@Override
    public Integer countRuleAliasService(RuleAliasCountParam ruleAliasCountParam) throws Exception {
		LambdaQueryWrapper<RuleAliasEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
		if (ruleAliasCountParam != null) {

		}
		return super.count(lambdaQueryWrapper);
	}
	

}
