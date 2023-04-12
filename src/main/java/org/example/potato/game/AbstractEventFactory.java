package org.example.potato.game;

import org.example.potato.model.Event;

interface AbstractEventFactory {
    
    abstract Event createEvent(int eventType);
    
}
