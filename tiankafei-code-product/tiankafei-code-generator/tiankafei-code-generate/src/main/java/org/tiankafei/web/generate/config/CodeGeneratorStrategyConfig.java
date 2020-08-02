package org.tiankafei.web.generate.config;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import java.util.Arrays;
import java.util.List;
import org.tiankafei.web.generate.properties.CodeProperties;

/**
 * @author 魏双双
 * @since 1.0
 **/
public class CodeGeneratorStrategyConfig {

    // 数据库表配置，通过该配置，可指定需要生成哪些表或者排除哪些表
    public static StrategyConfig initStrategyConfig(CodeProperties codeProperties, String tableName) throws ClassNotFoundException {
        StrategyConfig strategyConfig = new StrategyConfig();
//        strategyConfig.setCapitalMode(false);
//        strategyConfig.setSkipView(false);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setTablePrefix("sys_");
//        strategyConfig.setFieldPrefix("");
        strategyConfig.setSuperEntityClass(Class.forName(codeProperties.getSuperEntityClassPath()));
//        strategyConfig.setSuperEntityColumns("create_user_id", "create_time", "update_user_id", "update_time");
        strategyConfig.setSuperMapperClass(codeProperties.getSuperMapperClassPath());
        strategyConfig.setSuperServiceClass(codeProperties.getSuperServiceClassPath());
        strategyConfig.setSuperServiceImplClass(codeProperties.getSuperServiceImplClassPath());
        strategyConfig.setSuperControllerClass(codeProperties.getSuperControllerClassPath());
//        strategyConfig.setEnableSqlFilter(true);
        strategyConfig.setInclude(tableName);
//        strategyConfig.setLikeTable();
//        strategyConfig.setExclude();
//        strategyConfig.setNotLikeTable();
        strategyConfig.setEntityColumnConstant(true);
        strategyConfig.setChainModel(true);
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setEntityBooleanColumnRemoveIsPrefix(false);
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setControllerMappingHyphenStyle(true);
        strategyConfig.setEntityTableFieldAnnotationEnable(true);
        strategyConfig.setVersionFieldName("version");
        strategyConfig.setLogicDeleteFieldName("delete_mark");
        List<TableFill> tableFieldList = Arrays.asList(
                new TableFill("create_user_id", FieldFill.INSERT),
                new TableFill("create_time", FieldFill.INSERT),
                new TableFill("update_user_id", FieldFill.UPDATE),
                new TableFill("update_time", FieldFill.UPDATE));
        strategyConfig.setTableFillList(tableFieldList);

        return strategyConfig;
    }

}
