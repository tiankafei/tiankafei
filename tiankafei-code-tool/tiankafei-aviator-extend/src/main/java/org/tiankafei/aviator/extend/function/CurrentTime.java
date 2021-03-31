package org.tiankafei.aviator.extend.function;

import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.tiankafei.aviator.extend.constant.FunctionConstants;

/**
 * @Author 魏双双
 * @Date 2020/6/1
 * @Version V1.0
 **/
public class CurrentTime extends OneParamFunction {
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

    @Override
    public String getName() {
        return FunctionConstants.CURRENTTIME;
    }
}
