package org.tiankafei.gateway.vo;

import lombok.Data;

/**
 *
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
public class GatewayRouteVo {

    private String serviceName;

    private String pathPrefix;

    private int stripPrefix;

}
