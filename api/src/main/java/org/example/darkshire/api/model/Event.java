package org.example.darkshire.api.model;

import org.example.darkshire.api.enums.GameAttribute;

public interface Event<T extends Enum<T> & GameAttribute> {
    
    String getMessage();
    
    GameState<T> execute(GameState<T> state);
}