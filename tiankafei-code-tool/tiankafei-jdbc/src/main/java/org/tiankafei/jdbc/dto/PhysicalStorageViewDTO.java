package org.tiankafei.jdbc.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 物理存储视图对象
 *
 * @Author tiankafei
 * @Date 2019/10/22
 * @Version V1.0
 **/
@Data
@Accessors(chain = true)
public class PhysicalStorageViewDTO implements Serializable {

    private static final long serialVersionUID = 2901952536463533473L;

    /**
     * 数据库名称
     */
    private String dbServerName;

    /**
     * 视图名
     */
    private String viewName;

    /**
     * 视图描述
     */
    private String viewDescription;

}
