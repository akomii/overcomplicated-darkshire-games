package org.example.darkshire.common.base;

import org.example.darkshire.api.enums.GameAttribute;
import org.example.darkshire.api.factory.EventFactory;
import org.example.darkshire.api.model.Event;
import org.example.darkshire.common.model.EndingEvent;

public abstract class AbstractEndingEventFactory<T extends Enum<T> & GameAttribute> implements EventFactory<T> {
    
    public abstract EndingEvent<T> createEndingEvent(int eventType);
    
    @Override
    public Event<T> createEvent(int eventType) {
        return createEndingEvent(eventType);
    }
}
