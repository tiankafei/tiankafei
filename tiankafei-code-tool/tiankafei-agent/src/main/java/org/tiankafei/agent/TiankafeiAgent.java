package org.tiankafei.agent;

import java.lang.instrument.Instrumentation;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class TiankafeiAgent {

    private static Instrumentation inst;

    public static void premain(String agentArgs, Instrumentation _inst) {
        inst = _inst;
    }

    public static long sizeOf(Object o) {
        return inst.getObjectSize(o);
    }

}
