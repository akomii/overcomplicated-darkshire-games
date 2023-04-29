package org.example.darkshire.potato.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.darkshire.api.model.GameState;
import org.example.darkshire.potato.enums.PotatoAttribute;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

//TODO test REST
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Component
@JacksonXmlRootElement(localName = "gameState")
public class PotatoGameState implements GameState<PotatoAttribute> {
    
    @JacksonXmlProperty(localName = "attribute")
    final Map<PotatoAttribute, Integer> attributes = new EnumMap<>(PotatoAttribute.class);
    
    boolean isFinished;
    
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
}
