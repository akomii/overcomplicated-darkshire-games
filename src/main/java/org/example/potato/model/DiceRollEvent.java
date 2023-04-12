package org.example.potato.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PROTECTED)
@Getter
public abstract class DiceRollEvent extends Event {
    
    int diceRoll;
    protected DiceRollEvent(int diceRoll, String message) {
        super(message);
        this.diceRoll = diceRoll;
    }
}
