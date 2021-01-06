package org.tiankafei.web.generate.dbdoc;

import cn.smallbun.screw.core.Configuration;
import cn.smallbun.screw.core.engine.EngineConfig;
import cn.smallbun.screw.core.engine.EngineFileType;
import cn.smallbun.screw.core.engine.EngineTemplateType;
import cn.smallbun.screw.core.execute.DocumentationExecute;
import cn.smallbun.screw.core.process.ProcessConfig;
import com.google.common.collect.Maps;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.tiankafei.web.common.properties.DbDocProperties;
import org.tiankafei.web.common.utils.DbdocUtil;
import org.tiankafei.web.generate.dbdoc.enums.BusinessTypeEnum;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class CreateDatabaseDocService implements InitializingBean {

    private static Map<String, ICreateDatabaseDoc> createDatabaseDocMap = Maps.newHashMap();

    @Autowired
    private ApplicationContext applicationContext;

    private EngineFileType defaultFileType = EngineFileType.WORD;

    private static List<EngineFileType> fileTypeList;

    static {
        fileTypeList = Lists.newArrayList();
        fileTypeList.add(EngineFileType.WORD);
        fileTypeList.add(EngineFileType.HTML);
        fileTypeList.add(EngineFileType.MD);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, ICreateDatabaseDoc> beansOfType = applicationContext.getBeansOfType(ICreateDatabaseDoc.class);
        Set<Map.Entry<String, ICreateDatabaseDoc>> entries = beansOfType.entrySet();
        for (Map.Entry<String, ICreateDatabaseDoc> entry : entries) {
            ICreateDatabaseDoc value = entry.getValue();
            BusinessTypeEnum businessType = value.getBusinessType();
            createDatabaseDocMap.put(businessType.getBusinessType(), value);
        }
    }

    public void execCreateDatabaseDocument(BusinessTypeEnum typeEnum) throws Exception {
        execCreateDatabaseDocument(typeEnum, defaultFileType);
    }

    public void execCreateDatabaseDocument(BusinessTypeEnum typeEnum, EngineFileType fileType) throws Exception {
        execCreateDatabaseDocument(typeEnum.getBusinessType(), fileType);
    }

    private void execCreateDatabaseDocument(String businessType, EngineFileType fileType) throws Exception {
        if(createDatabaseDocMap.containsKey(businessType)){
            ICreateDatabaseDoc value = createDatabaseDocMap.get(businessType);
            execCreateDatabaseDocument(value, fileType);
        }else{
            throw new Exception("不支持当前业务类型的数据库文档生成");
        }
    }

    public void execCreateDatabaseAllDocument(BusinessTypeEnum typeEnum) throws Exception {
        for (int index = 0; index < fileTypeList.size(); index++) {
            EngineFileType fileType = fileTypeList.get(index);
            execCreateDatabaseDocument(typeEnum, fileType);
        }
    }

    public void execCreateDatabaseAllDocument() throws Exception {
        Set<Map.Entry<String, ICreateDatabaseDoc>> entries = createDatabaseDocMap.entrySet();
        for (Map.Entry<String, ICreateDatabaseDoc> entry : entries) {
            ICreateDatabaseDoc value = entry.getValue();
            for (int index = 0; index < fileTypeList.size(); index++) {
                EngineFileType fileType = fileTypeList.get(index);
                execCreateDatabaseDocument(value, fileType);
            }
        }
    }

    private void execCreateDatabaseDocument(ICreateDatabaseDoc value, EngineFileType fileType) throws Exception {
        //数据源
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(value.getDriverClassName());
        hikariConfig.setJdbcUrl(value.getJdbcUrl());
        hikariConfig.setUsername(value.getUsername());
        hikariConfig.setPassword(value.getPassword());
        //设置可以获取tables remarks信息
        hikariConfig.addDataSourceProperty("useInformationSchema", "true");
        hikariConfig.setMinimumIdle(2);
        hikariConfig.setMaximumPoolSize(5);
        DataSource dataSource = new HikariDataSource(hikariConfig);
        //生成配置
        EngineConfig engineConfig = EngineConfig.builder()
                //生成文件路径
                .fileOutputDir(value.getFileDirectory())
                //打开目录
                .openOutputDir(true)
                //文件类型
//                .fileType(EngineFileType.HTML)
                .fileType(fileType)
                //生成模板实现
                .produceType(EngineTemplateType.freemarker)
                //自定义文件名称
                .fileName(value.getFileName()).build();

        ProcessConfig processConfig = ProcessConfig.builder()
                //指定生成逻辑、当存在指定表、指定表前缀、指定表后缀时，将生成指定表，其余表不生成、并跳过忽略表配置
                //根据名称指定表生成
                .designatedTableName(value.designatedTableNameList())
                //根据表前缀生成
                .designatedTablePrefix(value.designatedTablePrefixList())
                //根据表后缀生成
                .designatedTableSuffix(value.designatedTableSuffixList())
                //忽略表名
                .ignoreTableName(value.ignoreTableNameList())
                //忽略表前缀
                .ignoreTablePrefix(value.ignoreTablePrefixList())
                //忽略表后缀
                .ignoreTableSuffix(value.ignoreTableSuffixList()).build();
        //配置
        Configuration config = Configuration.builder()
                //版本
                .version(value.getVersion())
                //描述
                .description(value.getDescription())
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

    public void createDatabaseDocument(String jsonFile) throws Exception {
        List<DbDocProperties> propertiesList = DbdocUtil.createDatabaseDocumentProperties(jsonFile);
        createDatabaseDocument(propertiesList);
    }

    public void createDatabaseDocument(List<DbDocProperties> propertiesList) throws Exception {
        for (int index = 0; index < fileTypeList.size(); index++) {
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
