package org.tiankafei.lock.zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.tiankafei.lock.AbstractLock;
import org.tiankafei.lock.Lock;
import org.tiankafei.lock.zk.utils.ZooKeeperUtil;

/**
 * 分布式锁的接口
 *
 * @author tiankafei
 * @since 1.0
 **/
public class ZooKeeperLock extends AbstractLock {

    private ZooKeeper zooKeeper;

    public ZooKeeperLock(){
        zooKeeper = ZooKeeperUtil.getZooKeeper("10.0.0.30:2181,10.0.0.31:2181,10.0.0.32:2181/testLock");
    }

    @Override
    public void lock() {
        String threadName = Thread.currentThread().getName();
        zooKeeper.create("/lock", threadName.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL, new WatchCallBack(), "123456");


    }

    @Override
    public void unlock() {

    }

}
