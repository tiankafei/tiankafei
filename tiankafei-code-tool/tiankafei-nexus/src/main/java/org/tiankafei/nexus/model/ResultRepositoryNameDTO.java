package org.tiankafei.nexus.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultRepositoryNameDTO implements Serializable {

    private String id;

    private String text;

    private String type;

    private boolean leaf;

    private String componentId;

    private String assetId;

}
