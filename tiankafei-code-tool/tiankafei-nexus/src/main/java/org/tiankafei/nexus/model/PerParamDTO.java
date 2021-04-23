package org.tiankafei.nexus.model;

import lombok.Data;
import org.apache.commons.compress.utils.Lists;

import java.io.Serializable;
import java.util.List;

@Data
public class PerParamDTO implements Serializable {
    
    private String url;

    private String node;

    private Integer tid;

    private Integer maxCount = 6;

    private String cookie;

    private List<String> nodeList = Lists.newArrayList();

    public PerParamDTO(String url, String node, Integer tid, String cookie) {
        this.url = url;
        this.node = node;
        this.tid = tid;
        this.cookie = cookie;
    }
}
