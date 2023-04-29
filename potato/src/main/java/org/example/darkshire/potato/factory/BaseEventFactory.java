package org.example.darkshire.potato.factory;

import org.example.darkshire.api.base.AbstractDiceRollEvent;
import org.example.darkshire.api.factory.EventFactory;
import org.example.darkshire.api.model.Event;
import org.example.darkshire.api.model.GameState;
import org.example.darkshire.potato.enums.PotatoAttribute;
import org.springframework.stereotype.Service;

@Service
public class BaseEventFactory implements EventFactory<PotatoAttribute> {
    
    @Override
    public Event<PotatoAttribute> createEvent(int eventType) {
        return switch (eventType) {
            case 1, 2 -> new AbstractDiceRollEvent<>(eventType, "In the garden...") {
                @Override
                public void execute(GameState<PotatoAttribute> state) {
                }
            };
            case 3, 4 -> new AbstractDiceRollEvent<>(eventType, "A knock at the door...") {
                @Override
                public void execute(GameState<PotatoAttribute> state) {
                }
            };
            case 5, 6 -> new AbstractDiceRollEvent<>(eventType, "The world becomes a darker, more dangerous place.") {
                @Override
                public void execute(GameState<PotatoAttribute> state) {
                    state.increase(PotatoAttribute.REMOVECOST);
                }
            };
            default -> throw new IllegalArgumentException(String.format("Invalid event type: %d", eventType));
        };
    }
}
