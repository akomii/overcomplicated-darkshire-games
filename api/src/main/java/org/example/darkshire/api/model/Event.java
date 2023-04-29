package org.example.darkshire.api.model;

import org.example.darkshire.api.enums.GameAttribute;

public interface Event<T extends Enum<T> & GameAttribute> {
    
    String getMessage();
    
    void execute(GameState<T> state);
}
