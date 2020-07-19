package org.tiankafei.base.observer;

/**
 * @author tiankafei
 * @since 1.0
 */
public class ObserverParam {

    protected Object object;

    public ObserverParam(Object object){
        this.object = object;
    }

    public Object getSourceEvent() {
        return object;
    }

}
