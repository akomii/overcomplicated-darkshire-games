package org.example.potato.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PROTECTED)
@Getter
public abstract class Event {
    
    String message;
    
    protected Event(String message) {
        this.message = message;
    }
    
    public abstract GameState execute(GameState state);
}
