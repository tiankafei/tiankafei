package org.tiankafei.rule.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.rule.entity.RuleJumpEntity;
import org.tiankafei.rule.param.RuleJumpCheckParam;
import org.tiankafei.rule.param.RuleJumpCountParam;
import org.tiankafei.rule.param.RuleJumpDeleteParam;
import org.tiankafei.rule.param.RuleJumpPageParam;
import org.tiankafei.rule.param.RuleJumpListParam;
import org.tiankafei.rule.vo.RuleJumpVo;

/**
 * <p>
 * 跳转规则记录的数据唯一标识 Mapper 接口
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface RuleJumpMapper extends BaseMapper<RuleJumpEntity> {

    /**
     * 校验 跳转规则记录的数据唯一标识 是否已经存在
     *
     * @param ruleJumpCheckParam
     * @return
     * @throws Exception
     */
    boolean checkRuleJumpServiceExists(@Param("param") RuleJumpCheckParam ruleJumpCheckParam) throws Exception;

    /**
     * 保存 跳转规则记录的数据唯一标识
     *
     * @param ruleJumpVo
     * @return
     * @throws Exception
     */
    Object addRuleJumpService(@Param("param") RuleJumpVo ruleJumpVo) throws Exception;

    /**
     * 批量保存 跳转规则记录的数据唯一标识
     *
     * @param ruleJumpVoList
     * @return
     * @throws Exception
     */
    List<Object> batchAddRuleJumpService(@Param("param") List<RuleJumpVo> ruleJumpVoList) throws Exception;

    /**
     * 删除 跳转规则记录的数据唯一标识
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteRuleJumpService(@Param("param") String id) throws Exception;
	
    /**
     * 批量删除 跳转规则记录的数据唯一标识
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteRuleJumpService(@Param("param") String ids) throws Exception;

    /**
     * 根据条件删除 跳转规则记录的数据唯一标识
     *
     * @param ruleJumpDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteRuleJumpService(@Param("param") RuleJumpDeleteParam ruleJumpDeleteParam) throws Exception;

    /**
     * 修改 跳转规则记录的数据唯一标识
     *
     * @param ruleJumpVo
     * @return
     * @throws Exception
     */
    boolean updateRuleJumpService(@Param("param") RuleJumpVo ruleJumpVo) throws Exception;

    /**
     * 根据ID获取 跳转规则记录的数据唯一标识 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    RuleJumpVo getRuleJumpServiceById(@Param("param") Serializable id) throws Exception;

    /**
     * 获取 跳转规则记录的数据唯一标识 对象列表
     *
     * @param ruleJumpListParam
     * @return
     * @throws Exception
     */
    List<RuleJumpVo> getRuleJumpServiceList(@Param("param") RuleJumpListParam ruleJumpListParam) throws Exception;

    /**
     * 获取 跳转规则记录的数据唯一标识 分页对象列表
     *
     * @param page
     * @param ruleJumpPageParam
     * @return
     * @throws Exception
     */
    IPage<RuleJumpVo> getRuleJumpServicePageList(@Param("page") Page page, @Param("param") RuleJumpPageParam ruleJumpPageParam) throws Exception;

    /**
     * 计算 跳转规则记录的数据唯一标识 总记录数
     *
     * @param ruleJumpCountParam
     * @return
     * @throws Exception
     */
    Integer countRuleJumpService(@Param("param") RuleJumpCountParam ruleJumpCountParam) throws Exception;

}
