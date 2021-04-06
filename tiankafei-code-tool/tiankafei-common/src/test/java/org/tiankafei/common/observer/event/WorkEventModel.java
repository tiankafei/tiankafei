package org.tiankafei.common.observer.event;

import org.tiankafei.common.observer.EventModel;

/**
 * 工作
 *
 * @author tiankafei
 * @since 1.0
 */
public class WorkEventModel extends EventModel {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public WorkEventModel(Object source) {
        super(source);
    }

}
