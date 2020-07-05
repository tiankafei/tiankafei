package org.tiankafei.web.common.constants;

/**
 * @author tiankafei
 * @since 1.0
 **/
public interface GatewayConstants {

    /**
     * 服务的参数名
     */
    String SERVICE_PARAM_NAME = "SERVICE_PARAM_NAME";

    /**
     * 过滤成功或者失败的标识
     */
    String FILTER_FLAG = "FILTER_FLAG";

    /**
     * token参数名称
     */
    String TOKEN_PARAM_NAME = "token";

    /**
     * 要添加的header信息的参数名称
     */
    String ADD_HREADER_PARAM_NAME = "TestHeaderInfo";

    /**
     * 必须第一个执行过滤
     */
    int FIRST_FILTER_ORDER = -9999;

    /**
     * 限流过滤器的执行顺序
     */
    int LIMITED_FILTER_ORDER = 0;

    /**
     * 鉴权过滤器的执行顺序
     */
    int AUTH_FILTER_ORDER = 10;

    /**
     * token过滤器的执行顺序
     */
    int TOKEN_FILTER_ORDER = 11;

    /**
     * 鉴权过滤器的执行顺序
     */
    int ADD_HEADER_FILTER_ORDER = 20;

}
