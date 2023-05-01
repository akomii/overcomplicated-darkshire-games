package org.example.darkshire.common.base;

import org.example.darkshire.api.enums.GameAttribute;
import org.example.darkshire.api.factory.EventFactory;
import org.example.darkshire.api.model.Event;
import org.example.darkshire.common.model.BaseEvent;

public abstract class AbstractBaseEventFactory<T extends Enum<T> & GameAttribute> implements EventFactory<T> {
    
    public abstract BaseEvent<T> createBaseEvent(int eventType);
    
    @Override
    public Event<T> createEvent(int eventType) {
        return createBaseEvent(eventType);
    }
}
