package org.tiankafei.rule;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tiankafei.rule.service.RuleDesignService;
import org.tiankafei.rule.vo.RuleDesignVo;

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
    private RuleDesignService ruleDesignService;

    @Test
    public void test1() throws Exception {
        RuleDesignVo ruleDesignVo = new RuleDesignVo();


        ruleDesignService.addRuleDesignService(ruleDesignVo);
    }

}
