package org.tiankafei.nexus.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RootResultStatusDTO implements Serializable {

    private boolean success;

    private List<ResultRepositoryNameDTO> data;

}
