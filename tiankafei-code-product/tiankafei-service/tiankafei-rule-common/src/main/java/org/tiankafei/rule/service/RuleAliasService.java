package org.tiankafei.rule.service;

import java.io.Serializable;
import java.util.List;
import org.tiankafei.rule.entity.RuleAliasEntity;
import org.tiankafei.rule.param.RuleAliasCheckParam;
import org.tiankafei.rule.param.RuleAliasCountParam;
import org.tiankafei.rule.param.RuleAliasDeleteParam;
import org.tiankafei.rule.param.RuleAliasPageParam;
import org.tiankafei.rule.param.RuleAliasListParam;
import org.tiankafei.rule.vo.RuleAliasVo;
import com.ruoyi.common.core.web.service.BaseService;
import com.ruoyi.common.core.web.page.Paging;

/**
 * <p>
 * 规则的别名 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface RuleAliasService extends BaseService<RuleAliasEntity> {

    /**
     * 校验 规则的别名 是否已经存在
     *
     * @param ruleAliasCheckParam
     * @return
     * @throws Exception
     */
    boolean checkRuleAliasServiceExists(RuleAliasCheckParam ruleAliasCheckParam) throws Exception;

    /**
     * 保存 规则的别名
     *
     * @param ruleAliasVo
     * @return
     * @throws Exception
     */
    Long addRuleAliasService(RuleAliasVo ruleAliasVo) throws Exception;

    /**
     * 批量保存 规则的别名
     *
     * @param ruleAliasVoList
     * @return
     * @throws Exception
     */
    List<Long> batchAddRuleAliasService(List<RuleAliasVo> ruleAliasVoList) throws Exception;

    /**
     * 删除 规则的别名
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteRuleAliasService(String id) throws Exception;
	
    /**
     * 批量删除 规则的别名
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteRuleAliasService(String ids) throws Exception;

    /**
     * 根据条件删除 规则的别名
     *
     * @param ruleAliasDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteRuleAliasService(RuleAliasDeleteParam ruleAliasDeleteParam) throws Exception;

    /**
     * 修改 规则的别名
     *
     * @param ruleAliasVo
     * @return
     * @throws Exception
     */
    boolean updateRuleAliasService(RuleAliasVo ruleAliasVo) throws Exception;

    /**
     * 根据ID获取 规则的别名 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    RuleAliasVo getRuleAliasServiceById(Serializable id) throws Exception;

    /**
     * 获取 规则的别名 对象列表
     *
     * @param ruleAliasListParam
     * @return
     * @throws Exception
     */
    List<RuleAliasVo> getRuleAliasServiceList(RuleAliasListParam ruleAliasListParam) throws Exception;

    /**
     * 获取 规则的别名 分页对象列表
     *
     * @param ruleAliasPageParam
     * @return
     * @throws Exception
     */
    Paging<RuleAliasVo> getRuleAliasServicePageList(RuleAliasPageParam ruleAliasPageParam) throws Exception;

    /**
     * 计算 规则的别名 总记录数
     *
     * @param ruleAliasCountParam
     * @return
     * @throws Exception
     */
    Integer countRuleAliasService(RuleAliasCountParam ruleAliasCountParam) throws Exception;
	
}
