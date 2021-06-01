package org.tiankafei.rule.verify;

import java.util.List;
import org.tiankafei.rule.parsedto.RuleDesignDto;
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
     * @param ruleDesignDtoList
     * @param query
     * @return
     */
    public static List<VerifyResultModel> executeVerify(Integer ruleType, List<RuleDesignDto> ruleDesignDtoList, IQuery query) {
        IVerify verifyInstance = VerifyUtil.getVerifyInstance(ruleType);

        List<VerifyResultModel> verifyResultModelList = verifyInstance.executeVerify(ruleDesignDtoList, query);

        return verifyResultModelList;
    }

}
