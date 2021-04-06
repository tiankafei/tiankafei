package org.tiankafei.common.observer;

/**
 * @author tiankafei
 * @since 1.0
 */
public interface EventListener<E extends EventModel> {

    void onEvent(E event);

}
