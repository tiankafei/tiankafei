package org.tiankafei.nexus.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ParamRepositoryNameDTO implements Serializable {

    private String repositoryName = "maven-snapshots";

    private String node;

}
