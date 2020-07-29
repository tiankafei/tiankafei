package org.tiankafei.web.generate.properties;

import com.baomidou.mybatisplus.generator.config.ConstVal;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.compress.utils.Lists;

/**
 * @author 魏双双
 * @since 1.0
 **/
@Data
@Accessors(chain = true)
public class CodeProperties implements Serializable {

    /**
     * 驱动连接的URL
     */
    private String url;

    /**
     * 驱动名称
     */
    private String driverName;

    /**
     * 数据库连接用户名
     */
    private String username;

    /**
     * 数据库连接密码
     */
    private String password;


    private String superEntityClassPath;
    private String superMapperClassPath;
    private String superServiceClassPath;
    private String superServiceImplClassPath;
    private String superControllerClassPath;
    private List<String> tableNameList = Lists.newArrayList();


    private String projectPath;
    private String moduleName;


    private String entity = ConstVal.TEMPLATE_ENTITY_JAVA;
    private String entityKt = ConstVal.TEMPLATE_ENTITY_KT;
    private String service = ConstVal.TEMPLATE_SERVICE;
    private String serviceImpl = ConstVal.TEMPLATE_SERVICE_IMPL;
    private String mapper = ConstVal.TEMPLATE_MAPPER;
    private String xml = ConstVal.TEMPLATE_XML;
    private String controller = ConstVal.TEMPLATE_CONTROLLER;


    private String author;
    private String outputDir;


    private boolean shiroAuthority = false;
    private String superVoClassPath;
    private String superPageParamClassPath;

}
