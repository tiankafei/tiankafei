package org.tiankafei.nexus.model;

import lombok.Data;
import org.apache.commons.compress.utils.Lists;

import java.io.Serializable;
import java.util.List;

@Data
public class RootParamDTO implements Serializable {

    private String action = "coreui_Browse";

    private String method = "read";

    private String type = "rpc";

    private Integer tid;

    private List<ParamRepositoryNameDTO> data = Lists.newArrayList();

}
