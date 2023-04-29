package org.example.darkshire.api.base;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.example.darkshire.api.enums.Attribute;

@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class AbstractDiceRollEvent<T extends Enum<T> & Attribute> extends AbstractEvent<T> {
    
    @Getter
    int diceRoll;
    
    protected AbstractDiceRollEvent(int diceRoll, String message) {
        super(message);
        this.diceRoll = diceRoll;
    }
}
