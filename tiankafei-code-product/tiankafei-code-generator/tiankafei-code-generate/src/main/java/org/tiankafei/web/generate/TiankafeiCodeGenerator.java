package org.tiankafei.web.generate;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import java.util.Arrays;
import java.util.List;
import org.tiankafei.web.generate.config.CodeGeneratorDataSourceConfig;
import org.tiankafei.web.generate.config.CodeGeneratorGlobalConfig;
import org.tiankafei.web.generate.config.CodeGeneratorInjectionConfig;
import org.tiankafei.web.generate.config.CodeGeneratorPackageConfig;
import org.tiankafei.web.generate.config.CodeGeneratorStrategyConfig;
import org.tiankafei.web.generate.config.CodeGeneratorTemplateConfig;
import org.tiankafei.web.generate.properties.CodeProperties;

/**
 * @author tiankafei
 * @since 1.0
 */
public class TiankafeiCodeGenerator {

    private String author = "tiankafei";
    private String outputDir = "E:\\gits\\tiankafei\\tiankafei-code-product\\tiankafei-code-generator\\tiankafei-code-generate\\src\\main\\java";

    private boolean shiroAuthority = false;
    private String baseParentPath = "org.tiankafei.mybatisplus";
    private String moduleName = "user";

    private String baseEntityClassPath = "com.baomidou.mybatisplus.extension.activerecord.Model";
    private String baseMapperClassPath = "com.baomidou.mybatisplus.core.mapper.BaseMapper";
    private String baseServiceClassPath = "org.tiankafei.web.common.service.BaseService";
    private String baseServiceImplClassPath = "org.tiankafei.web.common.service.impl.BaseServiceImpl";
    private String baseControllerClassPath = "org.tiankafei.web.common.controller.BaseController";
    private String baseVoClassPath = "org.tiankafei.web.common.vo.BaseQueryVo";
    private String basePageParamClassPath = "org.tiankafei.web.common.param.OrderQueryParam";
    private String idsParamClassPath = "org.tiankafei.web.common.param.IdsParam";
    private String pageClassPath = "org.tiankafei.web.common.vo.Paging";
    private String apiResultClassPath = "org.tiankafei.web.common.api.ApiResult";


    private List<String> tableNameList = Arrays.asList("sys_user_test");

    public static void main(String[] args) throws Exception {
        TiankafeiCodeGenerator tiankafeiCodeGenerator = new TiankafeiCodeGenerator();
        CodeProperties codeProperties = tiankafeiCodeGenerator.initCodeProperties();

        DataSourceConfig dataSourceConfig = CodeGeneratorDataSourceConfig.initDataSourceConfig(codeProperties);
        StrategyConfig strategyConfig = CodeGeneratorStrategyConfig.initStrategyConfig(codeProperties);
        PackageConfig packageConfig = CodeGeneratorPackageConfig.initPackageConfig(codeProperties);
        TemplateConfig templateConfig = CodeGeneratorTemplateConfig.initTemplateConfig(codeProperties);
        GlobalConfig globalConfig = CodeGeneratorGlobalConfig.initGlobalConfig(codeProperties);
        InjectionConfig cfg = CodeGeneratorInjectionConfig.initInjectionConfig(codeProperties);

        AutoGenerator autoGenerator = new AutoGenerator();
        // 数据源配置，通过该配置，指定需要生成代码的具体数据库
        autoGenerator.setDataSource(dataSourceConfig);
        // 数据库表配置，通过该配置，可指定需要生成哪些表或者排除哪些表
        autoGenerator.setStrategy(strategyConfig);
        // 包名配置，通过该配置，指定生成代码的包路径
        autoGenerator.setPackageInfo(packageConfig);
        // 模板配置，可自定义代码生成的模板，实现个性化操作
        autoGenerator.setTemplate(templateConfig);
        // 全局策略配置
        autoGenerator.setGlobalConfig(globalConfig);
        // 注入配置，通过该配置，可注入自定义参数等操作以实现个性化操作
        autoGenerator.setCfg(cfg);
        autoGenerator.execute();
    }


    private CodeProperties initCodeProperties(){
        CodeProperties codeProperties = new CodeProperties();
        codeProperties.setUrl("jdbc:mysql://localhost:3306/db-user?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true");
        codeProperties.setDriverName("com.mysql.cj.jdbc.Driver");
        codeProperties.setUsername("root");
        codeProperties.setPassword("tiankafei");
        codeProperties.setShiroAuthority(shiroAuthority);
        codeProperties.setAuthor(author);
        codeProperties.setOutputDir(outputDir);
        codeProperties.setProjectPath(baseParentPath);
        codeProperties.setModuleName(moduleName);
        codeProperties.setSuperControllerClassPath(baseControllerClassPath);
        codeProperties.setSuperEntityClassPath(baseEntityClassPath);
        codeProperties.setSuperServiceClassPath(baseServiceClassPath);
        codeProperties.setSuperServiceImplClassPath(baseServiceImplClassPath);
        codeProperties.setSuperMapperClassPath(baseMapperClassPath);
        codeProperties.setSuperVoClassPath(baseVoClassPath);
        codeProperties.setSuperPageParamClassPath(basePageParamClassPath);
        codeProperties.setTableNameList(tableNameList);
        codeProperties.setEntity("/myself/entity.java.vm");
        codeProperties.setService("/myself/service.java.vm");
        codeProperties.setServiceImpl("/myself/serviceImpl.java.vm");
        codeProperties.setMapper("/myself/mapper.java.vm");
        codeProperties.setXml("/myself/mapper.xml.vm");
        codeProperties.setController("/myself/controller.java.vm");
        codeProperties.setIdsParamClassPath(idsParamClassPath);
        codeProperties.setPageClassPath(pageClassPath);
        codeProperties.setApiResultClassPath(apiResultClassPath);
        return codeProperties;
    }

}
