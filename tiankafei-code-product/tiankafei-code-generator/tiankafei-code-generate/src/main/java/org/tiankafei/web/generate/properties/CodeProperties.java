package org.tiankafei.web.generate.properties;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 魏双双
 * @since 1.0
 **/
@Data
@Accessors(chain = true)
@Component
@ConfigurationProperties(prefix = "code.generator.datasource")
public class CodeProperties implements Serializable {



}
