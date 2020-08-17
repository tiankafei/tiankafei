package org.tiankafei.lock.zk.utils;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import org.apache.zookeeper.ZooKeeper;
import org.tiankafei.lock.zk.DefaultWatcher;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class ZooKeeperUtil {

    private ZooKeeperUtil(){}

    /**
     * 获取 ZooKeeper 对象
     * @param address
     * @return
     */
    public static ZooKeeper getZooKeeper(String address){
        try {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ZooKeeper zooKeeper = new ZooKeeper(address, 1000, new DefaultWatcher(countDownLatch));

            countDownLatch.await();
            return zooKeeper;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

}
