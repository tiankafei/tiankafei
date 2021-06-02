package org.tiankafei.rule.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.rule.entity.RuleDataAliasEntity;
import org.tiankafei.rule.param.RuleDataAliasCheckParam;
import org.tiankafei.rule.param.RuleDataAliasCountParam;
import org.tiankafei.rule.param.RuleDataAliasDeleteParam;
import org.tiankafei.rule.param.RuleDataAliasListParam;
import org.tiankafei.rule.param.RuleDataAliasPageParam;
import org.tiankafei.rule.vo.RuleDataAliasVo;

/**
 * <p>
 * 规则中用到的数据的别名 Mapper 接口
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface RuleDataAliasMapper extends BaseMapper<RuleDataAliasEntity> {

    /**
     * 校验 规则中用到的数据的别名 是否已经存在
     *
     * @param ruleDataAliasCheckParam
     * @return
     * @throws Exception
     */
    boolean checkRuleDataAliasServiceExists(@Param("param") RuleDataAliasCheckParam ruleDataAliasCheckParam) throws Exception;

    /**
     * 保存 规则中用到的数据的别名
     *
     * @param ruleDataAliasVo
     * @return
     * @throws Exception
     */
    Object addRuleDataAliasService(@Param("param") RuleDataAliasVo ruleDataAliasVo) throws Exception;

    /**
     * 批量保存 规则中用到的数据的别名
     *
     * @param ruleDataAliasVoList
     * @return
     * @throws Exception
     */
    List<Object> batchAddRuleDataAliasService(@Param("param") List<RuleDataAliasVo> ruleDataAliasVoList) throws Exception;

    /**
     * 删除 规则中用到的数据的别名
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteRuleDataAliasService(@Param("param") String id) throws Exception;

    /**
     * 批量删除 规则中用到的数据的别名
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteRuleDataAliasService(@Param("param") String ids) throws Exception;

    /**
     * 根据条件删除 规则中用到的数据的别名
     *
     * @param ruleDataAliasDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteRuleDataAliasService(@Param("param") RuleDataAliasDeleteParam ruleDataAliasDeleteParam) throws Exception;

    /**
     * 修改 规则中用到的数据的别名
     *
     * @param ruleDataAliasVo
     * @return
     * @throws Exception
     */
    boolean updateRuleDataAliasService(@Param("param") RuleDataAliasVo ruleDataAliasVo) throws Exception;

    /**
     * 根据ID获取 规则中用到的数据的别名 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    RuleDataAliasVo getRuleDataAliasServiceById(@Param("param") Serializable id) throws Exception;

    /**
     * 获取 规则中用到的数据的别名 对象列表
     *
     * @param ruleDataAliasListParam
     * @return
     * @throws Exception
     */
    List<RuleDataAliasVo> getRuleDataAliasServiceList(@Param("param") RuleDataAliasListParam ruleDataAliasListParam) throws Exception;

    /**
     * 获取 规则中用到的数据的别名 分页对象列表
     *
     * @param page
     * @param ruleDataAliasPageParam
     * @return
     * @throws Exception
     */
    IPage<RuleDataAliasVo> getRuleDataAliasServicePageList(@Param("page") Page page, @Param("param") RuleDataAliasPageParam ruleDataAliasPageParam) throws Exception;

    /**
     * 计算 规则中用到的数据的别名 总记录数
     *
     * @param ruleDataAliasCountParam
     * @return
     * @throws Exception
     */
    Integer countRuleDataAliasService(@Param("param") RuleDataAliasCountParam ruleDataAliasCountParam) throws Exception;

}
