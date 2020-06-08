package cn.tiankafei.aviator.extend.function;

import cn.tiankafei.aviator.extend.constant.FunctionConstants;
import cn.tiankafei.aviator.extend.exception.AviatorException;
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
import org.apache.commons.collections.CollectionUtils;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
public class AviatorFunctionProxy implements AviatorFunction {

    private AviatorFunction function;

    public AviatorFunctionProxy(AviatorFunction function){
        this.function = function;
    }

    @Override
    public String getName() {
        return function.getName();
    }

    @Override
    public AviatorObject call(Map<String, Object> env) {
        AviatorObject aviatorObject = process(env, Arrays.asList());
        if(aviatorObject != null){
            return aviatorObject;
        }
        return function.call(env);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1));
        if(aviatorObject != null){
            return aviatorObject;
        }
        return function.call(env, arg1);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2));
        if(aviatorObject != null){
            return aviatorObject;
        }
        return function.call(env, arg1, arg2);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3));
        if(aviatorObject != null){
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4));
        if(aviatorObject != null){
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5));
        if(aviatorObject != null){
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6));
        if(aviatorObject != null){
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7));
        if(aviatorObject != null){
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7, AviatorObject arg8) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8));
        if(aviatorObject != null){
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7, AviatorObject arg8, AviatorObject arg9) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9));
        if(aviatorObject != null){
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7, AviatorObject arg8, AviatorObject arg9, AviatorObject arg10) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10));
        if(aviatorObject != null){
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7, AviatorObject arg8, AviatorObject arg9, AviatorObject arg10, AviatorObject arg11) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11));
        if(aviatorObject != null){
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7, AviatorObject arg8, AviatorObject arg9, AviatorObject arg10, AviatorObject arg11, AviatorObject arg12) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12));
        if(aviatorObject != null){
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7, AviatorObject arg8, AviatorObject arg9, AviatorObject arg10, AviatorObject arg11, AviatorObject arg12, AviatorObject arg13) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13));
        if(aviatorObject != null){
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7, AviatorObject arg8, AviatorObject arg9, AviatorObject arg10, AviatorObject arg11, AviatorObject arg12, AviatorObject arg13, AviatorObject arg14) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14));
        if(aviatorObject != null){
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7, AviatorObject arg8, AviatorObject arg9, AviatorObject arg10, AviatorObject arg11, AviatorObject arg12, AviatorObject arg13, AviatorObject arg14, AviatorObject arg15) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15));
        if(aviatorObject != null){
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7, AviatorObject arg8, AviatorObject arg9, AviatorObject arg10, AviatorObject arg11, AviatorObject arg12, AviatorObject arg13, AviatorObject arg14, AviatorObject arg15, AviatorObject arg16) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16));
        if(aviatorObject != null){
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7, AviatorObject arg8, AviatorObject arg9, AviatorObject arg10, AviatorObject arg11, AviatorObject arg12, AviatorObject arg13, AviatorObject arg14, AviatorObject arg15, AviatorObject arg16, AviatorObject arg17) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17));
        if(aviatorObject != null){
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7, AviatorObject arg8, AviatorObject arg9, AviatorObject arg10, AviatorObject arg11, AviatorObject arg12, AviatorObject arg13, AviatorObject arg14, AviatorObject arg15, AviatorObject arg16, AviatorObject arg17, AviatorObject arg18) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18));
        if(aviatorObject != null){
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7, AviatorObject arg8, AviatorObject arg9, AviatorObject arg10, AviatorObject arg11, AviatorObject arg12, AviatorObject arg13, AviatorObject arg14, AviatorObject arg15, AviatorObject arg16, AviatorObject arg17, AviatorObject arg18, AviatorObject arg19) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19));
        if(aviatorObject != null){
            return aviatorObject;
        }
        return function.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4, AviatorObject arg5, AviatorObject arg6, AviatorObject arg7, AviatorObject arg8, AviatorObject arg9, AviatorObject arg10, AviatorObject arg11, AviatorObject arg12, AviatorObject arg13, AviatorObject arg14, AviatorObject arg15, AviatorObject arg16, AviatorObject arg17, AviatorObject arg18, AviatorObject arg19, AviatorObject arg20) {
        AviatorObject aviatorObject = process(env, Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20));
        if(aviatorObject != null){
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
        if(aviatorObject != null){
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

    private AviatorObject process(Map<String, Object> env, List<AviatorObject> aviatorList){
        boolean compileJsFlag = false;
        if(env.containsKey(FunctionConstants.AVIATOR_COMPILE_JS)){
            Object object = env.get(FunctionConstants.AVIATOR_COMPILE_JS);
            if(object != null){
                if(object instanceof Boolean){
                    compileJsFlag = Boolean.valueOf(object.toString());
                }else{
                    throw new AviatorException("if nedd compie js, must be need AVIATOR_COMPILE_JS param, and must be boolean type");
                }
            }
        }
        if(compileJsFlag){
            List<String> aliasList = null;
            if(env.containsKey(FunctionConstants.AVIATOR_FUNCTION_ALIAS)){
                aliasList = (List<String>) env.get(FunctionConstants.AVIATOR_FUNCTION_ALIAS);
            }else{
                aliasList = new ArrayList<>();
                env.put(FunctionConstants.AVIATOR_FUNCTION_ALIAS, aliasList);
            }

            List<Object> paramList = new ArrayList<>();
            for (int index = 0, length = aviatorList.size(); index < length; index++) {
                AviatorObject aviatorObject = aviatorList.get(index);
                if(aviatorObject instanceof AviatorJavaType){
                    AviatorJavaType aviatorJavaType = (AviatorJavaType) aviatorObject;
                    paramList.add(aviatorJavaType.getName());
                    aliasList.add(aviatorJavaType.getName());
                }else if(aviatorObject instanceof AviatorString){
                    String value = aviatorObject.getValue(env).toString();
                    if(value.contains("RULE_")
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
                            || value.contains(OperatorType.NOT.token)){
                        paramList.add(value);
                    }else{
                        paramList.add("\"" + value + "\"");
                    }
                }else{
                    Object value = aviatorObject.getValue(env);
                    paramList.add(value);
                }
            }

            StringBuilder stringBuilder = new StringBuilder();
            if(OperatorType.ADD.token.equals(getName())
                    || OperatorType.SUB.token.equals(getName())
                    || OperatorType.MULT.token.equals(getName())
                    || OperatorType.DIV.token.equals(getName())
                    || OperatorType.MOD.token.equals(getName())
                    || OperatorType.LT.token.equals(getName())
                    || OperatorType.LE.token.equals(getName())
                    || OperatorType.GT.token.equals(getName())
                    || OperatorType.GE.token.equals(getName())
                    || OperatorType.AND.token.equals(getName())
                    || OperatorType.OR.token.equals(getName())
                    || OperatorType.EQ.token.equals(getName())
                    || OperatorType.NEQ.token.equals(getName())){
                stringBuilder.append(paramList.get(0)).append(getName()).append(paramList.get(1));
            }else if(OperatorType.NOT.token.equals(getName())){
                stringBuilder.append("RULE_NOT").append("(").append(paramList.get(0)).append(")");
            }else{
                if(CollectionUtils.isNotEmpty(paramList)){
                    stringBuilder.append("RULE_").append(getName().toUpperCase()).append("(");
                    for (int index = 0, length = paramList.size(); index < length; index++) {
                        stringBuilder.append(paramList.get(index));
                        if(index != length - 1){
                            stringBuilder.append(",");
                        }
                    }
                    stringBuilder.append(")");
                }else{
                    stringBuilder.append("RULE_").append(getName().toUpperCase()).append("()");
                }
            }
            return new AviatorString(stringBuilder.toString());
        }
        return null;
    }

}
