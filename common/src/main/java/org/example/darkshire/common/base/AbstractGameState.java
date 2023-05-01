package org.example.darkshire.common.base;

import lombok.Getter;
import org.example.darkshire.api.enums.GameAttribute;
import org.example.darkshire.api.model.GameState;

import java.util.EnumMap;
import java.util.Map;

public abstract class AbstractGameState<T extends Enum<T> & GameAttribute> implements GameState<T> {
    
    @Getter
    protected final Map<T, Integer> attributes = new EnumMap<>(getGameAttributeType());
    
    @Getter
    protected boolean finished;
    
    protected abstract Class<T> getGameAttributeType();
    
    public int get(T attribute) {
        return attributes.getOrDefault(attribute, 0);
    }
    
    public void increase(T attribute) {
        attributes.put(attribute, get(attribute) + 1);
    }
    
    public void decrease(T attribute) {
        int value = get(attribute);
        if (value > 0)
            attributes.put(attribute, get(attribute) - 1);
    }
    
    @Override
    public void finishGame() {
        finished = true;
    }
}
