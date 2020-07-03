package org.tiankafei.web.common.constants;

/**
 * @author tiankafei
 * @since 1.0
 **/
public interface GatewayConstants {

    /**
     * 不必要进行鉴权的url配置标识
     */
    String EXCLUSTIONS_URL_FLAG = "EXCLUSTIONS_URL_FLAG";

    /**
     * 必须第一个执行过滤
     */
    int FIRST_FILTER_ORDER = 0;

    /**
     * 鉴权过滤器的执行顺序
     */
    int AUTH_FILTER_ORDER = 1;

}
