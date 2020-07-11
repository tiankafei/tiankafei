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
@ConfigurationProperties(prefix = "swagger")
public class SwaggerProperties {

    /**
     * 是否开启文档
     */
    private Boolean enable;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * URL
     */
    private String url;

    /**
     * 联系人
     */
    private ContactProperties contact = new ContactProperties();

    /**
     * 版本
     */
    private String version;

    /**
     * 联系人
     */
    @Data
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

}
