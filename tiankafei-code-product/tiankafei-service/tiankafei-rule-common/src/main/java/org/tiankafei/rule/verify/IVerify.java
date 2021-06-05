package org.tiankafei.rule.verify;

import java.util.List;
import org.tiankafei.rule.entity.RuleExecuteEntity;
import org.tiankafei.rule.verify.model.VerifyResultModel;

/**
 * 审核接口
 *
 * @author tiankafei
 */
public interface IVerify {

    /**
     * 执行审核
     *
     * @param ruleDesignDtoList
     * @param query
     * @return
     */
    List<VerifyResultModel> executeVerify(List<RuleExecuteEntity> ruleDesignDtoList, IQuery query);

}
