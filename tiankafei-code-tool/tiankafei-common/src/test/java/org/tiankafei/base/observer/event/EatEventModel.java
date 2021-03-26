package org.tiankafei.base.observer.event;

import org.tiankafei.base.observer.EventModel;

/**
 * 吃饭
 *
 * @author tiankafei
 * @since 1.0
 */
public class EatEventModel extends EventModel {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public EatEventModel(Object source) {
        super(source);
    }

}
