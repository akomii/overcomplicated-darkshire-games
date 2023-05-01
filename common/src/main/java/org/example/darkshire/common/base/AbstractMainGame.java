package org.example.darkshire.common.base;

import lombok.Getter;
import org.example.darkshire.api.enums.GameAttribute;
import org.example.darkshire.api.model.Event;
import org.example.darkshire.api.model.EventHistory;
import org.example.darkshire.api.model.GameState;
import org.example.darkshire.api.MainGame;

public abstract class AbstractMainGame<T extends Enum<T> & GameAttribute> implements MainGame<T> {
    
    @Getter
    protected GameState<T> gameState;
    
    @Getter
    protected EventHistory<T> eventHistory;
    
    protected void executeEvent(Event<T> event) {
        gameState.consume(event);
    }
}
