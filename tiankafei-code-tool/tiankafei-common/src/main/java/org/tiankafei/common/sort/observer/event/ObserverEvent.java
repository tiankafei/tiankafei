package org.tiankafei.common.sort.observer.event;

import lombok.Data;

@Data
public class ObserverEvent {

    private Object object;

    public ObserverEvent() {
    }

    public ObserverEvent(Object object) {
        this.object = object;
    }
}
