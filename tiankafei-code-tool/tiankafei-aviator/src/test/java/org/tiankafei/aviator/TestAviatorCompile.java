package org.tiankafei.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import org.junit.Before;
import org.junit.Test;
import org.tiankafei.aviator.util.AviatorUtil;

public class TestAviatorCompile {

    @Before
    public void before() {
        AviatorUtil.initFun();
    }

    @Test
    public void test1() {
        try {
            Expression exp = AviatorEvaluator.compile("b=2; if(a > 1) { a + b } elsif( a > 10) { return a + c; } else { return 10 }");
            System.out.println(exp.getVariableNames());
            System.out.println(exp.getVariableFullNames());
        }catch (Exception e) {
            System.out.println("--------------------");
            System.out.println(e.getMessage());
            System.out.println("--------------------");
        }
    }

}
