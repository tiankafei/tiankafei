package org.tiankafei.web.generate;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
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
 **/
public abstract class BaseCodeGenerator {

    public void execute(List<String> tableNameList) throws Exception {
        CodeProperties codeProperties = initCodeProperties();

        for (int index = 0; index < tableNameList.size(); index++) {
            String tableName = tableNameList.get(index);
            DataSourceConfig dataSourceConfig = CodeGeneratorDataSourceConfig.initDataSourceConfig(codeProperties);
            StrategyConfig strategyConfig = CodeGeneratorStrategyConfig.initStrategyConfig(codeProperties, tableName);

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

    }

    protected abstract CodeProperties initCodeProperties() ;

}
