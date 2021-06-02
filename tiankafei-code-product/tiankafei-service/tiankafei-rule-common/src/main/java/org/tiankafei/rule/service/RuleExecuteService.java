package org.tiankafei.rule.service;

import java.io.Serializable;
import java.util.List;
import org.tiankafei.rule.entity.RuleExecuteEntity;
import org.tiankafei.rule.param.RuleExecuteCheckParam;
import org.tiankafei.rule.param.RuleExecuteCountParam;
import org.tiankafei.rule.param.RuleExecuteDeleteParam;
import org.tiankafei.rule.param.RuleExecutePageParam;
import org.tiankafei.rule.param.RuleExecuteListParam;
import org.tiankafei.rule.vo.RuleExecuteVo;
import com.ruoyi.common.core.web.service.BaseService;
import com.ruoyi.common.core.web.page.Paging;

/**
 * <p>
 * 规则设计执行的对象 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface RuleExecuteService extends BaseService<RuleExecuteEntity> {

    /**
     * 校验 规则设计执行的对象 是否已经存在
     *
     * @param ruleExecuteCheckParam
     * @return
     * @throws Exception
     */
    boolean checkRuleExecuteServiceExists(RuleExecuteCheckParam ruleExecuteCheckParam) throws Exception;

    /**
     * 保存 规则设计执行的对象
     *
     * @param ruleExecuteVo
     * @return
     * @throws Exception
     */
    Long addRuleExecuteService(RuleExecuteVo ruleExecuteVo) throws Exception;

    /**
     * 批量保存 规则设计执行的对象
     *
     * @param ruleExecuteVoList
     * @return
     * @throws Exception
     */
    List<Long> batchAddRuleExecuteService(List<RuleExecuteVo> ruleExecuteVoList) throws Exception;

    /**
     * 删除 规则设计执行的对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteRuleExecuteService(String id) throws Exception;
	
    /**
     * 批量删除 规则设计执行的对象
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteRuleExecuteService(String ids) throws Exception;

    /**
     * 根据条件删除 规则设计执行的对象
     *
     * @param ruleExecuteDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteRuleExecuteService(RuleExecuteDeleteParam ruleExecuteDeleteParam) throws Exception;

    /**
     * 修改 规则设计执行的对象
     *
     * @param ruleExecuteVo
     * @return
     * @throws Exception
     */
    boolean updateRuleExecuteService(RuleExecuteVo ruleExecuteVo) throws Exception;

    /**
     * 根据ID获取 规则设计执行的对象 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    RuleExecuteVo getRuleExecuteServiceById(Serializable id) throws Exception;

    /**
     * 获取 规则设计执行的对象 对象列表
     *
     * @param ruleExecuteListParam
     * @return
     * @throws Exception
     */
    List<RuleExecuteVo> getRuleExecuteServiceList(RuleExecuteListParam ruleExecuteListParam) throws Exception;

    /**
     * 获取 规则设计执行的对象 分页对象列表
     *
     * @param ruleExecutePageParam
     * @return
     * @throws Exception
     */
    Paging<RuleExecuteVo> getRuleExecuteServicePageList(RuleExecutePageParam ruleExecutePageParam) throws Exception;

    /**
     * 计算 规则设计执行的对象 总记录数
     *
     * @param ruleExecuteCountParam
     * @return
     * @throws Exception
     */
    Integer countRuleExecuteService(RuleExecuteCountParam ruleExecuteCountParam) throws Exception;
	
}
