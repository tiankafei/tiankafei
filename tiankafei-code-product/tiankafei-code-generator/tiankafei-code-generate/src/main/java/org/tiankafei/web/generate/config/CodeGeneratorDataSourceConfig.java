package org.tiankafei.web.generate.config;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.ITypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import org.tiankafei.web.generate.properties.CodeProperties;

/**
 * @author 魏双双
 * @since 1.0
 **/
public class CodeGeneratorDataSourceConfig {

    // 数据源配置，通过该配置，指定需要生成代码的具体数据库
    public static DataSourceConfig initDataSourceConfig(CodeProperties codeProperties){
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(codeProperties.getUrl());
        dataSourceConfig.setDriverName(codeProperties.getDriverName());
        dataSourceConfig.setUsername(codeProperties.getUsername());
        dataSourceConfig.setPassword(codeProperties.getPassword());
        // 设置自定义查询
        dataSourceConfig.setDbQuery(new MySqlQuery(){
            @Override
            public String[] fieldCustom() {
                return new String[]{"null", "default"};
            }
        });
        dataSourceConfig.setTypeConvert(new ITypeConvert() {
            @Override
            public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                if (fieldType.equalsIgnoreCase("timestamp")
                        || fieldType.equalsIgnoreCase("datetime")
                        || fieldType.equalsIgnoreCase("date")) {
                    return DbColumnType.TIMESTAMP;
                }
                //其它字段采用默认转换（非mysql数据库可以使用其它默认的数据库转换器）
                return new MySqlTypeConvert().processTypeConvert(globalConfig, fieldType);
            }
        });
        return dataSourceConfig;
    }

}
