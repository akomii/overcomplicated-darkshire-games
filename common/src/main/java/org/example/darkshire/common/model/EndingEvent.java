package org.example.darkshire.common.model;

import org.example.darkshire.api.enums.GameAttribute;
import org.example.darkshire.api.model.GameState;

public class EndingEvent<T extends Enum<T> & GameAttribute> extends AbstractEvent<T> {
    
    public EndingEvent(String message) {
        super(message);
    }
    
    @Override
    public void execute(GameState<T> state) {
        state.finishGame();
    }
}
