package org.example.darkshire.api.model;

import org.example.darkshire.api.enums.GameAttribute;

public interface MainGame<T extends Enum<T> & GameAttribute> {
    
    void executeEvent(Event<T> event);
    
    GameState<T> getGameState();
    
    EventHistory<T> getEventHistory();
}
