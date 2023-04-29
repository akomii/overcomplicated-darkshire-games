package org.example.darkshire.api.factory;

import org.example.darkshire.api.model.Event;

public interface EventFactory {
    
    abstract Event createEvent(int eventType);
}
