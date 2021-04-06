package org.tiankafei.aviator.extend.function;

import com.googlecode.aviator.lexer.token.OperatorType;
import com.googlecode.aviator.runtime.type.AviatorFunction;
import com.googlecode.aviator.runtime.type.AviatorJavaType;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.tiankafei.aviator.extend.constant.FunctionConstants;
import org.tiankafei.aviator.extend.exception.AviatorException;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
public class AviatorFunctionProxy implements AviatorFunction {

    protected AviatorFunction function;

    protected boolean proxyFlag;

    public AviatorFunctionProxy(AviatorFunction function, boolean proxyFlag) {
        this.function = function;
        this.proxyFlag = proxyFlag;
    }

    @Override
    public String getName() {
        return function.getName();
    }

    @Override
    public AviatorObject call(Map<String, Object> env) {
        AviatorObject aviatorObject = process(env, Arrays.asList());
        if (aviatorObject != null) {
            return aviatorObject;
        }
        return function.call(env);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1));
        if (aviatorObject != null) {
            return aviatorObject;
        }
        return function.call(env, arg1);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2));
        if (aviatorObject != null) {
            return aviatorObject;
        }
        return function.call(env, arg1, arg2);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3));
        if (aviatorObject != null) {
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4));
        if (aviatorObject != null) {
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5));
        if (aviatorObject != null) {
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6));
        if (aviatorObject != null) {
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7));
        if (aviatorObject != null) {
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7, AviatorObject arg8) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8));
        if (aviatorObject != null) {
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7, AviatorObject arg8, AviatorObject arg9) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9));
        if (aviatorObject != null) {
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7, AviatorObject arg8, AviatorObject arg9, AviatorObject arg10) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10));
        if (aviatorObject != null) {
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7, AviatorObject arg8, AviatorObject arg9, AviatorObject arg10, AviatorObject arg11) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11));
        if (aviatorObject != null) {
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7, AviatorObject arg8, AviatorObject arg9, AviatorObject arg10, AviatorObject arg11, AviatorObject arg12) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12));
        if (aviatorObject != null) {
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7, AviatorObject arg8, AviatorObject arg9, AviatorObject arg10, AviatorObject arg11, AviatorObject arg12, AviatorObject arg13) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13));
        if (aviatorObject != null) {
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7, AviatorObject arg8, AviatorObject arg9, AviatorObject arg10, AviatorObject arg11, AviatorObject arg12, AviatorObject arg13, AviatorObject arg14) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14));
        if (aviatorObject != null) {
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7, AviatorObject arg8, AviatorObject arg9, AviatorObject arg10, AviatorObject arg11, AviatorObject arg12, AviatorObject arg13, AviatorObject arg14, AviatorObject arg15) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15));
        if (aviatorObject != null) {
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7, AviatorObject arg8, AviatorObject arg9, AviatorObject arg10, AviatorObject arg11, AviatorObject arg12, AviatorObject arg13, AviatorObject arg14, AviatorObject arg15, AviatorObject arg16) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16));
        if (aviatorObject != null) {
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7, AviatorObject arg8, AviatorObject arg9, AviatorObject arg10, AviatorObject arg11, AviatorObject arg12, AviatorObject arg13, AviatorObject arg14, AviatorObject arg15, AviatorObject arg16, AviatorObject arg17) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17));
        if (aviatorObject != null) {
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7, AviatorObject arg8, AviatorObject arg9, AviatorObject arg10, AviatorObject arg11, AviatorObject arg12, AviatorObject arg13, AviatorObject arg14, AviatorObject arg15, AviatorObject arg16, AviatorObject arg17, AviatorObject arg18) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18));
        if (aviatorObject != null) {
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7, AviatorObject arg8, AviatorObject arg9, AviatorObject arg10, AviatorObject arg11, AviatorObject arg12, AviatorObject arg13, AviatorObject arg14, AviatorObject arg15, AviatorObject arg16, AviatorObject arg17, AviatorObject arg18, AviatorObject arg19) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19));
        if (aviatorObject != null) {
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7, AviatorObject arg8, AviatorObject arg9, AviatorObject arg10, AviatorObject arg11, AviatorObject arg12, AviatorObject arg13, AviatorObject arg14, AviatorObject arg15, AviatorObject arg16, AviatorObject arg17, AviatorObject arg18, AviatorObject arg19, AviatorObject arg20) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20));
        if (aviatorObject != null) {
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7, AviatorObject arg8, AviatorObject arg9, AviatorObject arg10, AviatorObject arg11, AviatorObject arg12, AviatorObject arg13, AviatorObject arg14, AviatorObject arg15, AviatorObject arg16, AviatorObject arg17, AviatorObject arg18, AviatorObject arg19, AviatorObject arg20, AviatorObject... args) {
        List<AviatorObject> aviatorList = Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20);
        Stream.of(args).forEachOrdered(aviatorObject -> {
            aviatorList.add(aviatorObject);
        });
        AviatorObject aviatorObject = process(env, aviatorList);
        if (aviatorObject != null) {
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, args);
    }

    @Override
    public void run() {
        function.run();
    }

    @Override
    public AviatorObject call() throws Exception {
        return function.call();
    }

    /**
     * 执行处理
     *
     * @param env
     * @param aviatorList
     * @return
     */
    protected AviatorObject process(Map<String, Object> env, List<AviatorObject> aviatorList) {
        //验证是否编译js
        boolean compileJsFlag = checkIsCompileJs(env);
        if (!compileJsFlag) {
            return null;
        }
        if (!proxyFlag) {
            throw new AviatorException(getName() + "函数不支持js的编译，请确认！");
        }
        //组装参数集合
        List<Object> paramList = packageParam(env, aviatorList);
        //拼接js代码
        return compileJs(paramList);
    }

    /**
     * 验证是否编译js
     *
     * @param env
     * @return
     */
    protected boolean checkIsCompileJs(Map<String, Object> env) {
        boolean compileJsFlag = false;
        if (env.containsKey(FunctionConstants.AVIATOR_COMPILE_JS)) {
            Object object = env.get(FunctionConstants.AVIATOR_COMPILE_JS);
            if (object != null) {
                if (object instanceof Boolean) {
                    compileJsFlag = Boolean.valueOf(object.toString());
                } else {
                    throw new AviatorException("if nedd compie js, must be need AVIATOR_COMPILE_JS param, and must be boolean type");
                }
            }
        }
        return compileJsFlag;
    }

    /**
     * 拼接js代码
     *
     * @param paramList
     * @return
     */
    protected AviatorObject compileJs(List<Object> paramList) {
        StringBuilder stringBuilder = new StringBuilder();

        if (OperatorType.ADD.token.equals(getName())) {
            appendTwoParam(stringBuilder, "RULE_ADD", paramList);
        } else if (OperatorType.SUB.token.equals(getName())) {
            appendTwoParam(stringBuilder, "RULE_SUB", paramList);
        } else if (OperatorType.MULT.token.equals(getName())) {
            appendTwoParam(stringBuilder, "RULE_MUL", paramList);
        } else if (OperatorType.DIV.token.equals(getName())) {
            appendTwoParam(stringBuilder, "RULE_DIV", paramList);
        } else if (OperatorType.MOD.token.equals(getName())) {
            appendTwoParam(stringBuilder, "RULE_MOD", paramList);
        } else if (OperatorType.LT.token.equals(getName())) {
            appendTwoParam(stringBuilder, "RULE_LESS", paramList);
        } else if (OperatorType.LE.token.equals(getName())) {
            appendTwoParam(stringBuilder, "RULE_LESS_THAN", paramList);
        } else if (OperatorType.GT.token.equals(getName())) {
            appendTwoParam(stringBuilder, "RULE_GREATER", paramList);
        } else if (OperatorType.GE.token.equals(getName())) {
            appendTwoParam(stringBuilder, "RULE_GREATER_THAN", paramList);
        } else if (OperatorType.AND.token.equals(getName())) {
            appendTwoParam(stringBuilder, "RULE_AND", paramList);
        } else if (OperatorType.OR.token.equals(getName())) {
            appendTwoParam(stringBuilder, "RULE_OR", paramList);
        } else if (OperatorType.EQ.token.equals(getName())) {
            appendTwoParam(stringBuilder, "RULE_EQUALS", paramList);
        } else if (OperatorType.NEQ.token.equals(getName())) {
            appendTwoParam(stringBuilder, "RULE_NOT_EQUALS", paramList);
        } else if (OperatorType.NOT.token.equals(getName())) {
            appendOneParam(stringBuilder, "RULE_NOT", paramList);
        } else {
            if (CollectionUtils.isNotEmpty(paramList)) {
                stringBuilder.append("RULE_").append(getName().toUpperCase()).append("(");
                for (int index = 0, length = paramList.size(); index < length; index++) {
                    stringBuilder.append(paramList.get(index));
                    if (index != length - 1) {
                        stringBuilder.append(",");
                    }
                }
                stringBuilder.append(")");
            } else {
                stringBuilder.append("RULE_").append(getName().toUpperCase()).append("()");
            }
        }
        return new AviatorString(stringBuilder.toString());
    }

    protected void appendTwoParam(StringBuilder stringBuilder, String funName, List<Object> paramList) {
        stringBuilder.append(funName).append("(").append(paramList.get(0)).append(",").append(paramList.get(1)).append(")");
    }

    protected void appendOneParam(StringBuilder stringBuilder, String funName, List<Object> paramList) {
        stringBuilder.append(funName).append("(").append(paramList.get(0)).append(")");
    }

    /**
     * 组装参数集合
     *
     * @param env
     * @param aviatorList
     * @return
     */
    protected List<Object> packageParam(Map<String, Object> env, List<AviatorObject> aviatorList) {
        List<String> aliasList = null;
        if (env.containsKey(FunctionConstants.AVIATOR_FUNCTION_ALIAS)) {
            aliasList = (List<String>) env.get(FunctionConstants.AVIATOR_FUNCTION_ALIAS);
        } else {
            aliasList = new ArrayList<>();
            env.put(FunctionConstants.AVIATOR_FUNCTION_ALIAS, aliasList);
        }

        List<Object> paramList = new ArrayList<>();
        for (int index = 0, length = aviatorList.size(); index < length; index++) {
            AviatorObject aviatorObject = aviatorList.get(index);
            if (aviatorObject instanceof AviatorJavaType) {
                AviatorJavaType aviatorJavaType = (AviatorJavaType) aviatorObject;
                String name = aviatorJavaType.getName();
                paramList.add(name);
                if (!aliasList.contains(name)) {
                    aliasList.add(aviatorJavaType.getName());
                }
            } else if (aviatorObject instanceof AviatorString) {
                String value = aviatorObject.getValue(env).toString();
                if (value.contains("RULE_")
                        || value.contains(OperatorType.ADD.token)
                        || value.contains(OperatorType.SUB.token)
                        || value.contains(OperatorType.MULT.token)
                        || value.contains(OperatorType.DIV.token)
                        || value.contains(OperatorType.MOD.token)
                        || value.contains(OperatorType.LT.token)
                        || value.contains(OperatorType.LE.token)
                        || value.contains(OperatorType.GT.token)
                        || value.contains(OperatorType.GE.token)
                        || value.contains(OperatorType.AND.token)
                        || value.contains(OperatorType.OR.token)
                        || value.contains(OperatorType.EQ.token)
                        || value.contains(OperatorType.NEQ.token)
                        || value.contains(OperatorType.NOT.token)) {
                    paramList.add(value);
                } else {
                    paramList.add("\"" + value + "\"");
                }
            } else {
                Object value = aviatorObject.getValue(env);
                paramList.add(value);
            }
        }
        return paramList;
    }

}
