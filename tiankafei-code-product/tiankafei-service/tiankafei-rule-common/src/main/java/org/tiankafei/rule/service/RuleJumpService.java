package org.tiankafei.rule.service;

import com.ruoyi.common.core.web.page.Paging;
import com.ruoyi.common.core.web.service.BaseService;
import java.io.Serializable;
import java.util.List;
import org.tiankafei.rule.entity.RuleJumpEntity;
import org.tiankafei.rule.param.RuleJumpCheckParam;
import org.tiankafei.rule.param.RuleJumpCountParam;
import org.tiankafei.rule.param.RuleJumpDeleteParam;
import org.tiankafei.rule.param.RuleJumpListParam;
import org.tiankafei.rule.param.RuleJumpPageParam;
import org.tiankafei.rule.vo.RuleJumpVo;

/**
 * <p>
 * 跳转规则记录的数据唯一标识 服务类
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface RuleJumpService extends BaseService<RuleJumpEntity> {

    /**
     * 校验 跳转规则记录的数据唯一标识 是否已经存在
     *
     * @param ruleJumpCheckParam
     * @return
     * @throws Exception
     */
    boolean checkRuleJumpServiceExists(RuleJumpCheckParam ruleJumpCheckParam) throws Exception;

    /**
     * 保存 跳转规则记录的数据唯一标识
     *
     * @param ruleJumpVo
     * @return
     * @throws Exception
     */
    Long addRuleJumpService(RuleJumpVo ruleJumpVo) throws Exception;

    /**
     * 批量保存 跳转规则记录的数据唯一标识
     *
     * @param ruleJumpVoList
     * @return
     * @throws Exception
     */
    List<Long> batchAddRuleJumpService(List<RuleJumpVo> ruleJumpVoList) throws Exception;

    /**
     * 删除 跳转规则记录的数据唯一标识
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteRuleJumpService(String id) throws Exception;

    /**
     * 批量删除 跳转规则记录的数据唯一标识
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteRuleJumpService(String ids) throws Exception;

    /**
     * 根据条件删除 跳转规则记录的数据唯一标识
     *
     * @param ruleJumpDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteRuleJumpService(RuleJumpDeleteParam ruleJumpDeleteParam) throws Exception;

    /**
     * 修改 跳转规则记录的数据唯一标识
     *
     * @param ruleJumpVo
     * @return
     * @throws Exception
     */
    boolean updateRuleJumpService(RuleJumpVo ruleJumpVo) throws Exception;

    /**
     * 根据ID获取 跳转规则记录的数据唯一标识 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    RuleJumpVo getRuleJumpServiceById(Serializable id) throws Exception;

    /**
     * 获取 跳转规则记录的数据唯一标识 对象列表
     *
     * @param ruleJumpListParam
     * @return
     * @throws Exception
     */
    List<RuleJumpVo> getRuleJumpServiceList(RuleJumpListParam ruleJumpListParam) throws Exception;

    /**
     * 获取 跳转规则记录的数据唯一标识 分页对象列表
     *
     * @param ruleJumpPageParam
     * @return
     * @throws Exception
     */
    Paging<RuleJumpVo> getRuleJumpServicePageList(RuleJumpPageParam ruleJumpPageParam) throws Exception;

    /**
     * 计算 跳转规则记录的数据唯一标识 总记录数
     *
     * @param ruleJumpCountParam
     * @return
     * @throws Exception
     */
    Integer countRuleJumpService(RuleJumpCountParam ruleJumpCountParam) throws Exception;

}
