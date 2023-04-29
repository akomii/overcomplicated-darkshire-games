package org.example.darkshire.api.model;

import org.example.darkshire.api.enums.GameAttribute;

public interface GameState<T extends Enum<T> & GameAttribute> {
    
    int get(T attribute);
    
    void increase(T attribute);
    
    void decrease(T attribute);
    
    boolean isFinished();
    
    void finishGame();
    
    void consume(Event<T> event);
}
