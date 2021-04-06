package org.tiankafei.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.common.enums.BaseEnum;
import org.tiankafei.common.exceptions.CommonException;

/**
 * Properties资源文件处理工具类
 *
 * @Author tiankafei
 * @Date 2019/10/22
 * @Version V1.0
 **/
public class PropertiesUtil {

    private PropertiesUtil() {

    }

    /**
     * 获取Properties对象
     *
     * @param propertiesName 资源文件名
     * @return 返回加载后的Properties文件对象
     */
    public static Properties getInstance(String propertiesName) {
        InputStream inputStream = null;
        try {
            inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(propertiesName);
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("加载配置文件失败！");
        } finally {
            DataStreamUtil.closeInputStream(inputStream);
        }
    }

    /**
     * 根据key获取值
     *
     * @param key            key标识
     * @param propertiesName 资源文件参数的唯一标识
     * @return 资源文件参数值
     */
    public static String getValue(String key, String propertiesName) {
        return PropertiesUtil.getInstance(propertiesName).getProperty(key);
    }

    /**
     * 获取字符串值
     *
     * @param properties 资源配置文件
     * @param paramName  参数名称
     * @return 字符串值
     */
    public static String getStringValue(Properties properties, String paramName) {
        return properties.getProperty(paramName);
    }

    /**
     * 获取数值型值
     *
     * @param properties 资源配置文件
     * @param paramName  参数名称
     * @return 数值型值
     */
    public static Integer getIntegerValue(Properties properties, String paramName) {
        Integer integer = 0;

        String paramNameValue = properties.getProperty(paramName);
        if (StringUtils.isNotEmpty(paramNameValue)) {
            try {
                integer = Integer.valueOf(paramNameValue);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                throw new CommonException("参数名称：" + paramName + "只能是数值型，请确认！");
            }
        }

        return integer;
    }

    /**
     * 获取boolean类型值
     *
     * @param properties 资源配置文件
     * @param paramName  参数名称
     * @return boolean类型值
     */
    public static boolean getBooleanValue(Properties properties, String paramName) {
        boolean result = false;

        String paramNameValue = properties.getProperty(paramName);
        if (StringUtils.isNotEmpty(paramNameValue)) {
            if (BaseEnum.TRUE.getValue().equals(paramNameValue)) {
                result = Boolean.TRUE;
            } else if (BaseEnum.FALSE.getValue().equals(paramNameValue)) {
                result = Boolean.FALSE;
            } else {
                throw new CommonException("参数名称：" + paramName + "只能是boolean类型值，请确认！");
            }
        }

        return result;
    }

    /**
     * 获取Properties对象
     *
     * @param propertiesFilePath properties文件路径
     * @return 返回加载后的Properties文件对象
     */
    public static Properties getInstanceFromFilePath(String propertiesFilePath) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(propertiesFilePath));
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new CommonException("访问的文件不存在！");
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("加载配置文件失败！");
        } finally {
            DataStreamUtil.closeInputStream(inputStream);
        }
    }

    /**
     * 给文件赋值新增属性
     *
     * @param key                key标识
     * @param value              值
     * @param propertiesFilePath 资源文件参数的唯一标识
     */
    public static void setValue(String key, String value, String propertiesFilePath) {
        Properties properties = PropertiesUtil.getInstanceFromFilePath(propertiesFilePath);
        properties.setProperty(key, value);
        saveFile(propertiesFilePath, properties);
    }

    /**
     * 保存配置文件
     *
     * @param propertiesFilePath 资源文件路径
     * @param properties         properties文件对象
     */
    private static void saveFile(String propertiesFilePath, Properties properties) {
        File file = new File(propertiesFilePath);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            properties.store(fileOutputStream, null);
            DataStreamUtil.closeOutputStream(fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new CommonException("访问的文件不存在！");
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("加载配置文件失败！");
        } finally {
            DataStreamUtil.closeOutputStream(fileOutputStream);
        }
    }

}
