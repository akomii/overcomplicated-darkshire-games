package org.example.darkshire.api.base;

import lombok.Getter;
import org.example.darkshire.api.enums.Attribute;

public abstract class AbstractDiceRollEvent<T extends Enum<T> & Attribute> extends AbstractEvent<T> {
    
    @Getter
    protected int diceRoll;
    
    protected AbstractDiceRollEvent(int diceRoll, String message) {
        super(message);
        this.diceRoll = diceRoll;
    }
}
