package org.tiankafei.web.generate.dbdoc;

import cn.smallbun.screw.core.Configuration;
import cn.smallbun.screw.core.engine.EngineConfig;
import cn.smallbun.screw.core.engine.EngineFileType;
import cn.smallbun.screw.core.engine.EngineTemplateType;
import cn.smallbun.screw.core.execute.DocumentationExecute;
import cn.smallbun.screw.core.process.ProcessConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.compress.utils.Lists;
import org.springframework.stereotype.Component;
import org.tiankafei.web.common.properties.DbDocProperties;
import org.tiankafei.web.common.utils.DbdocUtil;

import javax.sql.DataSource;
import java.util.List;

@Component
public class CreateDatabaseDocService {

    private static List<EngineFileType> fileTypeList;

    static {
        fileTypeList = Lists.newArrayList();
        fileTypeList.add(EngineFileType.WORD);
        fileTypeList.add(EngineFileType.HTML);
        fileTypeList.add(EngineFileType.MD);
    }

    public void createDatabaseDocument(String jsonFile) throws Exception {
        List<DbDocProperties> propertiesList = DbdocUtil.createDatabaseDocumentProperties(jsonFile);
        createDatabaseDocument(propertiesList);
    }

    public void createDatabaseDocument(String jsonFile, EngineFileType fileType) throws Exception {
        List<DbDocProperties> propertiesList = DbdocUtil.createDatabaseDocumentProperties(jsonFile);
        createDatabaseDocument(propertiesList, fileType);
    }

    public void createDatabaseDocument(List<DbDocProperties> propertiesList) throws Exception {
        for (int index = 0, length = fileTypeList.size(); index < length; index++) {
            createDatabaseDocument(propertiesList, fileTypeList.get(index));
        }
    }

    public void createDatabaseDocument(List<DbDocProperties> propertiesList, EngineFileType fileType) throws Exception {
        for (int index = 0, length = propertiesList.size(); index < length; index++) {
            doCreateDatabaseDocument(propertiesList.get(index), fileType);
        }
    }

    private void doCreateDatabaseDocument(DbDocProperties properties, EngineFileType fileType) throws Exception {
        //数据源
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(properties.getDriverClassName());
        hikariConfig.setJdbcUrl(properties.getJdbcUrl());
        hikariConfig.setUsername(properties.getUsername());
        hikariConfig.setPassword(properties.getPassword());
        //设置可以获取tables remarks信息
        hikariConfig.addDataSourceProperty("useInformationSchema", "true");
        hikariConfig.setMinimumIdle(2);
        hikariConfig.setMaximumPoolSize(5);
        DataSource dataSource = new HikariDataSource(hikariConfig);
        //生成配置
        EngineConfig engineConfig = EngineConfig.builder()
                //生成文件路径
                .fileOutputDir(properties.getFileDirectory())
                //打开目录
                .openOutputDir(true)
                //文件类型
//                .fileType(EngineFileType.HTML)
                .fileType(fileType)
                //生成模板实现
                .produceType(EngineTemplateType.freemarker)
                //自定义文件名称
                .fileName(properties.getFileName()).build();

        ProcessConfig processConfig = ProcessConfig.builder()
                //指定生成逻辑、当存在指定表、指定表前缀、指定表后缀时，将生成指定表，其余表不生成、并跳过忽略表配置
                //根据名称指定表生成
                .designatedTableName(properties.getDesignatedTableNameList())
                //根据表前缀生成
                .designatedTablePrefix(properties.getDesignatedTablePrefixList())
                //根据表后缀生成
                .designatedTableSuffix(properties.getDesignatedTableSuffixList())
                //忽略表名
                .ignoreTableName(properties.getIgnoreTableNameList())
                //忽略表前缀
                .ignoreTablePrefix(properties.getIgnoreTablePrefixList())
                //忽略表后缀
                .ignoreTableSuffix(properties.getIgnoreTableSuffixList()).build();
        //配置
        Configuration config = Configuration.builder()
                //版本
                .version(properties.getVersion())
                //描述
                .description(properties.getDescription())
                //数据源
                .dataSource(dataSource)
                //生成配置
                .engineConfig(engineConfig)
                //生成配置
                .produceConfig(processConfig)
                .build();
        //执行生成
        new DocumentationExecute(config).execute();
    }

}
