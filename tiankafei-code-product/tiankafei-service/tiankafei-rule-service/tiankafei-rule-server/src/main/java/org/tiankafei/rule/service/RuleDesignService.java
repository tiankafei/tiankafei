package org.tiankafei.rule.service;

import com.ruoyi.common.core.web.page.Paging;
import com.ruoyi.common.core.web.service.BaseService;
import java.io.Serializable;
import java.util.List;
import org.tiankafei.rule.entity.RuleDesignEntity;
import org.tiankafei.rule.param.RuleDesignCheckParam;
import org.tiankafei.rule.param.RuleDesignCountParam;
import org.tiankafei.rule.param.RuleDesignDeleteParam;
import org.tiankafei.rule.param.RuleDesignListParam;
import org.tiankafei.rule.param.RuleDesignPageParam;
import org.tiankafei.rule.vo.RuleDesignVo;

/**
 * <p>
 * 系统规则设计对象 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface RuleDesignService extends BaseService<RuleDesignEntity> {

    /**
     * 校验 系统规则设计对象 是否已经存在
     *
     * @param ruleDesignCheckParam
     * @return
     * @throws Exception
     */
    boolean checkRuleDesignServiceExists(RuleDesignCheckParam ruleDesignCheckParam) throws Exception;

    /**
     * 保存 系统规则设计对象
     *
     * @param ruleDesignVo
     * @return
     * @throws Exception
     */
    Long addRuleDesignService(RuleDesignVo ruleDesignVo) throws Exception;

    /**
     * 批量保存 系统规则设计对象
     *
     * @param ruleDesignVoList
     * @return
     * @throws Exception
     */
    List<Long> batchAddRuleDesignService(List<RuleDesignVo> ruleDesignVoList) throws Exception;

    /**
     * 删除 系统规则设计对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteRuleDesignService(String id) throws Exception;

    /**
     * 批量删除 系统规则设计对象
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteRuleDesignService(String ids) throws Exception;

    /**
     * 根据条件删除 系统规则设计对象
     *
     * @param ruleDesignDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteRuleDesignService(RuleDesignDeleteParam ruleDesignDeleteParam) throws Exception;

    /**
     * 修改 系统规则设计对象
     *
     * @param ruleDesignVo
     * @return
     * @throws Exception
     */
    boolean updateRuleDesignService(RuleDesignVo ruleDesignVo) throws Exception;

    /**
     * 根据ID获取 系统规则设计对象 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    RuleDesignVo getRuleDesignServiceById(Serializable id) throws Exception;

    /**
     * 获取 系统规则设计对象 对象列表
     *
     * @param ruleDesignListParam
     * @return
     * @throws Exception
     */
    List<RuleDesignVo> getRuleDesignServiceList(RuleDesignListParam ruleDesignListParam) throws Exception;

    /**
     * 获取 系统规则设计对象 分页对象列表
     *
     * @param ruleDesignPageParam
     * @return
     * @throws Exception
     */
    Paging<RuleDesignVo> getRuleDesignServicePageList(RuleDesignPageParam ruleDesignPageParam) throws Exception;

    /**
     * 计算 系统规则设计对象 总记录数
     *
     * @param ruleDesignCountParam
     * @return
     * @throws Exception
     */
    Integer countRuleDesignService(RuleDesignCountParam ruleDesignCountParam) throws Exception;

}
