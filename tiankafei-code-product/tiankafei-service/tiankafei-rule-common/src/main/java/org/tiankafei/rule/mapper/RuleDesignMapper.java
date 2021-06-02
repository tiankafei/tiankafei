package org.tiankafei.rule.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.rule.entity.RuleDesignEntity;
import org.tiankafei.rule.param.RuleDesignCheckParam;
import org.tiankafei.rule.param.RuleDesignCountParam;
import org.tiankafei.rule.param.RuleDesignDeleteParam;
import org.tiankafei.rule.param.RuleDesignListParam;
import org.tiankafei.rule.param.RuleDesignPageParam;
import org.tiankafei.rule.vo.RuleDesignVo;

/**
 * <p>
 * 规则设计表达式用户新增的对象 Mapper 接口
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface RuleDesignMapper extends BaseMapper<RuleDesignEntity> {

    /**
     * 校验 规则设计表达式用户新增的对象 是否已经存在
     *
     * @param ruleDesignCheckParam
     * @return
     * @throws Exception
     */
    boolean checkRuleDesignServiceExists(@Param("param") RuleDesignCheckParam ruleDesignCheckParam) throws Exception;

    /**
     * 保存 规则设计表达式用户新增的对象
     *
     * @param ruleDesignVo
     * @return
     * @throws Exception
     */
    Object addRuleDesignService(@Param("param") RuleDesignVo ruleDesignVo) throws Exception;

    /**
     * 批量保存 规则设计表达式用户新增的对象
     *
     * @param ruleDesignVoList
     * @return
     * @throws Exception
     */
    List<Object> batchAddRuleDesignService(@Param("param") List<RuleDesignVo> ruleDesignVoList) throws Exception;

    /**
     * 删除 规则设计表达式用户新增的对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteRuleDesignService(@Param("param") String id) throws Exception;

    /**
     * 批量删除 规则设计表达式用户新增的对象
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteRuleDesignService(@Param("param") String ids) throws Exception;

    /**
     * 根据条件删除 规则设计表达式用户新增的对象
     *
     * @param ruleDesignDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteRuleDesignService(@Param("param") RuleDesignDeleteParam ruleDesignDeleteParam) throws Exception;

    /**
     * 修改 规则设计表达式用户新增的对象
     *
     * @param ruleDesignVo
     * @return
     * @throws Exception
     */
    boolean updateRuleDesignService(@Param("param") RuleDesignVo ruleDesignVo) throws Exception;

    /**
     * 根据ID获取 规则设计表达式用户新增的对象 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    RuleDesignVo getRuleDesignServiceById(@Param("param") Serializable id) throws Exception;

    /**
     * 获取 规则设计表达式用户新增的对象 对象列表
     *
     * @param ruleDesignListParam
     * @return
     * @throws Exception
     */
    List<RuleDesignVo> getRuleDesignServiceList(@Param("param") RuleDesignListParam ruleDesignListParam) throws Exception;

    /**
     * 获取 规则设计表达式用户新增的对象 分页对象列表
     *
     * @param page
     * @param ruleDesignPageParam
     * @return
     * @throws Exception
     */
    IPage<RuleDesignVo> getRuleDesignServicePageList(@Param("page") Page page, @Param("param") RuleDesignPageParam ruleDesignPageParam) throws Exception;

    /**
     * 计算 规则设计表达式用户新增的对象 总记录数
     *
     * @param ruleDesignCountParam
     * @return
     * @throws Exception
     */
    Integer countRuleDesignService(@Param("param") RuleDesignCountParam ruleDesignCountParam) throws Exception;

}
