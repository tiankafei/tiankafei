package org.tiankafei.nexus.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeleteResultDTO implements Serializable {

    private Integer tid;

    private String action;

    private String method;

    private String type;

    private DeleteStatusResultDTO result;

}
