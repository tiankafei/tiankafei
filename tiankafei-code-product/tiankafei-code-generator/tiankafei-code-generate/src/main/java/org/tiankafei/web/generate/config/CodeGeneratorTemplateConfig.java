package org.tiankafei.web.generate.config;

import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import org.tiankafei.web.generate.properties.CodeProperties;

/**
 * @author 魏双双
 * @since 1.0
 **/
public class CodeGeneratorTemplateConfig {

    // 模板配置，可自定义代码生成的模板，实现个性化操作
    public static TemplateConfig initTemplateConfig(CodeProperties codePropertie){
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setEntity(codePropertie.getEntity());
        templateConfig.setService(codePropertie.getService());
        templateConfig.setServiceImpl(codePropertie.getServiceImpl());
        templateConfig.setMapper(codePropertie.getMapper());
        templateConfig.setXml(codePropertie.getXml());
        templateConfig.setController(codePropertie.getController());

        return templateConfig;
    }

}
