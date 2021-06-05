package org.tiankafei.rule.verify;

import java.util.List;
import org.tiankafei.rule.entity.RuleExecuteEntity;
import org.tiankafei.rule.util.VerifyUtil;
import org.tiankafei.rule.verify.model.VerifyResultModel;

/**
 * @author tiankafei
 */
public class Verify {

    /**
     * 执行审核
     *
     * @param ruleType
     * @param ruleExecuteEntityList
     * @param query
     * @return
     */
    public static List<VerifyResultModel> executeVerify(Integer ruleType, List<RuleExecuteEntity> ruleExecuteEntityList, IQuery query) {
        IVerify verifyInstance = VerifyUtil.getVerifyInstance(ruleType);

        List<VerifyResultModel> verifyResultModelList = verifyInstance.executeVerify(ruleExecuteEntityList, query);

        return verifyResultModelList;
    }

}
