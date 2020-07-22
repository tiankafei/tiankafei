package org.tiankafei.base.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tiankafei
 * @since 1.0
 */
@Slf4j
public class JdkVersionUtil {

    public static boolean isJdk8(){
        String property = System.getProperty("java.version");
        log.info("jdk版本：{}", property);
        return property.startsWith("1.8");
    }

    public static boolean isJdk11(){
        String property = System.getProperty("java.version");
        log.info("jdk版本：{}", property);
        return property.startsWith("11");
    }

}
