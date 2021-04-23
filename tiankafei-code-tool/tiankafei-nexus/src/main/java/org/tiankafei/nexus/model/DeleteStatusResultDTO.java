package org.tiankafei.nexus.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeleteStatusResultDTO implements Serializable {

    private String message;

    private boolean success;

}
