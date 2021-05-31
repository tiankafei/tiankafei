package org.tiankafei.rule.util;

import org.tiankafei.rule.enums.RuleEnums;
import org.tiankafei.rule.verify.IVerify;
import org.tiankafei.rule.verify.impl.ComputeImpl;
import org.tiankafei.rule.verify.impl.JumpImpl;
import org.tiankafei.rule.verify.impl.VerifyImpl;

/**
 * @author tiankafei
 */
public class VerifyUtil {

    /**
     * 获取审核实例对象
     *
     * @param ruleType
     * @return
     */
    public static IVerify getVerifyInstance(Integer ruleType) {
        IVerify verify = null;
        if (RuleEnums.VERIFY.getCode() == ruleType) {
            verify = new VerifyImpl();
        } else if (RuleEnums.COMPUTE.getCode() == ruleType) {
            verify = new ComputeImpl();
        } else if (RuleEnums.JUMP.getCode() == ruleType) {
            verify = new JumpImpl();
        }
        return verify;
    }

}
