package org.tiankafei.base.observer;

import java.io.Serializable;

/**
 * @author tiankafei
 * @since 1.0
 */
public class EventObject implements Serializable {

    protected transient Object source;

    public EventObject(Object source){
        if(source == null){
            throw new RuntimeException("传入的参数对象是空的");
        }
        this.source = source;
    }

    public Object getSource(){
        return source;
    }

    @Override
    public String toString() {
        return "EventObject{" +
                "source=" + source +
                '}';
    }
}
