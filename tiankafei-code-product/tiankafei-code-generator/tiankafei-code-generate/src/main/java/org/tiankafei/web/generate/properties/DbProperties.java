package org.tiankafei.web.generate.properties;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 魏双双
 * @since 1.0
 **/
@Data
@Accessors(chain = true)
public class DbProperties {

    private String driverClassName;

    private String jdbcUrl;

    private String username;

    private String password;

    private String fileName;

    private String fileDirectory;

}
