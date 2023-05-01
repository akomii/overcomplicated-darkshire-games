package org.example.darkshire.common.base;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.darkshire.api.enums.GameAttribute;
import org.example.darkshire.api.model.GameState;

import java.util.EnumMap;
import java.util.Map;

@NoArgsConstructor
@JacksonXmlRootElement(localName = "gameState")
public abstract class AbstractGameState<T extends Enum<T> & GameAttribute> implements GameState<T> {
    
    @JacksonXmlProperty(localName = "attribute")
    @Getter
    protected final Map<T, Integer> attributes = new EnumMap<>(getGameAttributeType());
    
    @Getter
    protected boolean finished;
    
    protected abstract Class<T> getGameAttributeType();
    
    @Override
    public int get(T attribute) {
        return attributes.getOrDefault(attribute, 0);
    }
    
    @Override
    public void increase(T attribute) {
        attributes.put(attribute, get(attribute) + 1);
    }
    
    @Override
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
