package org.tiankafei.nexus.model;

import lombok.Data;
import org.apache.commons.compress.utils.Lists;

import java.io.Serializable;
import java.util.List;

@Data
public class DeleteParamDTO implements Serializable {

    private String action = "coreui_Component";

    private String method = "deleteComponent";

    private String type = "rpc";

    private Integer tid;

    private List<String> data = Lists.newArrayList();

}
