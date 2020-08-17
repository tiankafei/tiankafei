package org.tiankafei.web.generate.config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import org.tiankafei.web.generate.properties.CodeProperties;

/**
 * @author 魏双双
 * @since 1.0
 **/
public class CodeGeneratorGlobalConfig {

    /**
     * 全局策略配置
     * @param codeProperties
     * @return
     */
    public static GlobalConfig initGlobalConfig(CodeProperties codeProperties){
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(codeProperties.getOutputDir());
        globalConfig.setFileOverride(true);
        globalConfig.setOpen(false);
        globalConfig.setEnableCache(false);
        globalConfig.setAuthor(codeProperties.getAuthor());
        globalConfig.setKotlin(false);
        globalConfig.setSwagger2(true);
        globalConfig.setActiveRecord(true);
        globalConfig.setBaseResultMap(true);
        globalConfig.setBaseColumnList(true);
        globalConfig.setDateType(DateType.SQL_PACK);
        globalConfig.setEntityName("%sEntity");
        globalConfig.setMapperName("%sMapper");
        globalConfig.setXmlName("%sMapper");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        globalConfig.setControllerName("%sController");
        globalConfig.setIdType(IdType.ASSIGN_ID);

        return globalConfig;
    }

}
