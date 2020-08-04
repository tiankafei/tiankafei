package org.tiankafei.web.generate;

import cn.smallbun.screw.core.Configuration;
import cn.smallbun.screw.core.engine.EngineConfig;
import cn.smallbun.screw.core.engine.EngineFileType;
import cn.smallbun.screw.core.engine.EngineTemplateType;
import cn.smallbun.screw.core.execute.DocumentationExecute;
import cn.smallbun.screw.core.process.ProcessConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.tiankafei.web.generate.properties.DbProperties;

/**
 * @author 魏双双
 * @since 1.0
 **/
public class CreateMysqlTableDocument {



    public static void main(String[] args) {
        DbProperties dbProperties = new DbProperties()
                .setFileDirectory("C:\\Users\\Administrator\\Desktop\\统计产品")
                .setFileName("统计报表")
                .setDriverClassName("com.mysql.cj.jdbc.Driver")
                .setJdbcUrl("jdbc:mysql://10.10.50.83:3306/thtftjcp?useSSL=false&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8")
                .setUsername("tjcp")
                .setPassword("tjcp")
                ;
        createDoc(dbProperties);

        dbProperties = new DbProperties()
                .setFileDirectory("C:\\Users\\Administrator\\Desktop\\统计产品")
                .setFileName("统计报表填报")
                .setDriverClassName("com.mysql.cj.jdbc.Driver")
                .setJdbcUrl("jdbc:mysql://10.10.50.83:3306/thtftjcp-report-business?useSSL=false&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8")
                .setUsername("tjcp")
                .setPassword("tjcp")
                ;
        createDoc(dbProperties);

        dbProperties = new DbProperties()
                .setFileDirectory("C:\\Users\\Administrator\\Desktop\\统计产品")
                .setFileName("规则设计")
                .setDriverClassName("com.mysql.cj.jdbc.Driver")
                .setJdbcUrl("jdbc:mysql://10.10.50.83:3306/thtftjcp-rule-design?useSSL=false&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8")
                .setUsername("tjcp")
                .setPassword("tjcp")
                ;
        createDoc(dbProperties);

        dbProperties = new DbProperties()
                .setFileDirectory("C:\\Users\\Administrator\\Desktop\\统计产品")
                .setFileName("规则审核")
                .setDriverClassName("com.mysql.cj.jdbc.Driver")
                .setJdbcUrl("jdbc:mysql://10.10.50.83:3306/thtftjcp-rule-verify?useSSL=false&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8")
                .setUsername("tjcp")
                .setPassword("tjcp")
                ;
        createDoc(dbProperties);

    }

    private static void createDoc(DbProperties dbProperties){
        //数据源
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(dbProperties.getDriverClassName());
        hikariConfig.setJdbcUrl(dbProperties.getJdbcUrl());
        hikariConfig.setUsername(dbProperties.getUsername());
        hikariConfig.setPassword(dbProperties.getPassword());
        //设置可以获取tables remarks信息
        hikariConfig.addDataSourceProperty("useInformationSchema", "true");
        hikariConfig.setMinimumIdle(2);
        hikariConfig.setMaximumPoolSize(5);
        DataSource dataSource = new HikariDataSource(hikariConfig);
        //生成配置
        EngineConfig engineConfig = EngineConfig.builder()
                //生成文件路径
                .fileOutputDir(dbProperties.getFileDirectory())
                //打开目录
                .openOutputDir(true)
                //文件类型
//                .fileType(EngineFileType.HTML)
                .fileType(EngineFileType.MD)
                //生成模板实现
                .produceType(EngineTemplateType.freemarker)
                //自定义文件名称
                .fileName(dbProperties.getFileName()).build();

        //忽略表
        ArrayList<String> ignoreTableName = new ArrayList<>();
        ignoreTableName.add("gh_gz_gz");
        ignoreTableName.add("undo_log");
        ignoreTableName.add("PDMAN_DB_VERSION");
        ProcessConfig processConfig = ProcessConfig.builder()
                //指定生成逻辑、当存在指定表、指定表前缀、指定表后缀时，将生成指定表，其余表不生成、并跳过忽略表配置
                //根据名称指定表生成
                .designatedTableName(new ArrayList<>())
                //根据表前缀生成
                .designatedTablePrefix(new ArrayList<>())
                //根据表后缀生成
                .designatedTableSuffix(new ArrayList<>())
                //忽略表名
                .ignoreTableName(ignoreTableName)
                //忽略表前缀
                .ignoreTablePrefix(new ArrayList<>())
                //忽略表后缀
                .ignoreTableSuffix(new ArrayList<>()).build();
        //配置
        Configuration config = Configuration.builder()
                //版本
                .version("1.0.0")
                //描述
                .description("数据库设计文档生成")
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
