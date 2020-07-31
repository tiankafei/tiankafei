package org.tiankafei.web.generate.config;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cglib.beans.BeanMap;
import org.tiankafei.web.generate.properties.CfgProperties;
import org.tiankafei.web.generate.properties.CodeProperties;

/**
 * @author 魏双双
 * @since 1.0
 **/
public class CodeGeneratorInjectionConfig {

    // 注入配置，通过该配置，可注入自定义参数等操作以实现个性化操作
    public static InjectionConfig initInjectionConfig(CodeProperties codeProperties) {
        List<FileOutConfig> fileOutConfigList = new ArrayList<>();

        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                ConfigBuilder config = getConfig();

                Map<String, Object> map = new HashMap<>();
                map.put("shiroAuthority", codeProperties.isShiroAuthority());
                map.put("voPackage", codeProperties.getProjectPath() + "." + codeProperties.getModuleName() + ".vo");
                map.put("paramPackage", codeProperties.getProjectPath() + "." + codeProperties.getModuleName() + ".param");
                map.put("idsParamClassPath", codeProperties.getIdsParamClassPath());
                map.put("pageClassPath", codeProperties.getPageClassPath());
                map.put("apiResultClassPath", codeProperties.getApiResultClassPath());

                String superVoClassPath = codeProperties.getSuperVoClassPath();
                String superVoPackage = superVoClassPath.substring(0, superVoClassPath.lastIndexOf("."));
                String superVoName = superVoClassPath.substring(superVoClassPath.lastIndexOf(".") + 1);
                map.put("superVoPackage", superVoPackage);
                map.put("superVoClassName", superVoName);

                String superPageParamClassPath = codeProperties.getSuperPageParamClassPath();
                String superPageParamPackage = superPageParamClassPath.substring(0, superPageParamClassPath.lastIndexOf("."));
                String superPageParamName = superPageParamClassPath.substring(superPageParamClassPath.lastIndexOf(".") + 1);
                map.put("superParamPackage", superPageParamPackage);
                map.put("superPageParamClassName", superPageParamName);

                List<TableInfo> tableInfoList = config.getTableInfoList();
                tableInfoList.stream().forEach(tableInfo -> {
                    CfgProperties cfgProperties = new CfgProperties();
                    String name = tableInfo.getName();

                    Set<String> importPackages = tableInfo.getImportPackages();
                    List<String> importPackageList = importPackages.stream().filter(importPackage -> {
                        if (importPackage.endsWith("TableName")
                                || importPackage.endsWith("IdType")
                                || importPackage.endsWith("Model")
                                || importPackage.endsWith("Version")
                                || importPackage.endsWith("TableId")
                                || importPackage.endsWith("FieldFill")
                                || importPackage.endsWith("TableLogic")
                                || importPackage.endsWith("TableField")) {
                            return false;
                        }
                        return true;
                    }).collect(Collectors.toList());
                    cfgProperties.setImportPackageList(importPackageList);

                    String entityName = tableInfo.getEntityName();
                    String entityConstName = firstToLowerCase(entityName);
                    cfgProperties.setEntityConstName(entityConstName);

                    String voName = entityName.replace("Entity", "Vo");
                    cfgProperties.setVoClassName(voName);
                    cfgProperties.setVoConstName(firstToLowerCase(voName));

                    String listParamName = entityName.replace("Entity", "ListParam");
                    cfgProperties.setListParamClassName(listParamName);
                    cfgProperties.setListParamConstName(firstToLowerCase(listParamName));

                    String countParamName = entityName.replace("Entity", "CountParam");
                    cfgProperties.setCountParamClassName(countParamName);
                    cfgProperties.setCountParamConstName(firstToLowerCase(countParamName));

                    String deleteParamName = entityName.replace("Entity", "DeleteParam");
                    cfgProperties.setDeleteParamClassName(deleteParamName);
                    cfgProperties.setDeleteParamConstName(firstToLowerCase(deleteParamName));

                    String checkParamName = entityName.replace("Entity", "CheckParam");
                    cfgProperties.setCheckParamClassName(checkParamName);
                    cfgProperties.setCheckParamConstName(firstToLowerCase(checkParamName));

                    String pageParamName = entityName.replace("Entity", "PageParam");
                    cfgProperties.setPageParamClassName(pageParamName);
                    cfgProperties.setPageParamConstName(firstToLowerCase(pageParamName));

                    String permission = underlineToColon(name);
                    cfgProperties.setAuthority(permission);

                    String serviceName = tableInfo.getServiceName();
                    String serviceConstName = firstToLowerCase(serviceName);
                    cfgProperties.setServiceConstName(serviceConstName);

                    String mapperName = tableInfo.getMapperName();
                    String mapperConstName = firstToLowerCase(mapperName);
                    cfgProperties.setMapperConstName(mapperConstName);

                    String controllerName = tableInfo.getControllerName();
                    String controllerConstName = firstToLowerCase(controllerName);
                    cfgProperties.setControllerConstName(controllerConstName);

                    BeanMap beanMap = BeanMap.create(cfgProperties);
                    map.put(name, beanMap);

                    fileOutConfigList.add(getFileOutConfig("/myself/vo.java.vm", cfgProperties::getVoClassName, "vo", codeProperties));
                    fileOutConfigList.add(getFileOutConfig("/myself/listParam.java.vm", cfgProperties::getListParamClassName, "param", codeProperties));
                    fileOutConfigList.add(getFileOutConfig("/myself/countParam.java.vm", cfgProperties::getCountParamClassName, "param", codeProperties));
                    fileOutConfigList.add(getFileOutConfig("/myself/deleteParam.java.vm", cfgProperties::getDeleteParamClassName, "param", codeProperties));
                    fileOutConfigList.add(getFileOutConfig("/myself/checkParam.java.vm", cfgProperties::getCheckParamClassName, "param", codeProperties));
                    fileOutConfigList.add(getFileOutConfig("/myself/pageParam.java.vm", cfgProperties::getPageParamClassName, "param", codeProperties));
                });
                setMap(map);
            }
        };

        injectionConfig.setFileOutConfigList(fileOutConfigList);
        return injectionConfig;
    }

    /**
     * 获取文件配置
     * @param vmPath
     * @param supplier
     * @param smailPackage
     * @param codeProperties
     * @return
     */
    private static FileOutConfig getFileOutConfig(String vmPath, Supplier<String> supplier, String smailPackage, CodeProperties codeProperties){
        return new FileOutConfig(vmPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String pageParamClassName = supplier.get();

                String path = codeProperties.getOutputDir() + File.separator
                        + codeProperties.getProjectPath().replaceAll("\\.", Matcher.quoteReplacement(File.separator)) + File.separator
                        + codeProperties.getModuleName() + File.separator + smailPackage + File.separator + pageParamClassName + StringPool.DOT_JAVA;
                return path;
            }
        };
    }

    /**
     * 下划线转换成冒号连接命名
     * sys_user --> sys:user
     *
     * @param underline
     * @return
     */
    public static String firstToLowerCase(String underline) {
        if (StringUtils.isNotBlank(underline)) {
            return underline.substring(0, 1).toLowerCase() + underline.substring(1);
        }
        return null;
    }

    /**
     * 下划线转换成冒号连接命名
     * sys_user --> sys:user
     *
     * @param underline
     * @return
     */
    public static String underlineToColon(String underline) {
        if (StringUtils.isNotBlank(underline)) {
            String string = underline.toLowerCase();
            return string.replaceAll("_", ":");
        }
        return null;
    }

}
