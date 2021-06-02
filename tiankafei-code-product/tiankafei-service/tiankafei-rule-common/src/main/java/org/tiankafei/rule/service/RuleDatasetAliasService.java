package org.tiankafei.rule.service;

import com.ruoyi.common.core.web.page.Paging;
import com.ruoyi.common.core.web.service.BaseService;
import java.io.Serializable;
import java.util.List;
import org.tiankafei.rule.entity.RuleDatasetAliasEntity;
import org.tiankafei.rule.param.RuleDatasetAliasCheckParam;
import org.tiankafei.rule.param.RuleDatasetAliasCountParam;
import org.tiankafei.rule.param.RuleDatasetAliasDeleteParam;
import org.tiankafei.rule.param.RuleDatasetAliasListParam;
import org.tiankafei.rule.param.RuleDatasetAliasPageParam;
import org.tiankafei.rule.vo.RuleDatasetAliasVo;

/**
 * <p>
 * 规则数据集的别名 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface RuleDatasetAliasService extends BaseService<RuleDatasetAliasEntity> {

    /**
     * 校验 规则数据集的别名 是否已经存在
     *
     * @param ruleDatasetAliasCheckParam
     * @return
     * @throws Exception
     */
    boolean checkRuleDatasetAliasServiceExists(RuleDatasetAliasCheckParam ruleDatasetAliasCheckParam) throws Exception;

    /**
     * 保存 规则数据集的别名
     *
     * @param ruleDatasetAliasVo
     * @return
     * @throws Exception
     */
    Long addRuleDatasetAliasService(RuleDatasetAliasVo ruleDatasetAliasVo) throws Exception;

    /**
     * 批量保存 规则数据集的别名
     *
     * @param ruleDatasetAliasVoList
     * @return
     * @throws Exception
     */
    List<Long> batchAddRuleDatasetAliasService(List<RuleDatasetAliasVo> ruleDatasetAliasVoList) throws Exception;

    /**
     * 删除 规则数据集的别名
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteRuleDatasetAliasService(String id) throws Exception;

    /**
     * 批量删除 规则数据集的别名
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteRuleDatasetAliasService(String ids) throws Exception;

    /**
     * 根据条件删除 规则数据集的别名
     *
     * @param ruleDatasetAliasDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteRuleDatasetAliasService(RuleDatasetAliasDeleteParam ruleDatasetAliasDeleteParam) throws Exception;

    /**
     * 修改 规则数据集的别名
     *
     * @param ruleDatasetAliasVo
     * @return
     * @throws Exception
     */
    boolean updateRuleDatasetAliasService(RuleDatasetAliasVo ruleDatasetAliasVo) throws Exception;

    /**
     * 根据ID获取 规则数据集的别名 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    RuleDatasetAliasVo getRuleDatasetAliasServiceById(Serializable id) throws Exception;

    /**
     * 获取 规则数据集的别名 对象列表
     *
     * @param ruleDatasetAliasListParam
     * @return
     * @throws Exception
     */
    List<RuleDatasetAliasVo> getRuleDatasetAliasServiceList(RuleDatasetAliasListParam ruleDatasetAliasListParam) throws Exception;

    /**
     * 获取 规则数据集的别名 分页对象列表
     *
     * @param ruleDatasetAliasPageParam
     * @return
     * @throws Exception
     */
    Paging<RuleDatasetAliasVo> getRuleDatasetAliasServicePageList(RuleDatasetAliasPageParam ruleDatasetAliasPageParam) throws Exception;

    /**
     * 计算 规则数据集的别名 总记录数
     *
     * @param ruleDatasetAliasCountParam
     * @return
     * @throws Exception
     */
    Integer countRuleDatasetAliasService(RuleDatasetAliasCountParam ruleDatasetAliasCountParam) throws Exception;

}
