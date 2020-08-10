package org.tiankafei.lock.zk;

import org.junit.Test;
import org.tiankafei.lock.Lock;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class ZooKeeperLockTest {

    @Test
    public void test01(){
        Lock lock = new ZooKeeperLock();
        lock.lock();
    }

}
