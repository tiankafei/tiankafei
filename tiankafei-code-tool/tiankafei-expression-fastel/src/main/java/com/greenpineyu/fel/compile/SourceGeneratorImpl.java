package com.greenpineyu.fel.compile;

import com.greenpineyu.fel.common.Callable;
import com.greenpineyu.fel.common.StringUtils;
import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.optimizer.ConstExpOpti;
import com.greenpineyu.fel.optimizer.ConstOpti;
import com.greenpineyu.fel.optimizer.Optimizer;
import com.greenpineyu.fel.parser.BaseAbstFelNode;
import com.greenpineyu.fel.parser.ConstNode;
import com.greenpineyu.fel.parser.FelNode;
import com.greenpineyu.fel.parser.VarAstNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tiankafei
 */
public class SourceGeneratorImpl implements SourceGenerator {

    private List<Optimizer> opt;

    private static String template;
    private static String jsTemplate;

    private static int count = 0;
    private static int jsCount = 0;

    private Map<String, StringKeyValue> localvars;

    /**
     * 包名
     */
    static final String PACKAGE;

    {
        opt = new ArrayList<Optimizer>();
        localvars = new HashMap<String, StringKeyValue>();
        initOpti();
    }

    static {
        String fullName = SourceGeneratorImpl.class.getName();
        PACKAGE = fullName.substring(0, fullName.lastIndexOf("."));

        template = getTemplate("java.template");
        jsTemplate = getTemplate("js.template");
    }

