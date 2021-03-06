package com.greenpineyu.fel.function;

import com.greenpineyu.fel.common.StringUtils;
import com.greenpineyu.fel.compile.FelMethod;
import com.greenpineyu.fel.compile.SourceBuilder;
import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.parser.FelNode;

/**
 * $函数，通过$获取class或者创建对象 ${Math} 结果为 Math.class ${Dollar.new} 结果为 new Dollar()
 *
 * @author yuqingsong
 */
public class Dollar implements Function {


    @Override
    public String getName() {
        return "$";
    }

    @Override
    public String getJsFunName() {
        return null;
    }

    @Override
    public Object call(FelNode node, FelContext context) {
        String txt = getChildText(node);

        boolean isNew = isNew(txt);
        Class<?> cls = getClass(txt, isNew);
        if (isNew) {
            Object o = null;
            if (cls != null) {
                try {
                    o = cls.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            return o;

        } else {
            return cls;
        }
    }

    private static final String SUFFIX = ".new";

    @SuppressWarnings("unused")
    private Class<?> getClass(FelNode node) {
        String txt = getChildText(node);
        boolean isNew = isNew(txt);
        return getClass(txt, isNew);
    }

    private Class<?> getClass(String txt, boolean isNew) {
        String className = txt;
        if (isNew) {
            className = className.substring(0, txt.length() - SUFFIX.length());
        }
        String value = ".";
        if (className.indexOf(value) == -1) {
            className = "java.lang." + className;
        }
        try {
            Class<?> clz = Class.forName(className);
            return clz;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean isNew(String txt) {
        boolean isNew = txt.endsWith(SUFFIX);
        return isNew;
    }

    private String getChildText(FelNode node) {
        String txt = node.getChildren().get(0).getText();
        txt = StringUtils.remove(txt, '\'');
        txt = StringUtils.remove(txt, '"');
        return txt;
    }

    @Override
    public SourceBuilder toMethod(FelNode node, FelContext ctx) {
        String txt = getChildText(node);

        boolean isNew = isNew(txt);
        Class<?> cls = getClass(txt, isNew);
        String code = cls.getName();
        if (isNew) {
            code = "new " + code + "()";
        }
        return new FelMethod(cls, code);
    }

    @Override
    public SourceBuilder toJsMethod(FelNode node, FelContext ctx) throws Exception {
        String txt = getChildText(node);

        boolean isNew = isNew(txt);
        Class<?> cls = getClass(txt, isNew);
        String code = cls.getName();
        if (isNew) {
            code = "new " + code + "()";
        }
        return new FelMethod(cls, code);
    }
}
