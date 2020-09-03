package org.tiankafei.jdbc.dto;

import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 物理存储对象
 *
 * @Author tiankafei
 * @Date 2019/10/22
 * @Version V1.0
 **/
@Data
@Accessors(chain = true)
public class PhysicalStorageTableDTO implements Serializable {

    private static final long serialVersionUID = -6310560019580174088L;

    /**
     * 数据库名称
     */
    private String dbName;

    /**
     * 物理表名
     */
    private String tableName;

    /**
     * 物理表名描述
     */
    private String tableDescription;

    /**
     * 物理表存在则删除的标识
     */
    private Boolean tableExistsDropFlag;

    /**
     * 物理表存储类型代码
     */
    private Integer tableType;

    /**
     * 物理表存储类型名称
     */
    private String tableTypeName;

    /**
     * 主键字符串
     */
    private String primaryKey;

    /**
     * 物理存储字段集合
     */
    private List<PhysicalStorageColumnDTO> physicalStorageColumnList;

    /**
     * 构造物理存储对象
     */
    public PhysicalStorageTableDTO() {

    }

    /**
     * 构造物理存储对象
     *
     * @param dbName    数据库名称
     * @param tableName 物理表名称
     */
    public PhysicalStorageTableDTO(String dbName, String tableName) {
        this.dbName = dbName;
        this.tableName = tableName;
        physicalStorageColumnList = Lists.newArrayList();
    }

    /**
     * @Description: 设置数据库名称
     * @Param: [dbName]
     * @Return: void
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    public void setDbName(String dbName) {
        this.dbName = dbName;
        if (CollectionUtils.isNotEmpty(physicalStorageColumnList)) {
            for (int index = 0, length = physicalStorageColumnList.size(); index < length; index++) {
                physicalStorageColumnList.get(index).setDbName(dbName);
            }
        }
    }

    /**
     * @Description: 获取主键字符串
     * @Param: []
     * @Return: java.lang.String
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    public String getPrimaryKey() {
        if (StringUtils.isEmpty(primaryKey) && CollectionUtils.isNotEmpty(physicalStorageColumnList)) {
            StringBuffer primaryKeyBuffer = new StringBuffer();
            for (int index = 0, length = physicalStorageColumnList.size(); index < length; index++) {
                PhysicalStorageColumnDTO physicalStorageColumnDTO = physicalStorageColumnList.get(index);
                if (physicalStorageColumnDTO.getPrimaryKeyFlag()) {
                    primaryKeyBuffer.append(",").append(physicalStorageColumnDTO.getColumnName());
                }
            }
            if (primaryKeyBuffer.length() > 0) {
                primaryKeyBuffer.delete(0, 1);
            }
            this.primaryKey = primaryKeyBuffer.toString();
        }
        return primaryKey;
    }

}
