package org.tiankafei.rocksdb;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Properties;
import org.junit.Before;
import org.junit.Test;
import org.tiankafei.common.util.PropertiesUtil;
import org.tiankafei.rocksdb.util.RocksdbUtil;

/**
 * 描述:
 *
 * @author 甜咖啡
 */
public class RocksdbTest {

    private String rocksdbPartitionFilePath;
    private String rocksdbPath;

    @Before
    public void init() {
        Properties rocksdbProperties = PropertiesUtil.getInstance("rocksdb.properties");
        rocksdbPartitionFilePath = PropertiesUtil.getStringValue(rocksdbProperties, "rocksdbPartitionFilePath");
        rocksdbPath = PropertiesUtil.getStringValue(rocksdbProperties, "rocksdbFilePath");
    }


    @Test(expected = Exception.class)
    public void rocksdbTest() {
        List<String> rocksdbPartitionNameList = Lists.newArrayList();
        rocksdbPartitionNameList.add("testPartition");
        boolean rocksdbPartitionFlag = true;
        RocksdbUtil rocksdbUtil = new RocksdbUtil(rocksdbPartitionFlag, rocksdbPartitionFilePath, rocksdbPartitionNameList);
        testRocksdb(rocksdbUtil);
        System.out.println("rocksdb分区测试=======================");

        rocksdbPartitionFlag = false;
        rocksdbUtil = new RocksdbUtil(rocksdbPartitionFlag, rocksdbPath);
        testRocksdb(rocksdbUtil);
        System.out.println("rocksdb测试=======================");
    }

    private void testRocksdb(RocksdbUtil rocksdbUtil) {
        String key = rocksdbUtil.getKey("Hello");
        String value = "Word";
        rocksdbUtil.setValue(key, value);
        System.out.println(rocksdbUtil.getValue(key));

        String key1 = rocksdbUtil.getKey("Hello1");
        String value1 = "Word1";
        rocksdbUtil.setValue(key1, value1);
        System.out.println(rocksdbUtil.getValue(key1));

        List<String> keyList = Lists.newArrayList();
        keyList.add(key);
        keyList.add(key1);
        System.out.println(rocksdbUtil.getValueArray(keyList));

        rocksdbUtil.removeKey(key);
        System.out.println(rocksdbUtil.getValueArray(keyList));

        rocksdbUtil.removeKey(key1);
        System.out.println(rocksdbUtil.getValueArray(keyList));
    }

}
