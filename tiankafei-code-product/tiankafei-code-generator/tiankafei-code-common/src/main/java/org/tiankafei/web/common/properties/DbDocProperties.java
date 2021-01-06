package org.tiankafei.web.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * db文档配置对象
 *
 * @author 甜咖啡
 */
@Data
@Component
@ConfigurationProperties(prefix = "db.doc")
public class DbDocProperties {

    private String driverClassName;

    private String jdbcUrl;

    private String username;

    private String password;

    private String fileDirectory;

    private String version;

    private String description;

    private String fileName;

    private List<String> ignoreTableNameList;

    private List<String> ignoreTablePrefixList;

    private List<String> ignoreTableSuffixList;

    private List<String> designatedTableNameList;

    private List<String> designatedTablePrefixList;

    private List<String> designatedTableSuffixList;

}
