package org.tiankafei.aviator.util;

import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.aviator.core.IFunManager;
import org.tiankafei.common.util.JdkSpiUtil;

/**
 * @author tiankafei
 */
public class AviatorUtil {

    /**
     * 初始化函数
     */
    public static void initFun() {
        Iterator<IFunManager> providers = JdkSpiUtil.service(IFunManager.class);
        IFunManager funManager = providers.next();
        funManager.initialize();
    }

    /**
     * 是字符串
     *
     * @param object
     * @return
     */
    public static Boolean isString(Object object) {
        Boolean flag = Boolean.FALSE;
        if (object instanceof CharSequence) {
            flag = Boolean.TRUE;
        } else if (object instanceof Character) {
            flag = Boolean.TRUE;
        }
        return flag;
    }

    /**
     * 字符串是否是数字
     *
     * @param object
     * @return
     */
    public static Boolean isNumerics(Object object) {
        if (object == null || StringUtils.isBlank(object.toString())) {
            return Boolean.FALSE;
        }
        Boolean strResult = object.toString().matches("^[\\+\\-]?(0|[0-9]\\d*|[1-9]\\d*\\.\\d+|0\\.\\d+)");
        return strResult;
    }

}
