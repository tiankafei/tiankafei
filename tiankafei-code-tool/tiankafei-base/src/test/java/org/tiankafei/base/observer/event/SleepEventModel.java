package org.tiankafei.base.observer.event;

import org.tiankafei.base.observer.EventModel;

/**
 * 睡觉
 *
 * @author tiankafei
 * @since 1.0
 */
public class SleepEventModel extends EventModel {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public SleepEventModel(Object source) {
        super(source);
    }

}
