package org.tiankafei.base.observer;

import java.util.EventObject;

/**
 * 观察者接口
 * @author tiankafei
 * @since 1.0
 */
public interface IObserver {

    void publishEvent(EventObject event);

}
