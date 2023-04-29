package org.example.darkshire.api.factory;

import org.example.darkshire.api.enums.Attribute;
import org.example.darkshire.api.model.Event;

public interface EventFactory<T extends Enum<T> & Attribute> {
    
    abstract Event<T> createEvent(int eventType);
}
