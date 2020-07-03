package org.tiankafei.zuul.properties;

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

    /**
     * 该url所有的过滤都不需要走
     */
    private List<String> urls;

    /**
     * 该url仅仅不走鉴权的过滤
     */
    private List<String> authUrls;

}
