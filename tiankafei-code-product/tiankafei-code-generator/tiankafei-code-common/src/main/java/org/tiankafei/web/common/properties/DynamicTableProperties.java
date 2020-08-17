package org.tiankafei.web.common.properties;

import com.google.common.collect.Lists;
import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@Component
@ConfigurationProperties("dynamic")
public class DynamicTableProperties {

    private List<String> tableNames = Lists.newArrayList();

}
