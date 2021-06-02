package org.tiankafei.rule.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.rule.entity.RuleDatasetAliasEntity;
import org.tiankafei.rule.param.RuleDatasetAliasCheckParam;
import org.tiankafei.rule.param.RuleDatasetAliasCountParam;
import org.tiankafei.rule.param.RuleDatasetAliasDeleteParam;
import org.tiankafei.rule.param.RuleDatasetAliasListParam;
import org.tiankafei.rule.param.RuleDatasetAliasPageParam;
import org.tiankafei.rule.vo.RuleDatasetAliasVo;

/**
 * <p>
 * 规则数据集的别名 Mapper 接口
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface RuleDatasetAliasMapper extends BaseMapper<RuleDatasetAliasEntity> {

    /**
     * 校验 规则数据集的别名 是否已经存在
     *
     * @param ruleDatasetAliasCheckParam
     * @return
     * @throws Exception
     */
    boolean checkRuleDatasetAliasServiceExists(@Param("param") RuleDatasetAliasCheckParam ruleDatasetAliasCheckParam) throws Exception;

    /**
     * 保存 规则数据集的别名
     *
     * @param ruleDatasetAliasVo
     * @return
     * @throws Exception
     */
    Object addRuleDatasetAliasService(@Param("param") RuleDatasetAliasVo ruleDatasetAliasVo) throws Exception;

    /**
     * 批量保存 规则数据集的别名
     *
     * @param ruleDatasetAliasVoList
     * @return
     * @throws Exception
     */
    List<Object> batchAddRuleDatasetAliasService(@Param("param") List<RuleDatasetAliasVo> ruleDatasetAliasVoList) throws Exception;

    /**
     * 删除 规则数据集的别名
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteRuleDatasetAliasService(@Param("param") String id) throws Exception;

    /**
     * 批量删除 规则数据集的别名
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteRuleDatasetAliasService(@Param("param") String ids) throws Exception;

    /**
     * 根据条件删除 规则数据集的别名
     *
     * @param ruleDatasetAliasDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteRuleDatasetAliasService(@Param("param") RuleDatasetAliasDeleteParam ruleDatasetAliasDeleteParam) throws Exception;

    /**
     * 修改 规则数据集的别名
     *
     * @param ruleDatasetAliasVo
     * @return
     * @throws Exception
     */
    boolean updateRuleDatasetAliasService(@Param("param") RuleDatasetAliasVo ruleDatasetAliasVo) throws Exception;

    /**
     * 根据ID获取 规则数据集的别名 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    RuleDatasetAliasVo getRuleDatasetAliasServiceById(@Param("param") Serializable id) throws Exception;

    /**
     * 获取 规则数据集的别名 对象列表
     *
     * @param ruleDatasetAliasListParam
     * @return
     * @throws Exception
     */
    List<RuleDatasetAliasVo> getRuleDatasetAliasServiceList(@Param("param") RuleDatasetAliasListParam ruleDatasetAliasListParam) throws Exception;

    /**
     * 获取 规则数据集的别名 分页对象列表
     *
     * @param page
     * @param ruleDatasetAliasPageParam
     * @return
     * @throws Exception
     */
    IPage<RuleDatasetAliasVo> getRuleDatasetAliasServicePageList(@Param("page") Page page, @Param("param") RuleDatasetAliasPageParam ruleDatasetAliasPageParam) throws Exception;

    /**
     * 计算 规则数据集的别名 总记录数
     *
     * @param ruleDatasetAliasCountParam
     * @return
     * @throws Exception
     */
    Integer countRuleDatasetAliasService(@Param("param") RuleDatasetAliasCountParam ruleDatasetAliasCountParam) throws Exception;

}
