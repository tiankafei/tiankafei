package com.googlecode.aviator.runtime.function.seq;

import com.googlecode.aviator.lexer.token.OperatorType;
import com.googlecode.aviator.runtime.type.AviatorFunction;
import com.googlecode.aviator.runtime.type.AviatorJavaType;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class SeqMakePredicateFunctionUnitTest {

    @Test
    public void testMakePredicate() {
        SeqMakePredicateFunFunction fun = new SeqMakePredicateFunFunction("eq", OperatorType.EQ);

        Map<String, Object> env = new HashMap<String, Object>();
        AviatorJavaType predicateName =
                (AviatorJavaType) fun.call(env, new AviatorRuntimeJavaType("hello"));

        assertNotNull(predicateName);
        AviatorFunction predicate = (AviatorFunction) predicateName.getValue(env);
        assertNotNull(predicate);
        BaseAviatorObject result = predicate.call(null, new AviatorRuntimeJavaType("hello"));
        // equals self
        assertTrue(result.booleanValue(null));

    }


    @Test
    public void testMakePredicate_FixedValue() {
        SeqMakePredicateFunFunction fun =
                new SeqMakePredicateFunFunction("eq", OperatorType.EQ, new AviatorRuntimeJavaType("hello"));
        Map<String, Object> env = new HashMap<String, Object>();
        AviatorJavaType predicateName = (AviatorJavaType) fun.call(env);

        assertNotNull(predicateName);
        AviatorFunction predicate = (AviatorFunction) predicateName.getValue(env);
        assertNotNull(predicate);

        BaseAviatorObject result = predicate.call(null, new AviatorRuntimeJavaType("hello"));
        // equals self
        assertTrue(result.booleanValue(null));

        result = predicate.call(null, new AviatorRuntimeJavaType("he11o"));
        // equals self
        assertFalse(result.booleanValue(null));

    }

}
