package org.tiankafei.rule.service;

import com.ruoyi.common.core.web.page.Paging;
import com.ruoyi.common.core.web.service.BaseService;
import java.io.Serializable;
import java.util.List;
import org.tiankafei.rule.entity.RuleViewEntity;
import org.tiankafei.rule.param.RuleViewCheckParam;
import org.tiankafei.rule.param.RuleViewCountParam;
import org.tiankafei.rule.param.RuleViewDeleteParam;
import org.tiankafei.rule.param.RuleViewListParam;
import org.tiankafei.rule.param.RuleViewPageParam;
import org.tiankafei.rule.vo.RuleViewVo;

/**
 * <p>
 * 系统规则设计表达式显示对象 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface RuleViewService extends BaseService<RuleViewEntity> {

    /**
     * 校验 系统规则设计表达式显示对象 是否已经存在
     *
     * @param ruleViewCheckParam
     * @return
     * @throws Exception
     */
    boolean checkRuleViewServiceExists(RuleViewCheckParam ruleViewCheckParam) throws Exception;

    /**
     * 保存 系统规则设计表达式显示对象
     *
     * @param ruleViewVo
     * @return
     * @throws Exception
     */
    Long addRuleViewService(RuleViewVo ruleViewVo) throws Exception;

    /**
     * 批量保存 系统规则设计表达式显示对象
     *
     * @param ruleViewVoList
     * @return
     * @throws Exception
     */
    List<Long> batchAddRuleViewService(List<RuleViewVo> ruleViewVoList) throws Exception;

    /**
     * 删除 系统规则设计表达式显示对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteRuleViewService(String id) throws Exception;

    /**
     * 批量删除 系统规则设计表达式显示对象
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteRuleViewService(String ids) throws Exception;

    /**
     * 根据条件删除 系统规则设计表达式显示对象
     *
     * @param ruleViewDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteRuleViewService(RuleViewDeleteParam ruleViewDeleteParam) throws Exception;

    /**
     * 修改 系统规则设计表达式显示对象
     *
     * @param ruleViewVo
     * @return
     * @throws Exception
     */
    boolean updateRuleViewService(RuleViewVo ruleViewVo) throws Exception;

    /**
     * 根据ID获取 系统规则设计表达式显示对象 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    RuleViewVo getRuleViewServiceById(Serializable id) throws Exception;

    /**
     * 获取 系统规则设计表达式显示对象 对象列表
     *
     * @param ruleViewListParam
     * @return
     * @throws Exception
     */
    List<RuleViewVo> getRuleViewServiceList(RuleViewListParam ruleViewListParam) throws Exception;

    /**
     * 获取 系统规则设计表达式显示对象 分页对象列表
     *
     * @param ruleViewPageParam
     * @return
     * @throws Exception
     */
    Paging<RuleViewVo> getRuleViewServicePageList(RuleViewPageParam ruleViewPageParam) throws Exception;

    /**
     * 计算 系统规则设计表达式显示对象 总记录数
     *
     * @param ruleViewCountParam
     * @return
     * @throws Exception
     */
    Integer countRuleViewService(RuleViewCountParam ruleViewCountParam) throws Exception;

}
