package org.example.darkshire.common.rest;

import lombok.AllArgsConstructor;
import org.example.darkshire.api.MainGame;
import org.example.darkshire.api.enums.GameAttribute;
import org.example.darkshire.api.model.EventHistory;
import org.example.darkshire.api.model.GameState;
import org.example.darkshire.api.rest.GameController;

@AllArgsConstructor
public abstract class AbstractGameController<T extends Enum<T> & GameAttribute> implements GameController<T> {
    
    protected MainGame<T> mainGame;
    
    @Override
    public void executeBaseEvent() {
        mainGame.executeBaseEvent();
    }
    
    @Override
    public GameState<T> getGameState() {
        return mainGame.getGameState();
    }
    
    @Override
    public EventHistory<T> getEventHistory() {
        return mainGame.getEventHistory();
    }
}
