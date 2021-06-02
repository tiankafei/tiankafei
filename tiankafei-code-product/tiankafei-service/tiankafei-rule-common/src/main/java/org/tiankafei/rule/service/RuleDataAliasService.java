package org.tiankafei.rule.service;

import com.ruoyi.common.core.web.page.Paging;
import com.ruoyi.common.core.web.service.BaseService;
import java.io.Serializable;
import java.util.List;
import org.tiankafei.rule.entity.RuleDataAliasEntity;
import org.tiankafei.rule.param.RuleDataAliasCheckParam;
import org.tiankafei.rule.param.RuleDataAliasCountParam;
import org.tiankafei.rule.param.RuleDataAliasDeleteParam;
import org.tiankafei.rule.param.RuleDataAliasListParam;
import org.tiankafei.rule.param.RuleDataAliasPageParam;
import org.tiankafei.rule.vo.RuleDataAliasVo;

/**
 * <p>
 * 规则中用到的数据的别名 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface RuleDataAliasService extends BaseService<RuleDataAliasEntity> {

    /**
     * 校验 规则中用到的数据的别名 是否已经存在
     *
     * @param ruleDataAliasCheckParam
     * @return
     * @throws Exception
     */
    boolean checkRuleDataAliasServiceExists(RuleDataAliasCheckParam ruleDataAliasCheckParam) throws Exception;

    /**
     * 保存 规则中用到的数据的别名
     *
     * @param ruleDataAliasVo
     * @return
     * @throws Exception
     */
    Long addRuleDataAliasService(RuleDataAliasVo ruleDataAliasVo) throws Exception;

    /**
     * 批量保存 规则中用到的数据的别名
     *
     * @param ruleDataAliasVoList
     * @return
     * @throws Exception
     */
    List<Long> batchAddRuleDataAliasService(List<RuleDataAliasVo> ruleDataAliasVoList) throws Exception;

    /**
     * 删除 规则中用到的数据的别名
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteRuleDataAliasService(String id) throws Exception;

    /**
     * 批量删除 规则中用到的数据的别名
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteRuleDataAliasService(String ids) throws Exception;

    /**
     * 根据条件删除 规则中用到的数据的别名
     *
     * @param ruleDataAliasDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteRuleDataAliasService(RuleDataAliasDeleteParam ruleDataAliasDeleteParam) throws Exception;

    /**
     * 修改 规则中用到的数据的别名
     *
     * @param ruleDataAliasVo
     * @return
     * @throws Exception
     */
    boolean updateRuleDataAliasService(RuleDataAliasVo ruleDataAliasVo) throws Exception;

    /**
     * 根据ID获取 规则中用到的数据的别名 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    RuleDataAliasVo getRuleDataAliasServiceById(Serializable id) throws Exception;

    /**
     * 获取 规则中用到的数据的别名 对象列表
     *
     * @param ruleDataAliasListParam
     * @return
     * @throws Exception
     */
    List<RuleDataAliasVo> getRuleDataAliasServiceList(RuleDataAliasListParam ruleDataAliasListParam) throws Exception;

    /**
     * 获取 规则中用到的数据的别名 分页对象列表
     *
     * @param ruleDataAliasPageParam
     * @return
     * @throws Exception
     */
    Paging<RuleDataAliasVo> getRuleDataAliasServicePageList(RuleDataAliasPageParam ruleDataAliasPageParam) throws Exception;

    /**
     * 计算 规则中用到的数据的别名 总记录数
     *
     * @param ruleDataAliasCountParam
     * @return
     * @throws Exception
     */
    Integer countRuleDataAliasService(RuleDataAliasCountParam ruleDataAliasCountParam) throws Exception;

}
