package org.example.darkshire.api.rest;

import org.example.darkshire.api.enums.Attribute;
import org.example.darkshire.api.model.EventHistory;
import org.example.darkshire.api.model.GameState;

public interface Controller<T extends Enum<T> & Attribute> {
    
    public void executeBaseEvent();
    
    public GameState<T> getGameState();
    
    public EventHistory<T> getEventHistory();
}
