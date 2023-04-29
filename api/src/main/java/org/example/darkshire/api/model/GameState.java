package org.example.darkshire.api.model;

import org.example.darkshire.api.enums.Attribute;

public interface GameState <T extends Enum<T> & Attribute> {
    
    int get(T attribute);
    
    void increase(T attribute);
    
    void decrease(T attribute);
    
    void finishGame();
}