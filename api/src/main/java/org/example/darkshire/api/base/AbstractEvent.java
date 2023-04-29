package org.example.darkshire.api.base;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.example.darkshire.api.model.Event;

@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class AbstractEvent implements Event {
    
    @Getter
    String message;
    
    protected AbstractEvent(String message) {
        this.message = message;
    }
}
