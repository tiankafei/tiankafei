package org.tiankafei.web.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
@Component
@ConfigurationProperties(prefix = "swagger.contact")
public class ContactProperties {

    /**
     * 作者
     */
    private String name;

    /**
     * 作者网址
     */
    private String url;

    /**
     * 作者邮箱
     */
    private String email;

}
