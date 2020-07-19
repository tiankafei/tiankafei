package org.tiankafei.base.observer;

/**
 * @author tiankafei
 * @since 1.0
 */
public class ObserverEvent {

    protected Object object;

    public ObserverEvent(Object object){
        this.object = object;
    }

    public Object getSourceEvent() {
        return object;
    }

}
