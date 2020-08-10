package org.tiankafei.lock.zk;

import org.apache.zookeeper.ZooKeeper;
import org.tiankafei.lock.Lock;
import org.tiankafei.lock.zk.utils.ZooKeeperUtil;

/**
 * 分布式锁的接口
 *
 * @author tiankafei
 * @since 1.0
 **/
public class ZooKeeperLock implements Lock {

    private ZooKeeper zooKeeper;

    public ZooKeeperLock(){
        zooKeeper = ZooKeeperUtil.getZooKeeper("10.0.0.30:2181,10.0.0.31:2181,10.0.0.32:2181/testLock");
    }

    @Override
    public void lock() {

    }

    @Override
    public void unlock() {

    }

}
