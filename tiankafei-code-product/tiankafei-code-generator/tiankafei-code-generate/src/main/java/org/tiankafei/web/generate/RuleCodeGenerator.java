package org.tiankafei.web.generate;

import java.util.Arrays;
import java.util.List;
import org.tiankafei.web.generate.properties.CodeProperties;

/**
 * @author tiankafei
 * @since 1.0
 */
public class RuleCodeGenerator extends BaseCodeGenerator {

    private String author = "tiankafei";
    private String outputDir = "E:\\gits\\tiankafei\\tiankafei-code-product\\tiankafei-service\\tiankafei-rule-service\\tiankafei-rule-server\\src\\main\\java";

    private boolean shiroAuthority = Boolean.FALSE;
    private boolean logFlag = Boolean.FALSE;
    private String baseParentPath = "org.tiankafei";
    private String moduleName = "rule";

    private String baseEntityClassPath = "com.baomidou.mybatisplus.extension.activerecord.Model";
    private String baseMapperClassPath = "com.baomidou.mybatisplus.core.mapper.BaseMapper";
    private String baseServiceClassPath = "com.ruoyi.common.core.web.service.BaseService";
    private String baseServiceImplClassPath = "com.ruoyi.common.core.web.service.impl.BaseServiceImpl";
    private String baseControllerClassPath = "com.ruoyi.common.core.web.controller.BaseController";
    private String baseVoClassPath = "org.tiankafei.web.common.vo.BaseQueryVo";
    private String basePageParamClassPath = "org.tiankafei.web.common.param.BaseOrderQueryParam";
    private String idsParamClassPath = "org.tiankafei.web.common.param.IdsParam";
    private String pageClassPath = "com.ruoyi.common.core.web.page.Paging";
    private String apiResultClassPath = "com.ruoyi.common.core.web.domain.ApiResult";

    public static void main(String[] args) throws Exception {
        RuleCodeGenerator tiankafeiCodeGenerator = new RuleCodeGenerator();
        List<String> tableNameList = Arrays.asList(
                "sys_rule_design");
        tiankafeiCodeGenerator.execute(tableNameList);
    }

    @Override
    protected CodeProperties initCodeProperties() {
        CodeProperties codeProperties = new CodeProperties();
        codeProperties.setUrl("jdbc:mysql://localhost:3306/db-ry-cloud?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true");
        codeProperties.setDriverName("com.mysql.cj.jdbc.Driver");
        codeProperties.setUsername("root");
        codeProperties.setPassword("tiankafei");
        codeProperties.setShiroAuthority(shiroAuthority);
        codeProperties.setLogFlag(logFlag);
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