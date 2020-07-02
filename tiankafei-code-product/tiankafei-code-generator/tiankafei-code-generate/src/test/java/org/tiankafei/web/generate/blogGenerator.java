package org.tiankafei.web.generate;

import com.baomidou.mybatisplus.annotation.IdType;

import java.util.HashMap;
import java.util.Map;

/**
 * spring-boot-plus代码生成器入口类
 *
 * @author geekidea
 * @date 2019-10-22
 **/
public class blogGenerator {

    public static void main(String[] args) {
        CodeGenerator codeGenerator = new CodeGenerator();
        // 公共配置
        // 数据库配置
        codeGenerator
                .setUserName("root")
                .setPassword("tiankafei")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setDriverUrl("jdbc:mysql://localhost:3306/db-blog?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true");

        // 包信息
        codeGenerator
                .setProjectPackagePath("org/tiankafei")
                .setParentPackage("org.tiankafei.web");

        // 组件作者等配置
        codeGenerator
                .setAuthor("tiankafei")
                .setPkIdColumnName("id");

        codeGenerator.setIdType(IdType.ASSIGN_ID);

        Map<String, String[]> map = new HashMap<>();
        map.put("blog", new String[]{"sys_blog_info", "sys_blog_label"});

        String directory = "E:\\gits\\tiankafei\\tiankafei-code-product\\tiankafei-service\\tiankafei-blog-service";
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
