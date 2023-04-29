package org.example.darkshire.api.base;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class AbstractDiceRollEvent extends AbstractEvent {
    
    @Getter
    int diceRoll;
    
    protected AbstractDiceRollEvent(int diceRoll, String message) {
        super(message);
        this.diceRoll = diceRoll;
    }
}
