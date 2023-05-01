package org.example.darkshire.potato.model;

import org.example.darkshire.api.model.Event;
import org.example.darkshire.common.base.AbstractGameState;
import org.example.darkshire.potato.enums.PotatoAttribute;
import org.springframework.stereotype.Component;

//TODO test REST
@Component
public class PotatoGameState extends AbstractGameState<PotatoAttribute> {
    
    @Override
    protected Class<PotatoAttribute> getGameAttributeType() {
        return PotatoAttribute.class;
    }
    
    @Override
    public void consume(Event<PotatoAttribute> event) {
        event.execute(this);
    }
}
