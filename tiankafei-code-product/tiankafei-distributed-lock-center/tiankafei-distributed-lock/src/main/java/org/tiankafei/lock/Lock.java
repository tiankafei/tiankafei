package org.tiankafei.lock;

/**
 * 分布式锁的接口
 *
 * @author tiankafei
 * @since 1.0
 **/
public interface Lock {

    /**
     * 加锁
     */
    void lock();

    /**
     * 释放锁
     */
    void unlock();

}
