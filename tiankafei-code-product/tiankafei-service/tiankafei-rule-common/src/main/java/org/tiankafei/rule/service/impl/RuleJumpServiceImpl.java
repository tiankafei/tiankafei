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
import org.tiankafei.rule.entity.RuleJumpEntity;
import org.tiankafei.rule.param.RuleJumpCheckParam;
import org.tiankafei.rule.param.RuleJumpCountParam;
import org.tiankafei.rule.param.RuleJumpDeleteParam;
import org.tiankafei.rule.param.RuleJumpPageParam;
import org.tiankafei.rule.param.RuleJumpListParam;
import org.tiankafei.rule.vo.RuleJumpVo;
import org.tiankafei.rule.mapper.RuleJumpMapper;
import org.tiankafei.rule.service.RuleJumpService;
import com.ruoyi.common.core.web.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.common.core.web.page.Paging;

/**
 * <p>
 * 跳转规则记录的数据唯一标识 服务实现类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RuleJumpServiceImpl extends BaseServiceImpl<RuleJumpMapper, RuleJumpEntity> implements RuleJumpService {

    @Autowired
    private RuleJumpMapper ruleJumpMapper;


    /**
     * 校验 跳转规则记录的数据唯一标识 是否已经存在
     *
     * @param ruleJumpCheckParam
     * @return
     * @throws Exception
     */
	@Override
    public boolean checkRuleJumpServiceExists(RuleJumpCheckParam ruleJumpCheckParam) throws Exception {
		LambdaQueryWrapper<RuleJumpEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
		if (ruleJumpCheckParam != null) {
			Long id = ruleJumpCheckParam.getId();
			if(id != null){
				lambdaQueryWrapper.ne(RuleJumpEntity::getId, id);
			}
		}
		int count = super.count(lambdaQueryWrapper);
		return count > 0;
	}

    /**
     * 保存 跳转规则记录的数据唯一标识
     *
     * @param ruleJumpVo
     * @return
     * @throws Exception
     */
	@Override
    public Long addRuleJumpService(RuleJumpVo ruleJumpVo) throws Exception {
		RuleJumpEntity ruleJumpEntity = new RuleJumpEntity();
		BeanUtils.copyProperties(ruleJumpVo, ruleJumpEntity);
		super.save(ruleJumpEntity);
		return ruleJumpEntity.getId();
	}

    /**
     * 保存 跳转规则记录的数据唯一标识 集合
     *
     * @param ruleJumpVoList
     * @return
     * @throws Exception
     */
	@Override
    public List<Long> batchAddRuleJumpService(List<RuleJumpVo> ruleJumpVoList) throws Exception {
		if (CollectionUtils.isNotEmpty(ruleJumpVoList)) {
			List<RuleJumpEntity> ruleJumpEntityList = Lists.newArrayList();
			for (RuleJumpVo ruleJumpVo : ruleJumpVoList) {
				RuleJumpEntity ruleJumpEntity = new RuleJumpEntity();
				BeanUtils.copyProperties(ruleJumpVo, ruleJumpEntity);
				ruleJumpEntityList.add(ruleJumpEntity);
			}
			super.saveBatch(ruleJumpEntityList);

			return ruleJumpEntityList.stream().map(ruleJumpEntity -> ruleJumpEntity.getId()).collect(Collectors.toList());
		}
		return Lists.newArrayList();
	}

    /**
     * 删除 跳转规则记录的数据唯一标识
     *
     * @param id
     * @return
     * @throws Exception
     */
	@Override
    public boolean deleteRuleJumpService(String id) throws Exception {
		if(StringUtils.isNotBlank(id)){
			return super.removeById(id);
		}
		return Boolean.TRUE;
	}
	
    /**
     * 批量删除 跳转规则记录的数据唯一标识
     *
     * @param ids
     * @return
     * @throws Exception
     */
	@Override
    public boolean batchDeleteRuleJumpService(String ids) throws Exception {
		if(StringUtils.isNotBlank(ids)){
			List<String> idList = Arrays.asList(ids.split(","));
			return super.removeByIds(idList);
		}
		return Boolean.TRUE;
	}

    /**
     * 根据条件删除 跳转规则记录的数据唯一标识
     *
     * @param ruleJumpDeleteParam
     * @return
     * @throws Exception
     */
	@Override
    public boolean conditionDeleteRuleJumpService(RuleJumpDeleteParam ruleJumpDeleteParam) throws Exception {
		LambdaQueryWrapper<RuleJumpEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
		if (ruleJumpDeleteParam != null) {

		}
		return super.remove(lambdaQueryWrapper);
	}

    /**
     * 修改 跳转规则记录的数据唯一标识
     *
     * @param ruleJumpVo
     * @return
     * @throws Exception
     */
	@Override
    public boolean updateRuleJumpService(RuleJumpVo ruleJumpVo) throws Exception {
		RuleJumpEntity ruleJumpEntity = new RuleJumpEntity();
		BeanUtils.copyProperties(ruleJumpVo, ruleJumpEntity);
		return super.updateById(ruleJumpEntity);
	}

    /**
     * 根据ID获取 跳转规则记录的数据唯一标识 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
	@Override
    public RuleJumpVo getRuleJumpServiceById(Serializable id) throws Exception {
		RuleJumpEntity ruleJumpEntity = super.getById(id);
		if (ruleJumpEntity == null) {
			return null;
		}
		RuleJumpVo ruleJumpVo = new RuleJumpVo();
		BeanUtils.copyProperties(ruleJumpEntity, ruleJumpVo);
		return ruleJumpVo;
	}

    /**
     * 获取 跳转规则记录的数据唯一标识 对象列表
     *
     * @param ruleJumpListParam
     * @return
     * @throws Exception
     */
	@Override
    public List<RuleJumpVo> getRuleJumpServiceList(RuleJumpListParam ruleJumpListParam) throws Exception {
		return ruleJumpMapper.getRuleJumpServiceList(ruleJumpListParam);
	}

    /**
     * 获取 跳转规则记录的数据唯一标识 分页对象列表
     *
     * @param ruleJumpPageParam
     * @return
     * @throws Exception
     */
	@Override
    public Paging<RuleJumpVo> getRuleJumpServicePageList(RuleJumpPageParam ruleJumpPageParam) throws Exception {
		Page page = setPageParam(ruleJumpPageParam, OrderItem.desc("create_time"));
		// 分页查询先查询主键id
		IPage<RuleJumpVo> iPage = ruleJumpMapper.getRuleJumpServicePageList(page, ruleJumpPageParam);
		List<Long> idList = iPage.getRecords().stream().map(ruleJumpVo -> ruleJumpVo.getId()).collect(Collectors.toList());

		// 再根据查到的主键id查询数据
		Paging<RuleJumpVo> paging = new Paging();
		paging.setTotal(iPage.getTotal());
		if (CollectionUtils.isNotEmpty(idList)) {
			RuleJumpListParam ruleJumpListParam = new RuleJumpListParam();
			ruleJumpListParam.setIdList(idList);
			List<RuleJumpVo> ruleJumpVoList = this.getRuleJumpServiceList(ruleJumpListParam);
			paging.setRecords(ruleJumpVoList);
		}
		return paging;
	}

    /**
     * 计算 跳转规则记录的数据唯一标识 总记录数
     *
     * @param ruleJumpCountParam
     * @return
     * @throws Exception
     */
	@Override
    public Integer countRuleJumpService(RuleJumpCountParam ruleJumpCountParam) throws Exception {
		LambdaQueryWrapper<RuleJumpEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
		if (ruleJumpCountParam != null) {

		}
		return super.count(lambdaQueryWrapper);
	}
	

}
