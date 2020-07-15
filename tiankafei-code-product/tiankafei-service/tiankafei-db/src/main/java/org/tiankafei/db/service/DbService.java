package org.tiankafei.db.service;

/**
 * @author tiankafei
 * @since 1.0
 **/
public interface DbService {

    /**
     * 获取数据库的名称
     *
     * @return
     */
    String getTableSchema();

    /**
     * 检查物理表是否存在
     *
     * @param tableName
     * @return
     */
    boolean checkTableExists(String tableName);

    /**
     * 删除物理表
     *
     * @param tableName
     * @return
     */
    boolean dropTable(String tableName);

    /**
     * 根据模版表创建物理表
     *
     * @param templateTable 模版表名
     * @param tableName     要创建的表名
     * @param name          表中文名
     * @return
     */
    boolean createTable(String templateTable, String tableName, String name);

}
