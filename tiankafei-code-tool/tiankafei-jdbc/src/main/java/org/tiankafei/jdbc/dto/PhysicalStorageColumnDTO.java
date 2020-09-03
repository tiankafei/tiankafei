package org.tiankafei.jdbc.dto;

import java.io.Serializable;
import java.util.List;
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
public class PhysicalStorageColumnDTO implements Serializable {

    private static final long serialVersionUID = 8132037781693931478L;

    /**
     * 数据库名称
     */
    private String dbName;

    /**
     * 物理表名
     */
    private String tableName;

    /**
     * 字段名
     */
    private String columnName;

    /**
     * 字段类型(char 10;varchar2 20;number 40;timestamp 50;clob,text 60;blob 70)
     */
    private Integer columnType;

    /**
     * 字段类型名称
     */
    private String columnTypeName;

    /**
     * 字段中文名
     */
    private String columnChineseName;

    /**
     * 字段最大长度
     */
    private Integer columnMaxLength;

    /**
     * 字段最小长度
     */
    private Integer columnMinLength;

    /**
     * 字段的数据精度
     */
    private Integer columnDataPrecision;

    /**
     * 是否为空
     */
    private Boolean nullFlag;

    /**
     * 是否主键
     */
    private Boolean primaryKeyFlag;

    /**
     * 默认值
     */
    private String defaultValue;

    /**
     * 字段值
     */
    private Object columnValue;

    /**
     * 列是否被编辑的标识
     */
    private Boolean columnEditableFlag;

    /**
     * 允许值域
     */
    private List<Object> allowRangeList;

    /**
     * 构造物理存储字段对象
     */
    public PhysicalStorageColumnDTO() {
        columnDataPrecision = 0;
        nullFlag = Boolean.TRUE;
        primaryKeyFlag = Boolean.FALSE;
    }

    /**
     * 构造物理存储字段对象
     *
     * @param dbName     数据库名称
     * @param tableName  物理表名称
     * @param columnName 字段名
     */
    public PhysicalStorageColumnDTO(String dbName, String tableName, String columnName) {
        this();
        this.dbName = dbName;
        this.tableName = tableName;
        this.columnName = columnName;
    }

}
