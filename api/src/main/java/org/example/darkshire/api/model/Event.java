package org.example.darkshire.api.model;

import org.example.darkshire.api.enums.Attribute;

public interface Event<T extends Enum<T> & Attribute> {
    
    String getMessage();
    
    GameState<T> execute(GameState<T> state);
}