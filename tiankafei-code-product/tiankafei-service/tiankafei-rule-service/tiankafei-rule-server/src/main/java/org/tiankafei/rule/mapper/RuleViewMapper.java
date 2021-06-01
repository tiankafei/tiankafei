package org.tiankafei.rule.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.rule.entity.RuleViewEntity;
import org.tiankafei.rule.param.RuleViewCheckParam;
import org.tiankafei.rule.param.RuleViewCountParam;
import org.tiankafei.rule.param.RuleViewDeleteParam;
import org.tiankafei.rule.param.RuleViewListParam;
import org.tiankafei.rule.param.RuleViewPageParam;
import org.tiankafei.rule.vo.RuleViewVo;

/**
 * <p>
 * 系统规则设计表达式显示对象 Mapper 接口
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface RuleViewMapper extends BaseMapper<RuleViewEntity> {

    /**
     * 校验 系统规则设计表达式显示对象 是否已经存在
     *
     * @param ruleViewCheckParam
     * @return
     * @throws Exception
     */
    boolean checkRuleViewServiceExists(@Param("param") RuleViewCheckParam ruleViewCheckParam) throws Exception;

    /**
     * 保存 系统规则设计表达式显示对象
     *
     * @param ruleViewVo
     * @return
     * @throws Exception
     */
    Object addRuleViewService(@Param("param") RuleViewVo ruleViewVo) throws Exception;

    /**
     * 批量保存 系统规则设计表达式显示对象
     *
     * @param ruleViewVoList
     * @return
     * @throws Exception
     */
    List<Object> batchAddRuleViewService(@Param("param") List<RuleViewVo> ruleViewVoList) throws Exception;

    /**
     * 删除 系统规则设计表达式显示对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteRuleViewService(@Param("param") String id) throws Exception;

    /**
     * 批量删除 系统规则设计表达式显示对象
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteRuleViewService(@Param("param") String ids) throws Exception;

    /**
     * 根据条件删除 系统规则设计表达式显示对象
     *
     * @param ruleViewDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteRuleViewService(@Param("param") RuleViewDeleteParam ruleViewDeleteParam) throws Exception;

    /**
     * 修改 系统规则设计表达式显示对象
     *
     * @param ruleViewVo
     * @return
     * @throws Exception
     */
    boolean updateRuleViewService(@Param("param") RuleViewVo ruleViewVo) throws Exception;

    /**
     * 根据ID获取 系统规则设计表达式显示对象 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    RuleViewVo getRuleViewServiceById(@Param("param") Serializable id) throws Exception;

    /**
     * 获取 系统规则设计表达式显示对象 对象列表
     *
     * @param ruleViewListParam
     * @return
     * @throws Exception
     */
    List<RuleViewVo> getRuleViewServiceList(@Param("param") RuleViewListParam ruleViewListParam) throws Exception;

    /**
     * 获取 系统规则设计表达式显示对象 分页对象列表
     *
     * @param page
     * @param ruleViewPageParam
     * @return
     * @throws Exception
     */
    IPage<RuleViewVo> getRuleViewServicePageList(@Param("page") Page page, @Param("param") RuleViewPageParam ruleViewPageParam) throws Exception;

    /**
     * 计算 系统规则设计表达式显示对象 总记录数
     *
     * @param ruleViewCountParam
     * @return
     * @throws Exception
     */
    Integer countRuleViewService(@Param("param") RuleViewCountParam ruleViewCountParam) throws Exception;

}
