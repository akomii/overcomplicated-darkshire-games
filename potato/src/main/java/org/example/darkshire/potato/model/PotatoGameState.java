package org.example.darkshire.potato.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.darkshire.common.base.AbstractGameState;
import org.example.darkshire.api.model.Event;
import org.example.darkshire.potato.enums.PotatoAttribute;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

//TODO test REST
@NoArgsConstructor
@Component
@JacksonXmlRootElement(localName = "gameState")
public class PotatoGameState extends AbstractGameState<PotatoAttribute> {
    
    @JacksonXmlProperty(localName = "attribute")
    @Getter
    private final Map<PotatoAttribute, Integer> attributes = new EnumMap<>(PotatoAttribute.class);
    
    @Override
    protected Class<PotatoAttribute> getGameAttributeType() {
        return PotatoAttribute.class;
    }
    
    @Override
    public void consume(Event<PotatoAttribute> event) {
        event.execute(this);
    }
}
