package org.tiankafei.base.observer.event;

import java.util.EventObject;

/**
 * 吃饭
 *
 * @author tiankafei
 * @since 1.0
 */
public class EatEventObject extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public EatEventObject(Object source) {
        super(source);
    }

}
