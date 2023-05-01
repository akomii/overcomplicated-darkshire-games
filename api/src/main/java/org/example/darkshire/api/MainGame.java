package org.example.darkshire.api;

import org.example.darkshire.api.enums.GameAttribute;
import org.example.darkshire.api.model.EventHistory;
import org.example.darkshire.api.model.GameState;

public interface MainGame<T extends Enum<T> & GameAttribute> {
    
    void executeBaseEvent();
    
    GameState<T> getGameState();
    
    EventHistory<T> getEventHistory();
}
