package cn.tiankafei.aviator.extend.util;

import cn.tiankafei.aviator.extend.exception.AviatorException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
public abstract class AviatorExtendUtil {

    /**
     * 校验错误信息
     * @param errorInfo
     * @param funName
     */
    public static void checkError(StringBuilder errorInfo, String funName){
        if (StringUtils.isNotBlank(errorInfo.toString())) {
            errorInfo.delete(0, 1);
            String error = funName + "函数的" + errorInfo.toString() + "参数类型不合法，请确认！";
            log.error(error);
            throw new AviatorException(error);
        }
    }

}
