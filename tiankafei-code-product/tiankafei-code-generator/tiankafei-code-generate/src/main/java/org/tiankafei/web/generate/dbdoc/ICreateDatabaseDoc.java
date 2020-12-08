package org.tiankafei.web.generate.dbdoc;

import org.tiankafei.web.generate.dbdoc.enums.BusinessTypeEnum;

import java.util.List;

/**
 * 创建数据库设计文档
 */
public interface ICreateDatabaseDoc {

    String getDriverClassName();

    String getJdbcUrl() throws Exception;

    String getUsername();

    String getPassword();

    String getFileDirectory();

    String getVersion();

    String getDescription();

    String getFileName() throws Exception;

    BusinessTypeEnum getBusinessType();

    /**
     * 忽略的表名
     * @return
     */
    List<String> ignoreTableNameList();

    /**
     * 忽略的表名前缀
     * @return
     */
    List<String> ignoreTablePrefixList();

    /**
     * 忽略的表名后缀
     * @return
     */
    List<String> ignoreTableSuffixList();

    /**
     * 指定的表名
     * @return
     */
    List<String> designatedTableNameList();

    /**
     * 指定的表名前缀
     * @return
     */
    List<String> designatedTablePrefixList();

    /**
     * 指定的表名后缀
     * @return
     */
    List<String> designatedTableSuffixList();

}
