package cn.tiankafei.aviator.extend.function;

import com.googlecode.aviator.runtime.type.AviatorFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;

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

        return null;
    }

}
