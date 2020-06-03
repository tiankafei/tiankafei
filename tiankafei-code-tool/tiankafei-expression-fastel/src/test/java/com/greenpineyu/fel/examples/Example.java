package com.greenpineyu.fel.examples;

import com.google.common.base.Stopwatch;
import com.greenpineyu.fel.Expression;
import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.FelEngineImpl;
import com.greenpineyu.fel.Foo;
import com.greenpineyu.fel.context.AbstractContext;
import com.greenpineyu.fel.context.ContextChain;
import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.context.MapContext;
import com.greenpineyu.fel.interpreter.ConstInterpreter;
import com.greenpineyu.fel.interpreter.Interpreter;
import com.greenpineyu.fel.optimizer.Interpreters;
import com.greenpineyu.fel.parser.FelNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Example {

    public static void main(String[] args) throws Exception {

        helloworld();
        System.out.println("--------------------");
        useVariable();
        System.out.println("--------------------");
        getAttr();
        System.out.println("--------------------");
        visitColl();
        System.out.println("--------------------");
        callMethod();
        System.out.println("--------------------");
        context();
        System.out.println("--------------------");
        contexts();
        System.out.println("--------------------");
        userInterpreter();
        System.out.println("--------------------");
        massData();
        System.out.println("--------------------");
        operatorOverload();
        System.out.println("--------------------");
        testCompile();
        // FelContext ctx = fel.getContext();
        // ctx.set("单价", "5000");
        // ctx.set("数量", new Integer(12));
        // ctx.set("运费", "7500");
        // Object result = fel.eval("单价*数量+运费");
        // System.out.println(result);
    }

    /**
     * 入门
     */
    public static void helloworld() throws Exception {
        // FelEngine fel = new FelEngineImpl();
        Object result = FelEngine.INSTANCE.eval("5000*12+7500");
        System.out.println(result);
    }

    /**
     * 使用变量
     */
    public static void useVariable() throws Exception {
        FelEngine fel = new FelEngineImpl();
        FelContext ctx = fel.getContext();
        ctx.set("单价", 5000);
        ctx.set("数量", 12);
        ctx.set("运费", 7500);
        Object result = fel.eval("单价*数量+运费");
        System.out.println(result);
    }

    /**
     * 获取对象属性
     */
    public static void getAttr() throws Exception {
        FelEngine fel = new FelEngineImpl();
        FelContext ctx = fel.getContext();
        Foo foo = new Foo();
        ctx.set("foo", foo);
        Map<String, String> m = new HashMap<String, String>();
        m.put("ElName", "fel");
        ctx.set("m", m);

        //调用foo.getSize()方法。
        Object result = fel.eval("foo.size");

        //调用foo.isSample()方法。
        result = fel.eval("foo.sample");

        //foo没有name、getName、isName方法
        //foo.name会调用foo.get("name")方法。
        result = fel.eval("foo.name");

        //m.ElName会调用m.get("ElName");
        result = fel.eval("m.ElName");
    }

    /**
     * 调用对象的方法
     */
    public static void callMethod() throws Exception {
        FelEngine fel = new FelEngineImpl();
        FelContext ctx = fel.getContext();
        ctx.set("out", System.out);
        fel.eval("out.println('Hello Everybody'.substring(6))");
    }

    /**
     * 访问数组、集合
     */
    public static void visitColl() throws Exception {
        FelEngine fel = new FelEngineImpl();
        FelContext ctx = fel.getContext();

        //数组
        int[] intArray = {1, 2, 3};
        ctx.set("intArray", intArray);
        //获取intArray[0]
        String exp = "intArray[0]";
        System.out.println(exp + "->" + fel.eval(exp));

        //List
        List<Integer> list = Arrays.asList(1, 2, 3);
        ctx.set("list", list);
        //获取list.get(0)
        exp = "list[0]";
        System.out.println(exp + "->" + fel.eval(exp));

        //集合
        Collection<String> coll = Arrays.asList("a", "b", "c");
        ctx.set("coll", coll);
        //获取集合最前面的元素。执行结果为"a"
        exp = "coll[0]";
        System.out.println(exp + "->" + fel.eval(exp));

        //迭代器
        Iterator<String> iterator = coll.iterator();
        ctx.set("iterator", iterator);
        //获取迭代器最前面的元素。执行结果为"a"
        exp = "iterator[0]";
        System.out.println(exp + "->" + fel.eval(exp));

        //Map
        Map<String, String> m = new HashMap<String, String>();
        m.put("name", "HashMap");
        ctx.set("map", m);
        exp = "map.name";
        System.out.println(exp + "->" + fel.eval(exp));

        //多维数组
        int[][] intArrays = {{11, 12}, {21, 22}};
        ctx.set("intArrays", intArrays);
        exp = "intArrays[0][0]";
        System.out.println(exp + "->" + fel.eval(exp));

        //多维综合体，支持数组、集合的任意组合。
        List<int[]> listArray = new ArrayList<int[]>();
        listArray.add(new int[]{1, 2, 3});
        listArray.add(new int[]{4, 5, 6});
        ctx.set("listArray", listArray);
        exp = "listArray[0][0]";
        System.out.println(exp + "->" + fel.eval(exp));
    }

    /**
     * 自定义上下文环境
     */
    public static void context() throws Exception {
        // 负责提供气象服务的上下文环境
        FelContext ctx = new AbstractContext() {
            @Override
            public Object get(String name) {
                if ("天气".equals(name)) {
                    return "晴";
                }
                if ("温度".equals(name)) {
                    return 25;
                }
                return null;
            }

            @Override
            public boolean existsKey(String name) {
                return true;
            }

            @Override
            public void clearValue() {

            }
        };
        FelEngine fel = new FelEngineImpl(ctx);
        String exp = "'天气:'+天气+';温度:'+温度";
        Object eval = fel.compile(exp, ctx).eval(ctx);
        System.out.println(eval);
    }

    /**
     * 多层次上下文环境(变量命名空间)
     */
    public static void contexts() throws Exception {
        FelEngine fel = new FelEngineImpl();
        String costStr = "成本";
        String priceStr = "价格";
        FelContext baseCtx = fel.getContext();
        // 父级上下文中设置成本和价格
        baseCtx.set(costStr, 50);
        baseCtx.set(priceStr, 100);

        String exp = priceStr + "-" + costStr;
        Object baseCost = fel.eval(exp);
        System.out.println("期望利润：" + baseCost);

        FelContext ctx = new ContextChain(baseCtx, new MapContext());
        // 通货膨胀导致成本增加（子级上下文 中设置成本，会覆盖父级上下文中的成本）
        ctx.set(costStr, 50 + 20);
        Object allCost = fel.eval(exp, ctx);
        System.out.println("实际利润：" + allCost);
    }

    public static void testCompile() throws Exception {
        FelEngine fel = new FelEngineImpl();
        FelContext ctx = fel.getContext();
        ctx.set("单价", 5000);
        ctx.set("数量", 12);
        ctx.set("运费", 7500);
        Expression exp = fel.compile("单价*数量+运费", ctx);
        Object result = exp.eval(ctx);
        System.out.println(result);
    }

    /**
     * 自定义 解释器
     */
    public static void userInterpreter() throws Exception {
        FelEngine fel = new FelEngineImpl();
        String costStr = "成本";
        FelContext rootContext = fel.getContext();
        rootContext.set(costStr, "60000");
        FelNode node = fel.parse(costStr);
        // 将变量解析成常量
        node.setInterpreter(new ConstInterpreter(rootContext, node));
        System.out.println(node.eval(rootContext));
    }

    /**
     * 大数据量计算（计算1千万次)
     */
    public static void massData() throws Exception {
        FelEngine fel = new FelEngineImpl();
        final Interpreters opti = new Interpreters();
        final MutableInt index = new MutableInt(0);
        int count = 10 * 1000 * 1000;
        final double[] counts = new double[count];
        final double[] prices = new double[count];
        Arrays.fill(counts, 10d);
        Arrays.fill(prices, 2.5d);
        opti.add("单价", new Interpreter() {
            @Override
            public Object interpret(FelContext context, FelNode node) {
                return prices[index.intValue()];
            }
        });
        opti.add("数量", new Interpreter() {
            @Override
            public Object interpret(FelContext context, FelNode node) {
                return counts[index.intValue()];
            }
        });
        Expression expObj = fel.compile("单价*数量", null, opti);
        Stopwatch stopwatch = Stopwatch.createStarted();
        Object result = null;
        for (int i = 0; i < count; i++) {
            result = expObj.eval(null);
            index.increment();
        }
        System.out.println("大数据量计算:" + result + ";耗时:" + stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    /**
     * 操作符重载，使用自定义解释器实现操作符重载
     */
    public static void operatorOverload() throws Exception {
        /*
         * 扩展Fel的+运算符，使其支持数组+数组
         */

        FelEngine fel = new FelEngineImpl();
        // 单价
        double[] price = new double[]{2, 3, 4};
        // 费用
        double[] cost = new double[]{0.3, 0.3, 0.4};
        FelContext ctx = fel.getContext();
        ctx.set("单价", price);
        ctx.set("费用", cost);
        String exp = "单价+费用";
        Interpreters interpreters = new Interpreters();
        // 定义"+"操作符的解释方法。
        interpreters.add("+", new Interpreter() {
            @Override
            public Object interpret(FelContext context, FelNode node) throws Exception {
                List<FelNode> args = node.getChildren();
                double[] leftArg = (double[]) args.get(0).eval(context);
                double[] rightArg = (double[]) args.get(1).eval(context);
                return sum(leftArg) + sum(rightArg);
            }

            // 对数组进行求和
            public double sum(double[] array) {
                double d = 0;
                for (int i = 0; i < array.length; i++) {
                    d += array[i];
                }
                return d;
            }
        });

        // 使用自定义解释器作为编译选项进行进行编译
        Expression expObj = fel.compile(exp, null, interpreters);
        Object eval = expObj.eval(ctx);
        System.out.println("数组相加:" + eval);
    }


    public static void testSpeed() throws Exception {
        FelEngine fel = new FelEngineImpl();
        String exp = "40.52334+60*(21.8144+17*32.663)";
        FelNode node = fel.parse(exp);
        int times = 100 * 1000 * 1000;
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < times; i++) {
            //			double j = 40.52334 + 60 * (21.8144 + 17 * 32.663);
            node.eval(null);
        }
        System.out.println("花费的时间:" + stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

}

class ColumnInterpreter implements Interpreter {
    MutableInt index;

    double[] records;

    ColumnInterpreter(MutableInt index, double[] records) {
        this.index = index;
        this.records = records;
    }

    @Override
    public Object interpret(FelContext context, FelNode node) {
        return records[index.intValue()];
    }
}

class MutableInt {
    private int value;

    public MutableInt(int i) {
        this.value = i;
    }

    public int intValue() {
        return value;
    }

    public void setValue(int i) {
        this.value = i;
    }

    public void increment() {
        value++;
    }
}

