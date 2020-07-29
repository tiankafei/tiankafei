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
import java.util.regex.Matcher;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.web.generate.properties.CodeProperties;

/**
 * @author 魏双双
 * @since 1.0
 **/
public class CodeGeneratorInjectionConfig {

    // 注入配置，通过该配置，可注入自定义参数等操作以实现个性化操作
    public static InjectionConfig initInjectionConfig(CodeProperties codePropertie){
        InjectionConfig injectionConfig = new InjectionConfig(){
            @Override
            public void initMap() {
                ConfigBuilder config = getConfig();

                Map<String, Object> map = new HashMap<>();
                map.put("shiroAuthority", codePropertie.isShiroAuthority());

                Map<String, Map<String, String>> nameMapMap = new HashMap<>();
                Map<String, List<String>> importPackageList = new HashMap<>();
                List<TableInfo> tableInfoList = config.getTableInfoList();
                tableInfoList.stream().forEach(tableInfo -> {
                    String name = tableInfo.getName();

                    Set<String> importPackages = tableInfo.getImportPackages();
                    List<String> voImportPackages = importPackages.stream().filter(importPackage -> {
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
                    importPackageList.put(name, voImportPackages);

                    Map<String, String> nameMap = new HashMap<>();
                    String entityName = tableInfo.getEntityName();
                    String entityConstName = firstToLowerCase(entityName);
                    nameMap.put("entityConstName", entityConstName);

                    String voName = entityName.replace("Entity", "Vo");
                    nameMap.put("voName", voName);
                    nameMap.put("voConstName", firstToLowerCase(voName));
                    nameMap.put("voPath", codePropertie.getProjectPath() + "." + codePropertie.getModuleName() + ".vo");
                    nameMap.put("superVoClass", codePropertie.getSuperVoClassPath());

                    String paramName = entityName.replace("Entity", "Param");
                    nameMap.put("paramName", paramName);
                    nameMap.put("paramConstName", firstToLowerCase(paramName));
                    nameMap.put("paramPath", codePropertie.getProjectPath() + "." + codePropertie.getModuleName() + ".param");

                    String pageParamName = entityName.replace("Entity", "PageParam");
                    nameMap.put("pageParamName", pageParamName);
                    nameMap.put("pageParamConstName", firstToLowerCase(pageParamName));
                    nameMap.put("pageParamPath", codePropertie.getProjectPath() + "." + codePropertie.getModuleName() + ".param");
                    nameMap.put("superPageParamClass", codePropertie.getSuperPageParamClassPath());

                    String permission = underlineToColon(name);
                    nameMap.put("shiroAuthority", permission);

                    String serviceName = tableInfo.getServiceName();
                    String serviceConstName = firstToLowerCase(serviceName);
                    nameMap.put("serviceConstName", serviceConstName);

                    String mapperName = tableInfo.getMapperName();
                    String mapperConstName = firstToLowerCase(mapperName);
                    nameMap.put("mapperConstName", mapperConstName);

                    String controllerName = tableInfo.getControllerName();
                    String controllerConstName = firstToLowerCase(controllerName);
                    nameMap.put("controllerConstName", controllerConstName);

                    nameMapMap.put(name, nameMap);
                });

                map.put("name", nameMapMap);
                map.put("packages", importPackageList);
                setMap(map);
            }
        };

        List<FileOutConfig> fileOutConfigList = new ArrayList<>();
        fileOutConfigList.add(new FileOutConfig("/myself/vo.java.vm"){
            @Override
            public String outputFile(TableInfo tableInfo) {
                String name = tableInfo.getName();
                Map<String, Object> map = injectionConfig.getMap();
                Map<String, Map<String, String>> nameMap = (Map<String, Map<String, String>>) map.get("name");
                String voName = nameMap.get(name).get("voName");

                String path = codePropertie.getOutputDir() + File.separator
                        + codePropertie.getProjectPath().replaceAll("\\.", Matcher.quoteReplacement(File.separator)) + File.separator
                        + codePropertie.getModuleName() + File.separator + "vo" + File.separator + voName + StringPool.DOT_JAVA;
                System.out.println(path);
                return path;
            }
        });
        fileOutConfigList.add(new FileOutConfig("/myself/param.java.vm"){
            @Override
            public String outputFile(TableInfo tableInfo) {
                String name = tableInfo.getName();
                Map<String, Object> map = injectionConfig.getMap();
                Map<String, Map<String, String>> nameMap = (Map<String, Map<String, String>>) map.get("name");
                String paramName = nameMap.get(name).get("paramName");

                String path = codePropertie.getOutputDir() + File.separator
                        + codePropertie.getProjectPath().replaceAll("\\.", Matcher.quoteReplacement(File.separator)) + File.separator
                        + codePropertie.getModuleName() + File.separator + "param" + File.separator + paramName + StringPool.DOT_JAVA;
                return path;
            }
        });
        fileOutConfigList.add(new FileOutConfig("/myself/pageParam.java.vm"){
            @Override
            public String outputFile(TableInfo tableInfo) {
                String name = tableInfo.getName();
                Map<String, Object> map = injectionConfig.getMap();
                Map<String, Map<String, String>> nameMap = (Map<String, Map<String, String>>) map.get("name");
                String pageParamName = nameMap.get(name).get("pageParamName");

                String path = codePropertie.getOutputDir() + File.separator
                        + codePropertie.getProjectPath().replaceAll("\\.", Matcher.quoteReplacement(File.separator)) + File.separator
                        + codePropertie.getModuleName() + File.separator + "param" + File.separator + pageParamName + StringPool.DOT_JAVA;
                return path;
            }
        });

        injectionConfig.setFileOutConfigList(fileOutConfigList);
        return injectionConfig;
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
