package org.example.darkshire.common.base;

import lombok.Getter;
import org.example.darkshire.api.enums.GameAttribute;
import org.example.darkshire.api.model.Event;

public abstract class AbstractEvent<T extends Enum<T> & GameAttribute> implements Event<T> {
    
    @Getter
    protected String message;
    
    protected AbstractEvent(String message) {
        this.message = message;
    }
}
