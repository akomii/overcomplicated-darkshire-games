package org.example.darkshire.api.model;

import org.example.darkshire.api.enums.GameAttribute;

public interface MainGame<T extends Enum<T> & GameAttribute> {
    
    GameState<T> getGameState();
    
    EventHistory<T> getEventHistory();
}
