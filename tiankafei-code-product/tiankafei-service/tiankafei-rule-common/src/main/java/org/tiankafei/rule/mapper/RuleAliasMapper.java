package org.tiankafei.rule.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.rule.entity.RuleAliasEntity;
import org.tiankafei.rule.param.RuleAliasCheckParam;
import org.tiankafei.rule.param.RuleAliasCountParam;
import org.tiankafei.rule.param.RuleAliasDeleteParam;
import org.tiankafei.rule.param.RuleAliasListParam;
import org.tiankafei.rule.param.RuleAliasPageParam;
import org.tiankafei.rule.vo.RuleAliasVo;

/**
 * <p>
 * 规则的别名 Mapper 接口
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface RuleAliasMapper extends BaseMapper<RuleAliasEntity> {

    /**
     * 校验 规则的别名 是否已经存在
     *
     * @param ruleAliasCheckParam
     * @return
     * @throws Exception
     */
    boolean checkRuleAliasServiceExists(@Param("param") RuleAliasCheckParam ruleAliasCheckParam) throws Exception;

    /**
     * 保存 规则的别名
     *
     * @param ruleAliasVo
     * @return
     * @throws Exception
     */
    Object addRuleAliasService(@Param("param") RuleAliasVo ruleAliasVo) throws Exception;

    /**
     * 批量保存 规则的别名
     *
     * @param ruleAliasVoList
     * @return
     * @throws Exception
     */
    List<Object> batchAddRuleAliasService(@Param("param") List<RuleAliasVo> ruleAliasVoList) throws Exception;

    /**
     * 删除 规则的别名
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteRuleAliasService(@Param("param") String id) throws Exception;

    /**
     * 批量删除 规则的别名
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteRuleAliasService(@Param("param") String ids) throws Exception;

    /**
     * 根据条件删除 规则的别名
     *
     * @param ruleAliasDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteRuleAliasService(@Param("param") RuleAliasDeleteParam ruleAliasDeleteParam) throws Exception;

    /**
     * 修改 规则的别名
     *
     * @param ruleAliasVo
     * @return
     * @throws Exception
     */
    boolean updateRuleAliasService(@Param("param") RuleAliasVo ruleAliasVo) throws Exception;

    /**
     * 根据ID获取 规则的别名 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    RuleAliasVo getRuleAliasServiceById(@Param("param") Serializable id) throws Exception;

    /**
     * 获取 规则的别名 对象列表
     *
     * @param ruleAliasListParam
     * @return
     * @throws Exception
     */
    List<RuleAliasVo> getRuleAliasServiceList(@Param("param") RuleAliasListParam ruleAliasListParam) throws Exception;

    /**
     * 获取 规则的别名 分页对象列表
     *
     * @param page
     * @param ruleAliasPageParam
     * @return
     * @throws Exception
     */
    IPage<RuleAliasVo> getRuleAliasServicePageList(@Param("page") Page page, @Param("param") RuleAliasPageParam ruleAliasPageParam) throws Exception;

    /**
     * 计算 规则的别名 总记录数
     *
     * @param ruleAliasCountParam
     * @return
     * @throws Exception
     */
    Integer countRuleAliasService(@Param("param") RuleAliasCountParam ruleAliasCountParam) throws Exception;

}
