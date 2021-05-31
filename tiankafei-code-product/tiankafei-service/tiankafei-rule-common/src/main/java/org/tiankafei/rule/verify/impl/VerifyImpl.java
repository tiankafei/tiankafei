package org.tiankafei.rule.verify.impl;

import java.util.List;
import org.tiankafei.rule.ruledtos.RuleDesignDto;
import org.tiankafei.rule.verify.IQuery;
import org.tiankafei.rule.verify.model.VerifyResultModel;

/**
 * 审核规则
 *
 * @author tiankafei
 */
public class VerifyImpl extends BaseVerify {
    @Override
    public List<VerifyResultModel> executeVerify(List<RuleDesignDto> ruleDesignDtoList, IQuery query) {
        return null;
    }
}
