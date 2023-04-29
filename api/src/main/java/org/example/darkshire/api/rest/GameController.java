package org.example.darkshire.api.rest;

import org.example.darkshire.api.enums.GameAttribute;
import org.example.darkshire.api.model.EventHistory;
import org.example.darkshire.api.model.GameState;

public interface GameController<T extends Enum<T> & GameAttribute> {
    
    public void executeBaseEvent();
    
    public GameState<T> getGameState();
    
    public EventHistory<T> getEventHistory();
}
