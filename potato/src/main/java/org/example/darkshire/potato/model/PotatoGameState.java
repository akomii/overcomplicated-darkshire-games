package org.example.darkshire.potato.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.darkshire.api.model.Event;
import org.example.darkshire.api.model.GameState;
import org.example.darkshire.potato.enums.PotatoAttribute;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

//TODO test REST
@NoArgsConstructor
@Component
@JacksonXmlRootElement(localName = "gameState")
public class PotatoGameState implements GameState<PotatoAttribute> {
    
    @JacksonXmlProperty(localName = "attribute")
    @Getter
    private final Map<PotatoAttribute, Integer> attributes = new EnumMap<>(PotatoAttribute.class);
    
    @Getter
    private boolean isFinished;
    
    @Override
    public int get(PotatoAttribute attribute) {
        return attributes.getOrDefault(attribute, 0);
    }
    
    @Override
    public void increase(PotatoAttribute attribute) {
        attributes.put(attribute, get(attribute) + 1);
    }
    
    @Override
    public void decrease(PotatoAttribute attribute) {
        int value = get(attribute);
        if (value > 0)
            attributes.put(attribute, get(attribute) - 1);
    }
    
    @Override
    public void finishGame() {
        isFinished = true;
    }
    
    @Override
    public void consume(Event<PotatoAttribute> event) {
        event.execute(this);
    }
}
