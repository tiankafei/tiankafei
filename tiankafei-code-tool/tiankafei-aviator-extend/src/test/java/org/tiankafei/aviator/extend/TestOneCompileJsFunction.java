package org.tiankafei.aviator.extend;

import org.tiankafei.aviator.extend.util.AviatorExtendUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TestOneCompileJsFunction {

    static {
        AviatorExtendUtil.initFun();
    }

    @Test
    public void testAbs() {
        String expression = "ABS(-1.1)";
        AviatorExtendUtil.compileJs(expression);
        expression = "ABS(a)";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "-1.1");
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testNotNull() {
        String expression = "NOTNULL(1)";
        AviatorExtendUtil.compileJs(expression);
        expression = "NOTNULL(nil)";
        AviatorExtendUtil.compileJs(expression);
        expression = "NOTNULL(a)";
        Map<String, Object> dataMap = new HashMap<>();
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", 1);

        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testIsNull() {
        String expression = "ISNULL(1)";
        AviatorExtendUtil.compileJs(expression);
        expression = "ISNULL(nil)";
        AviatorExtendUtil.compileJs(expression);
        expression = "ISNULL(a)";
        Map<String, Object> dataMap = new HashMap<>();
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", 1);

        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testIsNumber() {
        String expression = "ISNUMBER(1)";
        AviatorExtendUtil.compileJs(expression);
        expression = "ISNUMBER(1.0)";
        AviatorExtendUtil.compileJs(expression);
        expression = "ISNUMBER(-1.0)";
        AviatorExtendUtil.compileJs(expression);
        expression = "ISNUMBER('a')";
        AviatorExtendUtil.compileJs(expression);
        expression = "ISNUMBER(a)";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "a");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", 1);

        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", 1.0);

        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "-1.0");

        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "-1.0a");

        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testIsNum() {
        String expression = "ISNUM(1)";
        AviatorExtendUtil.compileJs(expression);
        expression = "ISNUM(1.0)";
        AviatorExtendUtil.compileJs(expression);
        expression = "ISNUM(-1.0)";
        AviatorExtendUtil.compileJs(expression);
        expression = "ISNUM('a')";
        AviatorExtendUtil.compileJs(expression);
        expression = "ISNUM(a)";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "a");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", 1);

        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", 1.0);

        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "-1.0");

        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "-1.0a");

        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testCeil() {
        String expression = "ceil(1.1)";
        AviatorExtendUtil.compileJs(expression);
        expression = "ceil(-1.1)";
        AviatorExtendUtil.compileJs(expression);
        expression = "ceil(a)";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", 1.1);
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", -1.1);

        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testCurrentTime() {
        String expression = "currenttime(\"yyyy-MM-dd HH:mm:ss\")";
        AviatorExtendUtil.compileJs(expression);
        expression = "currenttime(\"yyyy-MM-dd HH:mm\")";
        AviatorExtendUtil.compileJs(expression);
        expression = "currenttime(\"yyyy-MM-dd HH\")";
        AviatorExtendUtil.compileJs(expression);
        expression = "currenttime(\"yyyy-MM-dd\")";
        AviatorExtendUtil.compileJs(expression);
        expression = "currenttime(\"yyyy-MM\")";
        AviatorExtendUtil.compileJs(expression);
        expression = "currenttime(\"yyyy\")";
        AviatorExtendUtil.compileJs(expression);
        expression = "currenttime(a)";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", "yyyy-MM-dd HH:mm:ss");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "yyyy-MM-dd HH:mm");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "yyyy-MM-dd HH");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "yyyy-MM-dd");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "yyyy-MM");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "yyyy");
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testNot() {
        String expression = "not(1.1==1.2)";
        AviatorExtendUtil.compileJs(expression);
        expression = "not(1.1==1.1)";
        AviatorExtendUtil.compileJs(expression);
        expression = "not(a==b)";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", 1.1);
        dataMap.put("b", 1.2);
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", 1.1);
        dataMap.put("b", 1.1);

        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testNotOper() {
        String expression = "!(1.1==1.2)";
        AviatorExtendUtil.compileJs(expression);
        expression = "!(1.1==1.1)";
        AviatorExtendUtil.compileJs(expression);
        expression = "!(a==b)";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", 1.1);
        dataMap.put("b", 1.2);
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", 1.1);
        dataMap.put("b", 1.1);

        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testIsch() {
        String expression = "isch('sdfasfd')";
        AviatorExtendUtil.compileJs(expression);
        expression = "isch('晚上')";
        AviatorExtendUtil.compileJs(expression);
        expression = "isch('晚上sfdas')";
        AviatorExtendUtil.compileJs(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "isch(a)";

        dataMap.put("a", "sfdasfd");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "收费单身");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "暗示法地方撒sfdasf");
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testIsen() {
        String expression = "isen('sdfasfd')";
        AviatorExtendUtil.compileJs(expression);
        expression = "isen('晚上')";
        AviatorExtendUtil.compileJs(expression);
        expression = "isen('晚上sfdas')";
        AviatorExtendUtil.compileJs(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "isen(a)";

        dataMap.put("a", "sfdasfd");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "收费单身");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "暗示法地方撒sfdasf");
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testIslower() {
        String expression = "islower('sdfasfd')";
        AviatorExtendUtil.compileJs(expression);
        expression = "islower('晚上')";
        AviatorExtendUtil.compileJs(expression);
        expression = "islower('晚上sfdas')";
        AviatorExtendUtil.compileJs(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "islower(a)";

        dataMap.put("a", "sfdasfd");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "收费单身");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "暗示法地方撒sfdasf");
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testIsupper() {
        String expression = "isupper('SDFASFD')";
        AviatorExtendUtil.compileJs(expression);
        expression = "isupper('晚上')";
        AviatorExtendUtil.compileJs(expression);
        expression = "isupper('晚上SFDAS')";
        AviatorExtendUtil.compileJs(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "isupper(a)";

        dataMap.put("a", "SFDASFD");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "收费单身");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "暗示法地方撒SFDASF");
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testLen() {
        String expression = "len('SDFASFD')";
        AviatorExtendUtil.compileJs(expression);
        expression = "len('晚上')";
        AviatorExtendUtil.compileJs(expression);
        expression = "len('晚上SFDAS')";
        AviatorExtendUtil.compileJs(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "len(a)";

        dataMap.put("a", "SFDASFD");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "收费单身");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "暗示法地方撒SFDASF");
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testLength() {
        String expression = "length('SDFASFD')";
        AviatorExtendUtil.compileJs(expression);
        expression = "length('晚上')";
        AviatorExtendUtil.compileJs(expression);
        expression = "length('晚上SFDAS')";
        AviatorExtendUtil.compileJs(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "length(a)";

        dataMap.put("a", "SFDASFD");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "收费单身");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "暗示法地方撒SFDASF");
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testRound() {
        String expression = "round('1.5')";
        AviatorExtendUtil.compileJs(expression);
        expression = "round('-1.5')";
        AviatorExtendUtil.compileJs(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "round(a)";

        dataMap.put("a", "1.5");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "-1.5");
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testTrim() {
        String expression = "trim('   SAFD   ')";
        AviatorExtendUtil.compileJs(expression);
        expression = "trim('   -1.1   ')";
        AviatorExtendUtil.compileJs(expression);
        expression = "trim('  ASD')";
        AviatorExtendUtil.compileJs(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "trim(a)";

        dataMap.put("a", "   1.1");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "-1.1   ");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "     A      ");
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testLower() {
        String expression = "lower('   SAFD   ')";
        AviatorExtendUtil.compileJs(expression);
        expression = "lower('   -1.1   ')";
        AviatorExtendUtil.compileJs(expression);
        expression = "lower('  ASD')";
        AviatorExtendUtil.compileJs(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "lower(a)";

        dataMap.put("a", "   1.1");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "-1.1   ");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "     A      ");
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testUpper() {
        String expression = "upper('   safd   ')";
        AviatorExtendUtil.compileJs(expression);
        expression = "upper('   -1.1   ')";
        AviatorExtendUtil.compileJs(expression);
        expression = "upper('  asd')";
        AviatorExtendUtil.compileJs(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "upper(a)";

        dataMap.put("a", "   1.1");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "-1.1   ");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "     a      ");
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testTrunc() {
        String expression = "trunc('1.5')";
        AviatorExtendUtil.compileJs(expression);
        expression = "trunc('-1.5')";
        AviatorExtendUtil.compileJs(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "trunc(a)";

        dataMap.put("a", "1.5");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "-1.5");
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testVerifycode() {
        String expression = "verifycode('134766570')";
        AviatorExtendUtil.compileJs(expression);
        expression = "verifycode('-1.5')";
        AviatorExtendUtil.compileJs(expression);
        expression = "verifycode('asd')";
        AviatorExtendUtil.compileJs(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "verifycode(a)";

        dataMap.put("a", "134766570");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "-1.5");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "a");
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testVerifyIdCard() {
        String expression = "verifyidcard('134766570')";
        AviatorExtendUtil.compileJs(expression);
        expression = "verifyidcard('-1.5')";
        AviatorExtendUtil.compileJs(expression);
        expression = "verifyidcard('asd')";
        AviatorExtendUtil.compileJs(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "verifyidcard(a)";

        dataMap.put("a", "134766570");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "-1.5");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "a");
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

    @Test
    public void testVerifyCreditCode() {
        String expression = "verifycreditcode('91110000100026793Y')";
        AviatorExtendUtil.compileJs(expression);
        expression = "verifycreditcode('-1.5')";
        AviatorExtendUtil.compileJs(expression);
        expression = "verifycreditcode('asd')";
        AviatorExtendUtil.compileJs(expression);
        Map<String, Object> dataMap = new HashMap<>();
        expression = "verifycreditcode(a)";

        dataMap.put("a", "91110000100026793Y");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "-1.5");
        AviatorExtendUtil.compileJs(expression, dataMap);
        dataMap.put("a", "a");
        AviatorExtendUtil.compileJs(expression, dataMap);
    }

}
