package org.tiankafei.web.generate;

import java.util.HashMap;
import java.util.Map;

/**
 * spring-boot-plus代码生成器入口类
 *
 * @author geekidea
 * @date 2019-10-22
 **/
public class UserGenerator {

    public static void main(String[] args) {
        CodeGenerator codeGenerator = new CodeGenerator();
        // 公共配置
        // 数据库配置
        codeGenerator
                .setUserName("root")
                .setPassword("tiankafei")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setDriverUrl("jdbc:mysql://localhost:3306/db-user?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true");

        // 包信息
        codeGenerator
                .setProjectPackagePath("org/tiankafei")
                .setParentPackage("org.tiankafei.web");

        // 组件作者等配置
        codeGenerator
                .setAuthor("tiankafei")
                .setPkIdColumnName("id");

        Map<String, String[]> map = new HashMap<>();
        map.put("user", new String[]{"tkf_user_login"});

        String directory = "E:\\gits\\tiankafei\\tiankafei-code-product\\tiankafei-service\\tiankafei-user-service";
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
