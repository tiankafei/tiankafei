package org.tiankafei.ui.control.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 物理存储字段对象
 *
 * @Author tiankafei
 * @Date 2019/10/22
 * @Version V1.0
 **/
@Data
@Accessors(chain = true)
public class ConditionColumnDTO implements Serializable {

    private static final long serialVersionUID = 8132037781693931478L;

    /**
     * 物理表名
     */
    private String tableName;

    /**
     * 字段名
     */
    private String columnName;

    /**
     * 字段中文名
     */
    private String columnChineseName;

    /**
     * 字段值
     */
    private Object columnValue;

    @Override
    public String toString() {
        return this.getColumnChineseName();
    }
}
