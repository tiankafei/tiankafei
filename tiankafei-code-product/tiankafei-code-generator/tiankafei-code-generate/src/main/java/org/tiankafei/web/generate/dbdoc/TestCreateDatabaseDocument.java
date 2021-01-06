package org.tiankafei.web.generate.dbdoc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 生成数据库文档
 *
 * @author 甜咖啡
 */
public class TestCreateDatabaseDocument {

    public static void main(String[] args) throws Exception {
        String basePackages = "org.tiankafei.web.generate.dbdoc";
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(basePackages);

        CreateDatabaseDocService createDatabaseDocService = applicationContext.getBean(CreateDatabaseDocService.class);
        createDatabaseDocService.createDatabaseDocument("data.json");
    }

}
