package org.tiankafei.lock.zk;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class WatchCallBack implements Watcher, AsyncCallback.StringCallback {

    @Override
    public void process(WatchedEvent event) {

    }

    @Override
    public void processResult(int rc, String path, Object ctx, String name) {

    }

}
