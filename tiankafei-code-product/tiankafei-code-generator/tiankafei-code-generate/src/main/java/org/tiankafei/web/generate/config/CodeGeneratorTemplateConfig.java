package org.tiankafei.web.generate.config;

import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import org.tiankafei.web.generate.properties.CodeProperties;

/**
 * @author 魏双双
 * @since 1.0
 **/
public class CodeGeneratorTemplateConfig {

    // 模板配置，可自定义代码生成的模板，实现个性化操作
    public static TemplateConfig initTemplateConfig(CodeProperties codeProperties){
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setEntity(codeProperties.getEntity());
        templateConfig.setService(codeProperties.getService());
        templateConfig.setServiceImpl(codeProperties.getServiceImpl());
        templateConfig.setMapper(codeProperties.getMapper());
        templateConfig.setXml(codeProperties.getXml());
        templateConfig.setController(codeProperties.getController());

        return templateConfig;
    }

}
