package org.tiankafei.web.generate;

import java.util.Arrays;
import java.util.List;
import org.tiankafei.web.generate.properties.CodeProperties;

/**
 * @author tiankafei
 * @since 1.0
 */
public class UserCodeGenerator extends BaseCodeGenerator {

    private String author = "tiankafei";
    private String outputDir = "E:\\gits\\tiankafei\\tiankafei-code-product\\tiankafei-service\\tiankafei-user-service\\tiankafei-user-server\\src\\main\\java";

    private boolean shiroAuthority = false;
    private String baseParentPath = "org.tiankafei";
    private String moduleName = "user";

    private String baseEntityClassPath = "com.baomidou.mybatisplus.extension.activerecord.Model";
    private String baseMapperClassPath = "com.baomidou.mybatisplus.core.mapper.BaseMapper";
    private String baseServiceClassPath = "org.tiankafei.web.common.service.BaseService";
    private String baseServiceImplClassPath = "org.tiankafei.web.common.service.impl.BaseServiceImpl";
    private String baseControllerClassPath = "org.tiankafei.web.common.controller.BaseController";
    private String baseVoClassPath = "org.tiankafei.web.common.vo.BaseQueryVo";
    private String basePageParamClassPath = "org.tiankafei.web.common.param.OrderQueryParam";
    private String idsParamClassPath = "org.tiankafei.web.common.param.IdsParam";
    private String pageClassPath = "org.tiankafei.web.common.vo.Paging";
    private String apiResultClassPath = "org.tiankafei.web.common.api.ApiResult";

    public static void main(String[] args) throws Exception {
        UserCodeGenerator tiankafeiCodeGenerator = new UserCodeGenerator();
        List<String> tableNameList = Arrays.asList(
                "sys_user_login",
                "sys_user_info",
                "sys_role_info",
                "sys_user_role",
                "sys_menu_info",
                "sys_role_menu",
                "sys_dept_info",
                "sys_dict_info",
                "sys_dict_table",
                "sys_links_info");
        tiankafeiCodeGenerator.execute(tableNameList);
    }

    @Override
    protected CodeProperties initCodeProperties() {
        CodeProperties codeProperties = new CodeProperties();
        codeProperties.setUrl("jdbc:mysql://localhost:3306/db-user?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true");
        codeProperties.setDriverName("com.mysql.cj.jdbc.Driver");
        codeProperties.setUsername("root");
        codeProperties.setPassword("tiankafei");
        codeProperties.setShiroAuthority(shiroAuthority);
        codeProperties.setAuthor(author);
        codeProperties.setOutputDir(outputDir);
        codeProperties.setProjectPath(baseParentPath);
        codeProperties.setModuleName(moduleName);
        codeProperties.setSuperControllerClassPath(baseControllerClassPath);
        codeProperties.setSuperEntityClassPath(baseEntityClassPath);
        codeProperties.setSuperServiceClassPath(baseServiceClassPath);
        codeProperties.setSuperServiceImplClassPath(baseServiceImplClassPath);
        codeProperties.setSuperMapperClassPath(baseMapperClassPath);
        codeProperties.setSuperVoClassPath(baseVoClassPath);
        codeProperties.setSuperPageParamClassPath(basePageParamClassPath);
        codeProperties.setEntity("/myself/entity.java.vm");
        codeProperties.setService("/myself/service.java.vm");
        codeProperties.setServiceImpl("/myself/serviceImpl.java.vm");
        codeProperties.setMapper("/myself/mapper.java.vm");
        codeProperties.setXml("/myself/mapper.xml.vm");
        codeProperties.setController("/myself/controller.java.vm");
        codeProperties.setIdsParamClassPath(idsParamClassPath);
        codeProperties.setPageClassPath(pageClassPath);
        codeProperties.setApiResultClassPath(apiResultClassPath);
        return codeProperties;
    }
}