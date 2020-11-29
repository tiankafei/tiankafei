package org.tiankafei.lock.zk;

import java.util.concurrent.locks.Lock;
import org.junit.Test;

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
