package org.tiankafei.collection.param;

import lombok.Data;

import java.io.Serializable;

/**
 * 组件类型对象
 */
@Data
public class ComponentTypeVo implements Serializable {

    private Integer code;

    private String name;

}
