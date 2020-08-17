package org.tiankafei.lock.zk;

import java.util.concurrent.CountDownLatch;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class DefaultWatcher implements Watcher {

    CountDownLatch countDownLatch;

    public DefaultWatcher(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        switch (watchedEvent.getState()) {
            case Disconnected:
                break;
            case SyncConnected:
                countDownLatch.countDown();
                break;
            case AuthFailed:
                break;
            case ConnectedReadOnly:
                break;
            case SaslAuthenticated:
                break;
            case Expired:
                break;
            default: break;
        }
    }

}
