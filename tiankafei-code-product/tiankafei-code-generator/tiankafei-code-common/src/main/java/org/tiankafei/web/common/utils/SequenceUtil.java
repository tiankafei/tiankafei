package org.tiankafei.web.common.utils;

import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class SequenceUtil {

    private static IdentifierGenerator generator = new DefaultIdentifierGenerator();

    public static String generatorStrId() {
        return generator.nextId(null).toString();
    }

}
