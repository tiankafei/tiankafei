package org.tiankafei.jdbc.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 数据源参数对象
 *
 * @author 甜咖啡
 */
@Data
@Accessors(chain = true)
public class DataSourceDTO implements Serializable {

    private static final long serialVersionUID = -6732557702613100218L;

    /**
     * jndi名称
     */
    private String jndiName;

    /**
     * 数据库IP
     */
    private String ip;

    /**
     * 数据库端口
     */
    private Integer port;

    /**
     * 数据库名称
     */
    private String dbName;

    /**
     * 数据库用户名
     */
    private String username;

    /**
     * 数据库密码
     */
    private String password;

    /**
     * 数据库产品名称
     */
    private String productName;

    /**
     * 数据库连接驱动
     */
    private String driver;

    /**
     * 数据库连接url链接
     */
    private String url;

    public DataSourceDTO() {
        port = -1;
    }

}
