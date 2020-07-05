package org.tiankafei.gateway.vo;

import lombok.Data;

@Data
public class GatewayRouteVo {

    private String serviceName;

    private String pathPrefix;

    private int stripPrefix;

}
