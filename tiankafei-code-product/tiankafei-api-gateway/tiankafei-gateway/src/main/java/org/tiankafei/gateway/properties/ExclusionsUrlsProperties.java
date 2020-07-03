package org.tiankafei.gateway.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
@Component
@ConfigurationProperties(prefix = "exclusions")
public class ExclusionsUrlsProperties {

    private List<String> urls;

}
