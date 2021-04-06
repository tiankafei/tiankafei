package org.tiankafei.rocksdb.util;

import com.google.common.collect.Lists;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.rocksdb.ColumnFamilyDescriptor;
import org.rocksdb.ColumnFamilyHandle;
import org.rocksdb.ColumnFamilyOptions;
import org.rocksdb.DBOptions;
import org.rocksdb.Options;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;
import org.rocksdb.RocksIterator;
import org.tiankafei.common.exceptions.CommonException;
import org.tiankafei.common.util.DataStreamUtil;
import org.tiankafei.rocksdb.constants.RocksdbConstants;

/**
 * 描述:
 * rocksdb工具类
 *
 * @author 甜咖啡
 */
public class RocksdbUtil<T> {

    private RocksDB rocksDb;

    /**
     * 是否带分区的rocksdb
     */
    private boolean rocksdbPartitionFlag;

    /**
     * 分区对应的列簇
     */
    private Map<String, ColumnFamilyHandle> columnFamilyHandleMap = new HashMap<String, ColumnFamilyHandle>();

    /**
     * 构造rocksdb工具
     *
     * @param rocksdbPartitionFlag rocks是否带分区
     * @param rocksdbPath          rocksdb数据库路径
     */
    public RocksdbUtil(boolean rocksdbPartitionFlag, String rocksdbPath) {
        this(rocksdbPartitionFlag, rocksdbPath, Lists.newArrayList());
    }

