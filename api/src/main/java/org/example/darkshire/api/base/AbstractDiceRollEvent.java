package org.example.darkshire.api.base;

import lombok.Getter;
import org.example.darkshire.api.enums.GameAttribute;

public abstract class AbstractDiceRollEvent<T extends Enum<T> & GameAttribute> extends AbstractEvent<T> {
    
    @Getter
    protected int diceRoll;
    
    protected AbstractDiceRollEvent(int diceRoll, String message) {
        super(message);
        this.diceRoll = diceRoll;
    }
}
