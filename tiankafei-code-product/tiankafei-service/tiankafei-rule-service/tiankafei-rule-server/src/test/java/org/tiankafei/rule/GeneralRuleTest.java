package org.tiankafei.rule;

import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tiankafei.rule.service.RuleExecuteService;
import org.tiankafei.rule.vo.RuleExecuteVo;

/**
 * @author tiankafei
 * @since 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RuleApplication.class)
public class GeneralRuleTest {

    @Before
    public void before() {

    }

    @Autowired
    private RuleExecuteService ruleExecuteService;

    @Autowired
    private DefaultIdentifierGenerator defaultIdentifierGenerator;

    @Test
    public void test1() throws Exception {
        RuleExecuteVo ruleExecuteVo = new RuleExecuteVo();

        ruleExecuteVo.setId(defaultIdentifierGenerator.nextId(null));
        ruleExecuteVo.setCode("0010");
        ruleExecuteVo.setName("规则代码0010");
        ruleExecuteVo.setExpression("to_number(a) == to_number(b)");
        ruleExecuteVo.setExpressionDto("{}");
        ruleExecuteVo.setErrorExpressionList("[]");
        ruleExecuteVo.setErrorJavascriptList("[]");

        ruleExecuteService.addRuleExecuteService(ruleExecuteVo);
    }

}