    /**
     * 构造rocksdb工具
     *
     * @param rocksdbPartitionFlag     rocks是否带分区
     * @param rocksdbPath              rocksdb数据库路径
     * @param rocksdbPartitionNameList 要创建的分区列表
     */
    public RocksdbUtil(boolean rocksdbPartitionFlag, String rocksdbPath, List<String> rocksdbPartitionNameList) {
        File file = new File(rocksdbPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        RocksDB.loadLibrary();

        this.rocksdbPartitionFlag = rocksdbPartitionFlag;
        if (rocksdbPartitionFlag) {
            //带分区
            initPartitionRocksDb(rocksdbPath, rocksdbPartitionNameList);
        } else {
            //不带分区
            initRocksDb(rocksdbPath);
        }
    }

    /**
     * 初始化rocksdb数据库
     *
     * @param rocksdbPath rocksdb数据库路径
     */
    private void initRocksDb(String rocksdbPath) {
        try {
            Options options = new Options();
            options.setCreateIfMissing(true);
            options.setCreateIfMissing(true);

            int maxValue = 1000;
            options.setMaxBackgroundCompactions(maxValue);
            options.setMaxBackgroundFlushes(maxValue);
            options.setMaxBackgroundJobs(maxValue);
            options.setMaxFileOpeningThreads(maxValue);
            options.setMaxOpenFiles(maxValue);
            options.setMaxWriteBufferNumber(maxValue);

            long maxSize = 1024 * 1024 * 100;
            options.setMaxLogFileSize(maxSize);
            options.setMaxTotalWalSize(maxSize);
            options.setDbWriteBufferSize(maxSize);
            options.setWriteBufferSize(maxSize);

            rocksDb = RocksDB.open(options, rocksdbPath);
        } catch (RocksDBException e) {
            e.printStackTrace();
            throw new CommonException("初始化数据文件失败！");
        }
    }

    /**
     * 初始化带分区的rocksdb数据库
     *
     * @param rocksdbPath              rocksdb数据库路径
     * @param rocksdbPartitionNameList 要创建的分区列表
     */
    private void initPartitionRocksDb(String rocksdbPath, List<String> rocksdbPartitionNameList) {
        try {
            Options options = new Options();
            options.setCreateIfMissing(true);
            //分区描述列表
            List<ColumnFamilyDescriptor> columnFamilyDescriptorList = Lists.newArrayList();
            List<byte[]> cfs = RocksDB.listColumnFamilies(options, rocksdbPath);
            if (cfs.size() > 0) {
                for (byte[] cf : cfs) {
                    columnFamilyDescriptorList.add(new ColumnFamilyDescriptor(cf, new ColumnFamilyOptions()));
                }
            } else {
                columnFamilyDescriptorList.add(new ColumnFamilyDescriptor(RocksDB.DEFAULT_COLUMN_FAMILY, new ColumnFamilyOptions()));
            }
            DBOptions dbOptions = new DBOptions();

            int maxValue = 1000;
            options.setMaxBackgroundCompactions(maxValue);
            options.setMaxBackgroundFlushes(maxValue);
            options.setMaxBackgroundJobs(maxValue);
            options.setMaxFileOpeningThreads(maxValue);
            options.setMaxOpenFiles(maxValue);
            options.setMaxWriteBufferNumber(maxValue);

            long maxSize = 1024 * 1024 * 100;
            options.setMaxLogFileSize(maxSize);
            options.setMaxTotalWalSize(maxSize);
            options.setDbWriteBufferSize(maxSize);
            options.setWriteBufferSize(maxSize);

            //分区列表
            int columnFamilyDescriptorLength = columnFamilyDescriptorList.size();
            List<ColumnFamilyHandle> columnFamilyHandleList = new ArrayList<ColumnFamilyHandle>(columnFamilyDescriptorLength);
            //
            rocksDb = RocksDB.open(dbOptions, rocksdbPath, columnFamilyDescriptorList, columnFamilyHandleList);
            for (int index = 0; index < columnFamilyDescriptorLength; index++) {
                ColumnFamilyDescriptor columnFamilyDescriptor = columnFamilyDescriptorList.get(index);
                String rocksdbPartitionName = new String(columnFamilyDescriptor.getName());
                //已经创建的分区
                ColumnFamilyHandle columnFamilyHandle = columnFamilyHandleList.get(index);
                columnFamilyHandleMap.put(rocksdbPartitionName, columnFamilyHandle);
            }
            //需要创建的分区长度
            int rocksdbPartitionNameLength = rocksdbPartitionNameList.size();
            for (int index = 0; index < rocksdbPartitionNameLength; index++) {
                //需要创建的分区
                String rocksdbPartitionName = rocksdbPartitionNameList.get(index);
                createColumnFamily(rocksdbPartitionName);
            }
        } catch (RocksDBException e) {
            e.printStackTrace();
            throw new CommonException("初始化带分区的数据文件失败！");
        }
    }

    /**
     * 创建分区列簇
     *
     * @param rocksdbPartitionName 分区名称
     */
    public void createColumnFamily(String rocksdbPartitionName) {
        try {
            if (!rocksdbPartitionFlag) {
                throw new CommonException("创建分区失败，只有新建rocksdb分区对象才能创建分区！");
            }
            if (!columnFamilyHandleMap.containsKey(rocksdbPartitionName)) {
                //创建分区
                ColumnFamilyHandle columnFamilyHandle = null;
                columnFamilyHandle = rocksDb.createColumnFamily(new ColumnFamilyDescriptor(rocksdbPartitionName.getBytes(), new ColumnFamilyOptions()));
                columnFamilyHandleMap.put(rocksdbPartitionName, columnFamilyHandle);
            }
        } catch (RocksDBException e) {
            e.printStackTrace();
            throw new CommonException("创建列簇失败！");
        }
    }

    /**
     * 根据key获取分区名称
     *
     * @param key 键
     * @return 分区名称
     */
    private String getRocksdbPartitionNameFromKey(String key) {
        if (key.contains(RocksdbConstants.rocksdbKeySplit)) {
            String rocksdbPartitionName = key.split(RocksdbConstants.rocksdbKeySplit)[0];
            return rocksdbPartitionName;
        } else {
            throw new CommonException(key + "不符合命名规范，请确认！");
        }
    }

    /**
     * 获取默认分区的key
     *
     * @param key 键
     * @return 新key
     */
    public String getKey(String key) {
        return getKey(new String(RocksDB.DEFAULT_COLUMN_FAMILY), key);
    }

    /**
     * 根据分区名称和key组装新的key
     *
     * @param rocksdbPartitionName 分区名称
     * @param key                  键
     * @return 新key
     */
    public String getKey(String rocksdbPartitionName, String key) {
        return rocksdbPartitionName + RocksdbConstants.rocksdbKeySplit + key;
    }

    /**
     * 获取分区列簇
     *
     * @param key 键
     * @return 分区列簇
     */
    private ColumnFamilyHandle getColumnFamilyHandle(String key) {
        String rocksdbPartitionName = getRocksdbPartitionNameFromKey(key);
        ColumnFamilyHandle columnFamilyHandle = columnFamilyHandleMap.get(rocksdbPartitionName);
        return columnFamilyHandle;
    }

    /**
     * 设置键的数据
     *
     * @param key    键
     * @param object 数据
     */
    public void setValue(String key, T object) {
        try {
            if (rocksdbPartitionFlag) {
                rocksDb.put(getColumnFamilyHandle(key), key.getBytes(), DataStreamUtil.getByteArray(object));
            } else {
                rocksDb.put(key.getBytes(), DataStreamUtil.getByteArray(object));
            }
        } catch (RocksDBException e) {
            e.printStackTrace();
            throw new CommonException("存储数据失败！");
        }
    }

    /**
     * 获取指定键的数据
     *
     * @param key 键
     * @return 指定键的数据
     */
    public T getValue(String key) {
        try {
            byte[] byteArray = null;
            if (rocksdbPartitionFlag) {
                byteArray = rocksDb.get(getColumnFamilyHandle(key), key.getBytes());
            } else {
                byteArray = rocksDb.get(key.getBytes());
            }
            Object object = DataStreamUtil.getByteToObject(byteArray);
            return (T) object;
        } catch (RocksDBException e) {
            e.printStackTrace();
            throw new CommonException("获取数据失败！");
        }
    }

    /**
     * 获取指定键集合的数据集合
     *
     * @param keyList 键集合
     * @return 指定键集合的数据集合
     */
    public Map<String, T> getValueArray(List<String> keyList) {
        try {
            int keyLength = keyList.size();
            Map<String, T> resultMap = new HashMap<String, T>(keyLength);
            //分区集合
            List<ColumnFamilyHandle> columnFamilyHandleList = Lists.newArrayListWithCapacity(keyLength);
            //键集合
            List<byte[]> keyBytes = Lists.newArrayListWithCapacity(keyLength);
            for (int index = 0; index < keyLength; index++) {
                String key = keyList.get(index);
                keyBytes.add(key.getBytes());
                columnFamilyHandleList.add(getColumnFamilyHandle(key));
            }

            //rocksdb批量查询
            List<byte[]> valueBytes = null;
            if (rocksdbPartitionFlag) {
                valueBytes = rocksDb.multiGetAsList(columnFamilyHandleList, keyBytes);
            } else {
                valueBytes = rocksDb.multiGetAsList(keyBytes);
            }
            Map<byte[], byte[]> valueMap = new HashMap<>();
            if (valueBytes != null && !valueBytes.isEmpty()) {
                for (int index = 0, length = keyBytes.size(); index < length; index++) {
                    byte[] keyByte = keyBytes.get(index);
                    byte[] valueByte = valueBytes.get(index);
                    valueMap.put(keyByte, valueByte);
                }
            }
            Iterator<byte[]> it = valueMap.keySet().iterator();
            while (it.hasNext()) {
                byte[] keyArray = it.next();
                byte[] valueArray = valueMap.get(keyArray);

                String key = new String(keyArray);
                T value = (T) DataStreamUtil.getByteToObject(valueArray);
                resultMap.put(key, value);
            }
            return resultMap;
        } catch (RocksDBException e) {
            e.printStackTrace();
            throw new CommonException("获取数据集失败！");
        }
    }

    /**
     * 获取所有的数据
     *
     * @return 所有的数据
     */
    public Map<String, T> getValueArray() {
        return getValueArray("", 0);
    }

    /**
     * 获取指定前缀的数据
     *
     * @param prefix 指定前缀
     * @return 指定前缀的数据
     */
    public Map<String, T> getValueArray(String prefix) {
        return getValueArray(prefix, 0);
    }

    /**
     * 获取指定个数的数据
     *
     * @param count 指定个数
     * @return 指定个数的数据
     */
    public Map<String, T> getValueArray(int count) {
        return getValueArray("", count);
    }

    /**
     * 获取指定前缀和个数的数据
     *
     * @param prefix 指定前缀
     * @param count  指定个数
     * @return 指定前缀和个数的数据
     */
    public Map<String, T> getValueArray(String prefix, int count) {
        Map<String, T> resultMap = new HashMap<String, T>(10);

        int index = 0;
        RocksIterator iter = null;
        if (rocksdbPartitionFlag) {
            iter = rocksDb.newIterator(getColumnFamilyHandle(prefix));
        } else {
            iter = rocksDb.newIterator();
        }
        for (iter.seekToFirst(); iter.isValid(); iter.next()) {
            String key = new String(iter.key());
            if (key.startsWith(prefix)) {
                T value = (T) DataStreamUtil.getByteToObject(iter.value());
                resultMap.put(key, value);
                index++;
            }
            if (count > 0) {
                if (index == count) {
                    break;
                }
            }
        }
        return resultMap;
    }

    /**
     * 删除键
     *
     * @param key 键
     */
    public void removeKey(String key) {
        try {
            if (rocksdbPartitionFlag) {
                rocksDb.delete(getColumnFamilyHandle(key), key.getBytes());
            } else {
                rocksDb.delete(key.getBytes());
            }
        } catch (RocksDBException e) {
            e.printStackTrace();
            throw new CommonException("删除数据失败！");
        }
    }

}
