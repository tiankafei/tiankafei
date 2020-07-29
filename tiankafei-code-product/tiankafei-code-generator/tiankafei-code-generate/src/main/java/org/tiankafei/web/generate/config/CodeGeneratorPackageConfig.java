package org.tiankafei.web.generate.config;

import com.baomidou.mybatisplus.generator.config.PackageConfig;
import org.tiankafei.web.generate.properties.CodeProperties;

/**
 * @author 魏双双
 * @since 1.0
 **/
public class CodeGeneratorPackageConfig {

    // 包名配置，通过该配置，指定生成代码的包路径
    public static PackageConfig initPackageConfig(CodeProperties codePropertie){
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(codePropertie.getProjectPath());
        packageConfig.setModuleName(codePropertie.getModuleName());
        packageConfig.setEntity("entity");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        packageConfig.setMapper("mapper");
        packageConfig.setXml("mapper.xml");
        packageConfig.setController("controller");
//        packageConfig.setPathInfo();

        return packageConfig;
    }

}
