package cn.tiankafei.aviator.extend;

import cn.tiankafei.aviator.extend.constant.FunctionConstants;
import cn.tiankafei.aviator.extend.util.AviatorExtendUtil;
import cn.tiankafei.aviator.extend.util.FunctionUtils;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class TestValue {

    static {
        AviatorExtendUtil.initFun();
    }

    @Test
    public void testCompileJs() {
//        String expression = "IF(ABS(-2)==2, 1.1+2.2, 2.2+1)";
//        AviatorExtendUtil.execute(expression);
        String expression = "IF(ABS(a)==b, c+d, e+f)";
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", -2);
        dataMap.put("b", 2);
        dataMap.put("c", 2.2);
        dataMap.put("d", -1);
        dataMap.put("e", -1);
        dataMap.put("f", -1);
        AviatorExtendUtil.execute(expression, dataMap);
    }

    @Test
    public void testCustomAdd() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", 1.1);
        dataMap.put("b", 2.2);
        AviatorExtendUtil.execute("a+b", dataMap);
    }

    @Test
    public void test1() {
        AviatorExtendUtil.execute("-1-1");
        AviatorExtendUtil.execute("-1-1>=-1");

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("a", -1);
        dataMap.put("b", -1);
        AviatorExtendUtil.execute("a-b>=-1", dataMap);
    }

    @Test
    public void test2() {
        String value = "1";
        System.out.println(value + "：" + FunctionUtils.isNumerics(value));
        value = "1.1";
        System.out.println(value + "：" + FunctionUtils.isNumerics(value));
        value = "-1.1";
        System.out.println(value + "：" + FunctionUtils.isNumerics(value));
        value = "--1.1";
        System.out.println(value + "：" + FunctionUtils.isNumerics(value));
        System.out.println("=====================================================");
    }

    @Test
    public void test3() {


    }

}
