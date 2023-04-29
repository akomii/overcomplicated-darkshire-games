package org.example.darkshire.api.factory;

import org.example.darkshire.api.enums.GameAttribute;
import org.example.darkshire.api.model.Event;

public interface EventFactory<T extends Enum<T> & GameAttribute> {
    
    Event<T> createEvent(int eventType);
}
