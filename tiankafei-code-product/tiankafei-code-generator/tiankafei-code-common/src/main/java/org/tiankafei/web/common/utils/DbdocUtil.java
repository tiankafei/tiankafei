package org.tiankafei.web.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.base.util.FileUtil;
import org.tiankafei.web.common.properties.DbDocProperties;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class DbdocUtil {

    /**
     * 创建生辰数据库文档的对象
     *
     * @param jsonName json文件的名字
     * @return
     * @throws BaseException
     */
    public static List<DbDocProperties> createDatabaseDocumentProperties(String jsonName) throws BaseException {
        List<DbDocProperties> list = Lists.newArrayList();
        String json = FileUtil.readJsonFile(jsonName);
        JSONObject jsonObject = JSON.parseObject(json);

        DbDocProperties commonProperties = null;
        String key = "parent";
        if (jsonObject.containsKey(key)) {
            JSONObject parent = jsonObject.getJSONObject("parent");
            commonProperties = parent.toJavaObject(DbDocProperties.class);
        }

        key = "data";
        if (!jsonObject.containsKey(key)) {
            throw new BaseException("json文件中没有 data 集合属性");
        }
        JSONArray data = jsonObject.getJSONArray(key);
        List<DbDocProperties> propertiesList = data.toJavaList(DbDocProperties.class);
        for (int index = 0, length = propertiesList.size(); index < length; index++) {
            DbDocProperties properties = propertiesList.get(index);

            setValue(properties::getDriverClassName, properties::setDriverClassName, commonProperties.getDriverClassName(), "数据库驱动名称");
            setValue(properties::getJdbcUrl, properties::setJdbcUrl, commonProperties.getJdbcUrl(), "数据库连接url");
            setValue(properties::getUsername, properties::setUsername, commonProperties.getUsername(), "数据库用户名");
            setValue(properties::getPassword, properties::setPassword, commonProperties.getPassword(), "数据库用户密码");
            setValue(properties::getFileDirectory, properties::setFileDirectory, commonProperties.getFileDirectory(), "生成数据库文档的目录");
            setValue(properties::getFileName, properties::setFileName, commonProperties.getFileName(), "生成的数据库文档的文件名");
            setValue(properties::getVersion, properties::setVersion, commonProperties.getVersion(), "版本");
            setValue(properties::getDescription, properties::setDescription, commonProperties.getDescription(), "描述");

            addValue(properties::getIgnoreTableNameList, properties::setIgnoreTableNameList, commonProperties.getIgnoreTableNameList());
            addValue(properties::getIgnoreTablePrefixList, properties::setIgnoreTablePrefixList, commonProperties.getIgnoreTablePrefixList());
            addValue(properties::getIgnoreTableSuffixList, properties::setIgnoreTableSuffixList, commonProperties.getIgnoreTableSuffixList());
            addValue(properties::getDesignatedTableNameList, properties::setDesignatedTableNameList, commonProperties.getDesignatedTableNameList());
            addValue(properties::getDesignatedTablePrefixList, properties::setDesignatedTablePrefixList, commonProperties.getDesignatedTablePrefixList());
            addValue(properties::getDesignatedTableSuffixList, properties::setDesignatedTableSuffixList, commonProperties.getDesignatedTableSuffixList());
            list.add(properties);
        }
        return list;
    }

    private static <T> void setValue(Supplier<T> supplier, Consumer<T> consumer, T value, String message) throws BaseException {
        T t = supplier.get();
        if( t == null || StringUtils.isBlank(t.toString())){
            if(value == null || StringUtils.isBlank(value.toString())){
                throw new BaseException(message + "不能为空！");
            }
            consumer.accept(value);
        }
    }

    private static void addValue(Supplier<List<String>> supplier, Consumer<List<String>> consumer, List<String> valueList) throws BaseException {
        List<String> dataList = supplier.get();
        if(dataList == null){
            dataList = Lists.newArrayList();
        }
        if(valueList != null){
            dataList.addAll(valueList);
            consumer.accept(dataList);
        }
    }

}
