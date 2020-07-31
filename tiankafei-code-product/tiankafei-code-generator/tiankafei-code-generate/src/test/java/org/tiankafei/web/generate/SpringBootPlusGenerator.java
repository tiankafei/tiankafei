package org.tiankafei.web.generate;

import com.google.common.collect.Maps;
import java.util.Map;

/**
 * spring-boot-plus代码生成器入口类
 *
 * @author geekidea
 * @date 2019-10-22
 **/
public class SpringBootPlusGenerator {

    public static void main(String[] args) {
        CodeGenerator codeGenerator = new CodeGenerator();
        // 公共配置
        // 数据库配置
        codeGenerator
                .setUserName("root")
                .setPassword("tiankafei")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setDriverUrl("jdbc:mysql://localhost:3306/master?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true");

        // 包信息
        codeGenerator
                .setProjectPackagePath("org/tiankafei")
                .setParentPackage("org.tiankafei.web");

        // 组件作者等配置
        codeGenerator
                .setAuthor("tiankafei")
                .setPkIdColumnName("id");

        Map<String, String[]> map = Maps.newHashMap();
        map.put("businessdata", new String[]{"TKF_BUSINESS_DATA"});
        map.put("loginuser", new String[]{"TKF_LOGIN_USER"});
        map.put("rolebusinessdata", new String[]{"TKF_ROLE_BUSINESS_DATA"});
        map.put("roledata", new String[]{"TKF_ROLE_DATA"});
        map.put("syscatalog", new String[]{"TKF_SYS_CATALOG"});

        String directory = "";
        for (String moduleName : map.keySet()) {
            String[] tables = map.get(moduleName);
            codeGenerator.setModuleName(moduleName.toLowerCase());
            // 初始化公共变量
            codeGenerator.init();
            // 循环生成
            for (String table : tables) {
                // 设置需要生成的表名称
                codeGenerator.setTableName(table);
                // 生成代码
                codeGenerator.generator(directory);
            }
        }
    }

}
