package org.tiankafei.web.generate.dbdoc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestCreateDatabaseDocument {

    public static void main(String[] args) throws Exception {
        String basePackages = "org.tiankafei.web.generate.dbdoc";
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(basePackages);

        CreateDatabaseDocService createDatabaseDocService = applicationContext.getBean(CreateDatabaseDocService.class);
        createDatabaseDocService.execCreateDatabaseAllDocument();
    }

}