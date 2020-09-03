package org.tiankafei.jdbc.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 物理存储索引对象
 *
 * @Author tiankafei
 * @Date 2019/10/22
 * @Version V1.0
 **/
@Data
@Accessors(chain = true)
public class PhysicalStorageIndexDTO implements Serializable {

    private static final long serialVersionUID = 4968310165595139056L;

    /**
     * 数据库名称
     */
    private String dbServerName;

    /**
     * 索引名
     */
    private String indexName;

    /**
     * 索引描述
     */
    private String indexDescription;

}
