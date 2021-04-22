package org.tiankafei.nexus.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class RootResultDTO implements Serializable {

    private String action = "coreui_Browse";

    private String method = "read";

    private String type = "rpc";

    private Integer tid;

    private RootResultStatusDTO result;

}
