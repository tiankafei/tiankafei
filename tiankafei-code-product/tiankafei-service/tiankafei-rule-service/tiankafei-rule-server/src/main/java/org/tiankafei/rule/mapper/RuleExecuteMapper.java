package org.tiankafei.rule.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.rule.entity.RuleExecuteEntity;
import org.tiankafei.rule.param.RuleExecuteCheckParam;
import org.tiankafei.rule.param.RuleExecuteCountParam;
import org.tiankafei.rule.param.RuleExecuteDeleteParam;
import org.tiankafei.rule.param.RuleExecuteListParam;
import org.tiankafei.rule.param.RuleExecutePageParam;
import org.tiankafei.rule.vo.RuleExecuteVo;

/**
 * <p>
 * 系统规则设计执行的对象 Mapper 接口
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface RuleExecuteMapper extends BaseMapper<RuleExecuteEntity> {

    /**
     * 校验 系统规则设计执行的对象 是否已经存在
     *
     * @param ruleExecuteCheckParam
     * @return
     * @throws Exception
     */
    boolean checkRuleExecuteServiceExists(@Param("param") RuleExecuteCheckParam ruleExecuteCheckParam) throws Exception;

    /**
     * 保存 系统规则设计执行的对象
     *
     * @param ruleExecuteVo
     * @return
     * @throws Exception
     */
    Object addRuleExecuteService(@Param("param") RuleExecuteVo ruleExecuteVo) throws Exception;

    /**
     * 批量保存 系统规则设计执行的对象
     *
     * @param ruleExecuteVoList
     * @return
     * @throws Exception
     */
    List<Object> batchAddRuleExecuteService(@Param("param") List<RuleExecuteVo> ruleExecuteVoList) throws Exception;

    /**
     * 删除 系统规则设计执行的对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteRuleExecuteService(@Param("param") String id) throws Exception;

    /**
     * 批量删除 系统规则设计执行的对象
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteRuleExecuteService(@Param("param") String ids) throws Exception;

    /**
     * 根据条件删除 系统规则设计执行的对象
     *
     * @param ruleExecuteDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteRuleExecuteService(@Param("param") RuleExecuteDeleteParam ruleExecuteDeleteParam) throws Exception;

    /**
     * 修改 系统规则设计执行的对象
     *
     * @param ruleExecuteVo
     * @return
     * @throws Exception
     */
    boolean updateRuleExecuteService(@Param("param") RuleExecuteVo ruleExecuteVo) throws Exception;

    /**
     * 根据ID获取 系统规则设计执行的对象 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    RuleExecuteVo getRuleExecuteServiceById(@Param("param") Serializable id) throws Exception;

    /**
     * 获取 系统规则设计执行的对象 对象列表
     *
     * @param ruleExecuteListParam
     * @return
     * @throws Exception
     */
    List<RuleExecuteVo> getRuleExecuteServiceList(@Param("param") RuleExecuteListParam ruleExecuteListParam) throws Exception;

    /**
     * 获取 系统规则设计执行的对象 分页对象列表
     *
     * @param page
     * @param ruleExecutePageParam
     * @return
     * @throws Exception
     */
    IPage<RuleExecuteVo> getRuleExecuteServicePageList(@Param("page") Page page, @Param("param") RuleExecutePageParam ruleExecutePageParam) throws Exception;

    /**
     * 计算 系统规则设计执行的对象 总记录数
     *
     * @param ruleExecuteCountParam
     * @return
     * @throws Exception
     */
    Integer countRuleExecuteService(@Param("param") RuleExecuteCountParam ruleExecuteCountParam) throws Exception;

}
