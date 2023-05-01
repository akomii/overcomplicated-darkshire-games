package org.example.darkshire.common.model;

import org.example.darkshire.api.enums.GameAttribute;
import org.example.darkshire.api.model.GameState;

public class BaseEvent<T extends Enum<T> & GameAttribute> extends AbstractDiceRollEvent<T> {
    
    public BaseEvent(int diceRoll, String message) {
        super(diceRoll, message);
    }
    
    @Override
    public void execute(GameState<T> state) {}
}
