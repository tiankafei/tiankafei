package com.googlecode.aviator.script;

import com.googlecode.aviator.AviatorEvaluator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author libinsong1204@gmail.com
 * @author dennis
 */
public class AviatorScriptEngineFactory implements ScriptEngineFactory {

    private static final List<String> EXTENSIONS =
            Collections.unmodifiableList(Arrays.asList(new String[]{}));
    private static final List<String> MIME_TYPES =
            Collections.unmodifiableList(Arrays.asList(new String[]{"text/aviator"}));
    private static final List<String> NAMES =
            Collections.unmodifiableList(Arrays.asList(new String[]{"Aviator", "aviator"}));

    private static final Map<String, String> PARAMETER_MAP = new HashMap<String, String>();

    static {
        PARAMETER_MAP.put(ScriptEngine.ENGINE, "Aviator");
        PARAMETER_MAP.put(ScriptEngine.ENGINE_VERSION, AviatorEvaluator.VERSION);
        PARAMETER_MAP.put(ScriptEngine.LANGUAGE, "A high performance expression evaluator for java");
        PARAMETER_MAP.put(ScriptEngine.LANGUAGE_VERSION, AviatorEvaluator.VERSION);
    }


    @Override
    public String getEngineName() {
        return PARAMETER_MAP.get(ScriptEngine.ENGINE);
    }


    @Override
    public String getEngineVersion() {
        return PARAMETER_MAP.get(ScriptEngine.ENGINE_VERSION);
    }


    @Override
    public List<String> getExtensions() {
        return EXTENSIONS;
    }


    @Override
    public String getLanguageName() {
        return PARAMETER_MAP.get(ScriptEngine.LANGUAGE);
    }


    @Override
    public String getLanguageVersion() {
        return PARAMETER_MAP.get(ScriptEngine.LANGUAGE_VERSION);
    }


    @Override
    public String getMethodCallSyntax(String obj, String m, String... args) {
        StringBuilder sb = new StringBuilder(m);
        sb.append("(").append(obj);
        if (args != null) {
            for (String s : args) {
                sb.append(",").append(s);
            }
        }
        sb.append(")");
        return sb.toString();

    }


    @Override
    public List<String> getMimeTypes() {
        return MIME_TYPES;
    }


    @Override
    public List<String> getNames() {
        return NAMES;
    }


    @Override
    public String getOutputStatement(String toDisplay) {
        return "print(+" + toDisplay + ")";
    }


    @Override
    public Object getParameter(String key) {
        return PARAMETER_MAP.get(key);
    }


    @Override
    public String getProgram(String... statements) {
        return null;
    }


    @Override
    public ScriptEngine getScriptEngine() {
        return new AviatorScriptEngine(this);
    }

}
