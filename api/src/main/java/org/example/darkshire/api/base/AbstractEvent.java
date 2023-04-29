package org.example.darkshire.api.base;

import lombok.Getter;
import org.example.darkshire.api.enums.Attribute;
import org.example.darkshire.api.model.Event;

public abstract class AbstractEvent<T extends Enum<T> & Attribute> implements Event<T> {
    
    @Getter
    protected String message;
    
    protected AbstractEvent(String message) {
        this.message = message;
    }
}
