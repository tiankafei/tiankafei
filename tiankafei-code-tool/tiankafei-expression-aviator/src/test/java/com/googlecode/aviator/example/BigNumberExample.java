package com.googlecode.aviator.example;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Options;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;


public class BigNumberExample {

    public static void main(String[] args) {
        Object rt = AviatorEvaluator.getInstance().exec("9223372036854775807100.356M * 2");
        System.out.println(rt + "  " + rt.getClass());

        rt = AviatorEvaluator.getInstance().exec("92233720368547758074+1000");
        System.out.println(rt + "  " + rt.getClass());

        BigInteger a = new BigInteger(String.valueOf(Long.MAX_VALUE) + String.valueOf(Long.MAX_VALUE));
        BigDecimal b = new BigDecimal("3.2");
        BigDecimal c = new BigDecimal("9999.99999");

        rt = AviatorEvaluator.getInstance().exec("a+10000000000000000000", a);
        System.out.println(rt + "  " + rt.getClass());

        rt = AviatorEvaluator.getInstance().exec("b+c*2", b, c);
        System.out.println(rt + "  " + rt.getClass());

        rt = AviatorEvaluator.getInstance().exec("a*b/c", a, b, c);
        System.out.println(rt + "  " + rt.getClass());

        // set math context
        AviatorEvaluator.newInstance().setOption(Options.MATH_CONTEXT, MathContext.DECIMAL64);
        rt = AviatorEvaluator.getInstance().exec("a*b/c", a, b, c);
        System.out.println(rt + "  " + rt.getClass());
    }
}
