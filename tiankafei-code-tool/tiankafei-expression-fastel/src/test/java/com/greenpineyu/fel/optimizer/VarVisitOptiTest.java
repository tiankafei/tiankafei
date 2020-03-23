package com.greenpineyu.fel.optimizer;

import com.greenpineyu.fel.Expression;
import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.context.Var;
import org.junit.Assert;
import org.junit.Test;

public class VarVisitOptiTest {

    @Test(expected = Exception.class)
    public void VarVisitOpti() throws Exception {
        FelEngine e = FelEngine.INSTANCE;
        Expression exp = e.compile("a+a", null, new VarVisitOpti(
                new Var("a", 1)));
        Object eval = exp.eval(null);

        Assert.fail();
    }
}