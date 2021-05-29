package org.tiankafei.aviator.runtime.function.one;

import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.tiankafei.aviator.constant.AviatorConstants;

/**
 * 应用服务器当前时间
 *
 * @author tiankafei
 */
public class CurrentTime extends OneParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_CURRENT_TIME;
    }

    @Override
    protected AviatorObject apply(Object object) {
        if (object != null) {
            String param = object.toString();
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(param);
            return new AviatorString(localDateTime.format(formatter));
        }
        return AviatorNil.NIL;
    }

}
