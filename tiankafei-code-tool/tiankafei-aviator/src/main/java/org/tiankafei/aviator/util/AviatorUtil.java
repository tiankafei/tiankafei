package org.tiankafei.aviator.util;

import java.util.Iterator;
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
    
}
