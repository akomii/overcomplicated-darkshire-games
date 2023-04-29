package org.example.darkshire.api.base;

import lombok.Getter;
import org.example.darkshire.api.enums.GameAttribute;
import org.example.darkshire.api.model.Event;
import org.example.darkshire.api.model.EventHistory;
import org.example.darkshire.api.model.GameState;
import org.example.darkshire.api.model.MainGame;

abstract class AbstractMainGame<T extends Enum<T> & GameAttribute> implements MainGame<T> {
    
    @Getter
    GameState<T> gameState;
    
    @Getter
    EventHistory<T> eventHistory;
    
    protected void executeEvent(Event<T> event) {
        gameState.consume(event);
    }
}
