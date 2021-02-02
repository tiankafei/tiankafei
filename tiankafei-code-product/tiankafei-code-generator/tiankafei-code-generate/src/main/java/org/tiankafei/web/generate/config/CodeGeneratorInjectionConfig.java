package org.tiankafei.web.generate.config;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

import com.google.common.collect.Maps;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cglib.beans.BeanMap;
import org.tiankafei.web.common.constants.StringConstants;
import org.tiankafei.web.generate.properties.CfgProperties;
import org.tiankafei.web.generate.properties.CodeProperties;

/**
 * @author 魏双双
 * @since 1.0
 **/
public class CodeGeneratorInjectionConfig {

    /**
     * 注入配置，通过该配置，可注入自定义参数等操作以实现个性化操作
     * @param codeProperties
     * @return
     */
    public static InjectionConfig initInjectionConfig(CodeProperties codeProperties) {
        List<FileOutConfig> fileOutConfigList = Lists.newArrayList();

        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                ConfigBuilder config = getConfig();

                Map<String, Object> map = Maps.newHashMap();
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

                TableInfo tableInfo = config.getTableInfoList().get(0);
                CfgProperties cfgProperties = new CfgProperties();
                cfgProperties.setShiroAuthority(codeProperties.isShiroAuthority());
                cfgProperties.setLogFlag(codeProperties.isLogFlag());

                String keyColumnType = "Long";
                List<TableField> fields = tableInfo.getFields();
                for (TableField field : fields) {
                    if(field.isKeyFlag()){
                        keyColumnType = field.getColumnType().getType();
                    }
                }
                map.put("keyColumnType", keyColumnType);

                Set<String> importPackages = tableInfo.getImportPackages();
                List<String> importPackageList = importPackages.stream().filter(importPackage -> {
                    if (importPackage.endsWith(StringConstants.TABLE_NAME)
                            || importPackage.endsWith(StringConstants.ID_TYPE)
                            || importPackage.endsWith(StringConstants.MODEL)
                            || importPackage.endsWith(StringConstants.VERSION)
                            || importPackage.endsWith(StringConstants.TABLE_ID)
                            || importPackage.endsWith(StringConstants.FIELD_FILL)
                            || importPackage.endsWith(StringConstants.TABLE_LOGIC)
                            || importPackage.endsWith(StringConstants.TABLE_FIELD)) {
                        return false;
                    }
                    return true;
                }).collect(Collectors.toList());
                cfgProperties.setImportPackageList(importPackageList);

                Map beanMap = initOtherParam(tableInfo, cfgProperties, codeProperties, fileOutConfigList);
                map.putAll(beanMap);

                setMap(map);
            }
        };

        injectionConfig.setFileOutConfigList(fileOutConfigList);
        return injectionConfig;
    }

    private static Map initOtherParam(TableInfo tableInfo, CfgProperties cfgProperties, CodeProperties codeProperties, List<FileOutConfig> fileOutConfigList){
        String name = tableInfo.getName();

        String entityName = tableInfo.getEntityName();
        String entityConstName = firstToLowerCase(entityName);
        cfgProperties.setEntityConstName(entityConstName);
        String requestContext = entityConstName.replace("Entity", "");
        cfgProperties.setRequestContext(requestContext);

        String voName = entityName.replace("Entity", "Vo");
        setValue(cfgProperties::setVoClassName, cfgProperties::setVoConstName, voName);

        String listParamName = entityName.replace("Entity", "ListParam");
        setValue(cfgProperties::setListParamClassName, cfgProperties::setListParamConstName, listParamName);

        String countParamName = entityName.replace("Entity", "CountParam");
        setValue(cfgProperties::setCountParamClassName, cfgProperties::setCountParamConstName, countParamName);

        String deleteParamName = entityName.replace("Entity", "DeleteParam");
        setValue(cfgProperties::setDeleteParamClassName, cfgProperties::setDeleteParamConstName, deleteParamName);

        String checkParamName = entityName.replace("Entity", "CheckParam");
        setValue(cfgProperties::setCheckParamClassName, cfgProperties::setCheckParamConstName, checkParamName);

        String pageParamName = entityName.replace("Entity", "PageParam");
        setValue(cfgProperties::setPageParamClassName, cfgProperties::setPageParamConstName, pageParamName);

        String permission = underlineToColon(name);
        cfgProperties.setAuthority(permission);

        String serviceName = tableInfo.getServiceName();
        setValue(cfgProperties::setServiceConstName, serviceName);

        String mapperName = tableInfo.getMapperName();
        setValue(cfgProperties::setMapperConstName, mapperName);

        String controllerName = tableInfo.getControllerName();
        setValue(cfgProperties::setControllerConstName, controllerName);

        fileOutConfigList.add(getFileOutConfig("/myself/vo.java.vm", cfgProperties::getVoClassName, "vo", codeProperties));
        fileOutConfigList.add(getFileOutConfig("/myself/listParam.java.vm", cfgProperties::getListParamClassName, "param", codeProperties));
        fileOutConfigList.add(getFileOutConfig("/myself/countParam.java.vm", cfgProperties::getCountParamClassName, "param", codeProperties));
        fileOutConfigList.add(getFileOutConfig("/myself/deleteParam.java.vm", cfgProperties::getDeleteParamClassName, "param", codeProperties));
        fileOutConfigList.add(getFileOutConfig("/myself/checkParam.java.vm", cfgProperties::getCheckParamClassName, "param", codeProperties));
        fileOutConfigList.add(getFileOutConfig("/myself/pageParam.java.vm", cfgProperties::getPageParamClassName, "param", codeProperties));

        return BeanMap.create(cfgProperties);
    }

    /**
     * 设置值
     * @param consumer1
     * @param consumer2
     * @param paramName
     */
    private static void setValue(Consumer<String> consumer1, Consumer<String> consumer2, String paramName){
        consumer1.accept(paramName);
        consumer2.accept(firstToLowerCase(paramName));
    }

    /**
     * 设置值
     * @param consumer
     * @param name
     */
    private static void setValue(Consumer<String> consumer, String name){
        String constName = firstToLowerCase(name);
        consumer.accept(constName);
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
