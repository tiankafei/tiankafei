package org.tiankafei.user.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 魏双双
 * @since 1.0
 **/
@Data
@Component
@ConfigurationProperties(prefix = "org.tiankafei")
public class UserProperties {

    private String key1;
    private String key2;
    private String key3;
    private String key4;
    private String key5;
    private String key6;

}