    private static String getTemplate(String templatePath) {
        StringBuilder sb = new StringBuilder();
        InputStream in = SourceGeneratorImpl.class
                .getResourceAsStream(templatePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    @Override
    public JavaSource getSource(FelContext ctx, FelNode node, CompileParamVo compileParamVo) throws Exception {

        String src = "";
        String className = getClassName(compileParamVo);
        synchronized (this) {
            node = optimize(ctx, node);
            if (node instanceof ConstNode) {
                ConstNode n = (ConstNode) node;
                return new ConstExpSrc(n.interpret(null, null));
            }
            SourceBuilder builder = node.toMethod(ctx);
            String exp = builder.source(ctx, node);
            List<String> programList = getProgramList(builder);
            src = buildsource(exp, className, programList, compileParamVo);
            this.localvars.clear();
        }
        System.out.println("****************{}\n" + src);
        JavaSource returnMe = new JavaSource();
        returnMe.setSimpleName(className);
        returnMe.setSource(src);
        returnMe.setPackageName(PACKAGE);
        return returnMe;
    }

    @Override
    public String getJsSource(FelContext ctx, FelNode node, CompileParamVo compileParamVo) throws Exception {
        String src = "";
        String funName = getFunName(compileParamVo);
        synchronized (this) {
            node = optimize(ctx, node);
            if (node instanceof ConstNode) {
                ConstNode n = (ConstNode) node;
                src = buildJsSource(funName, n.eval(ctx).toString());
            } else {
                SourceBuilder builder = node.toJsMethod(ctx);
                String exp = builder.source(ctx, node);
                List<String> programList = getProgramList(builder);
//                log.info("表达式：{}, 方法名：{}, 参数集合：{}, 编译对象：{}", exp, funName, programList, compileParamVo);
                src = buildJsSource(exp, funName, programList, compileParamVo);
                this.localvars.clear();
            }
        }
        System.out.println("****************{}\n" + src);
        return src;
    }

    private List<String> getProgramList(SourceBuilder builder) {
        List<String> programList = null;
        if (builder instanceof FelMethod) {
            FelMethod felMethod = (FelMethod) builder;
            programList = felMethod.getProgramList();
        }
        return programList;
    }

    private String getProgramList(List<String> programList) {
        StringBuffer stringBuffer = new StringBuffer();
        if (programList != null) {
            for (int index = 0, length = programList.size(); index < length; index++) {
                if (index != 0) {
                    stringBuffer.append("\t\t");
                }
                stringBuffer.append(programList.get(index)).append(";\n");
            }
        }
        return stringBuffer.toString();
    }

    private String buildJsSource(String funName, String obj) {
        String src = StringUtils.replace(jsTemplate, "${funname}", funName);
        src = StringUtils.replace(src, "${programList}", "");
        src = StringUtils.replace(src, "${expression}", obj.toString());
        return src;
    }

    private String buildJsSource(String expression, String funName, List<String> programList, CompileParamVo compileParamVo) {
        String src = StringUtils.replace(jsTemplate, "${funname}", funName);
        src = StringUtils.replace(src, "${programList}", getProgramList(programList));
        src = StringUtils.replace(src, "${expression}", expression);
        return src;
    }

    private String buildsource(String expression, String className, List<String> programList, CompileParamVo compileParamVo) {
        String src = StringUtils.replace(template, "${classname}", className);
        StringBuilder attrs = new StringBuilder();
        String pop = VarBuffer.pop();
        if (pop != null) {
            // 第一行不需要添加空格
            attrs.append(pop).append("\r\n");
            pop = VarBuffer.pop();
        }
        while (pop != null) {
            attrs.append("    ").append(pop).append("\r\n");
            pop = VarBuffer.pop();
        }
        // removeLastEnter(attrs);
        src = StringUtils.replace(src, "${attrs}", attrs.toString());
        src = StringUtils.replace(src, "${localVars}", getLocalVarsCode());
        src = StringUtils.replace(src, "${programList}", getProgramList(programList));
        src = StringUtils.replace(src, "${expression}", expression);
        String packagePath = "";
        if (compileParamVo != null) {
            if (StringUtils.isNotEmpty(compileParamVo.getPackagePath())) {
                packagePath = compileParamVo.getPackagePath();
            }
        }
        src = StringUtils.replace(src, "${packagePath}", packagePath);
        return src;
    }

    private String getClassName(CompileParamVo compileParamVo) {
        String className = null;
        synchronized (SourceGeneratorImpl.class) {
            if (compileParamVo != null && StringUtils.isNotEmpty(compileParamVo.getId())) {
                className = "Fel_" + compileParamVo.getId();
            } else {
                className = "Fel_" + count++;
            }
        }
        return className;
    }

    private String getFunName(CompileParamVo compileParamVo) {
        if (compileParamVo != null) {
            return "fun_" + compileParamVo.getId();
        } else {
            String className = null;
            synchronized (SourceGeneratorImpl.class) {
                className = "Fel_" + jsCount++;
            }
            return className;
        }
    }

    private String getLocalVarsCode() {
        StringBuilder sb = new StringBuilder();
        Collection<StringKeyValue> values = localvars.values();
        boolean isFirst = true;
        for (StringKeyValue code : values) {
            if (isFirst) {
                // 第一行不需要添加空格
                isFirst = false;
            } else {
                sb.append("        ");
            }
            sb.append(code.value).append("\r\n");
        }
        removeLastEnter(sb);
        return sb.toString();
    }

    private void removeLastEnter(StringBuilder sb) {
        if (sb.length() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }
    }

    // private final int localVarCount = 0;

    class StringKeyValue {
        String key;
        String value;

        public StringKeyValue(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 对节点进行优化
     *
     * @param ctx
     * @param node
     * @return
     */
    private FelNode optimize(FelContext ctx, FelNode node) throws Exception {
        for (Optimizer o : opt) {
            node = o.call(ctx, node);
        }
        return node;
    }

    private void initOpti() {
        // 进行常量优化(计算表达式中的常量节点)
        Optimizer constOpti = new ConstOpti();
        this.addOpti(constOpti);

        // 如果整个表达式是一个常量，再进行一次优化(可以减少装包拆包花费的时间)
        Optimizer constExpOpti = new ConstExpOpti();

        this.addOpti(constExpOpti);


        // 进行变量优化
        Optimizer optimizVars = getVarOpti();
        this.addOpti(optimizVars);
    }

    public static final Callable<Boolean, FelNode> VARS_FILTER = new Callable<Boolean, FelNode>() {
        @Override
        public Boolean call(FelNode... node) {
            FelNode n = node[0];
            return VarAstNode.isVar(n);
        }
    };

    /**
     * 获取变量优化方案
     *
     * @return
     */
    private Optimizer getVarOpti() {
        Optimizer optimizVars = new Optimizer() {
            @Override
            public FelNode call(FelContext ctx, FelNode node) throws Exception {
                List<FelNode> nodes = BaseAbstFelNode.getNodes(node, VARS_FILTER);
                // 多次出现的变量
//				List<FelNode> repeatNodes = new ArrayList<FelNode>();

                Map<String, List<FelNode>> repeatNodeMap = new HashMap<String, List<FelNode>>(nodes.size());
                for (FelNode n : nodes) {
                    String name = n.getText();
                    List<FelNode> repeatNodes = repeatNodeMap.get(name);
                    if (repeatNodes == null) {
                        repeatNodes = new ArrayList<FelNode>();
                        repeatNodeMap.put(name, repeatNodes);
                    }
                    repeatNodes.add(n);
                }
                for (List<FelNode> repeatNodes : repeatNodeMap.values()) {
                    if (repeatNodes.size() > 1) {
                        for (FelNode n : repeatNodes) {
                            n.setSourcebuilder(getVarSrcBuilder(n.toMethod(ctx)));
                        }
                    }
                }

                return node;
            }

            private SourceBuilder getVarSrcBuilder(final SourceBuilder old) {

                return new SourceBuilder() {

                    @Override
                    public String source(FelContext ctx, FelNode node) throws Exception {
                        String text = node.getText();
                        if (localvars.containsKey(text)) {
                            StringKeyValue kv = localvars.get(text);
                            return kv.key;
                        }
                        String varName = text;
//                        Class<?> type = this.returnType(ctx, node);
                        String declare = "";
//                        String typeDeclare = type.getCanonicalName();
//                        if (ReflectUtil.isPrimitiveOrWrapNumber(type)) {
//                            Class<?> primitiveClass = ReflectUtil.toPrimitiveClass(type);
//                            typeDeclare = primitiveClass.getSimpleName();
//                        } else if (Number.class.isAssignableFrom(type)) {
//                            typeDeclare = "double";
//                        }

                        declare = "Object" + " " + varName + " = "
                                + old.source(ctx, node) + ";   //" + text;
                        StringKeyValue kv = new StringKeyValue(varName, declare);
                        localvars.put(text, kv);
                        return varName;
                    }

                    @Override
                    public String sourceJs(FelContext ctx, FelNode node) throws Exception {
                        String text = node.getText();
                        if (localvars.containsKey(text)) {
                            StringKeyValue kv = localvars.get(text);
                            return kv.key;
                        }
                        String varName = text;
//                        Class<?> type = this.returnType(ctx, node);
                        String declare = "";
//                        String typeDeclare = type.getCanonicalName();
//                        if (ReflectUtil.isPrimitiveOrWrapNumber(type)) {
//                            Class<?> primitiveClass = ReflectUtil.toPrimitiveClass(type);
//                            typeDeclare = primitiveClass.getSimpleName();
//                        } else if (Number.class.isAssignableFrom(type)) {
//                            typeDeclare = "double";
//                        }

                        declare = "Object" + " " + varName + " = "
                                + old.source(ctx, node) + ";   //" + text;
                        StringKeyValue kv = new StringKeyValue(varName, declare);
                        localvars.put(text, kv);
                        return varName;
                    }

                    @Override
                    public Class<?> returnType(FelContext ctx, FelNode n) throws Exception {
                        return old.returnType(ctx, n);
                    }
                };
            }
        };
        return optimizVars;
    }

    @Override
    public void addOpti(Optimizer opti) {
        this.opt.add(opti);
    }

}

