package org.tiankafei.base.observer.event;

import java.util.EventObject;

/**
 * 睡觉
 *
 * @author tiankafei
 * @since 1.0
 */
public class SleepEventObject extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public SleepEventObject(Object source) {
        super(source);
    }

}
