package org.example.darkshire.potato.factory;

import org.example.darkshire.api.model.GameState;
import org.example.darkshire.common.base.AbstractBaseEventFactory;
import org.example.darkshire.common.model.BaseEvent;
import org.example.darkshire.potato.enums.PotatoAttribute;
import org.springframework.stereotype.Service;

@Service
public class BaseEventFactory extends AbstractBaseEventFactory<PotatoAttribute> {
    
    @Override
    public BaseEvent<PotatoAttribute> createBaseEvent(int eventType) {
        return switch (eventType) {
            case 1, 2 -> new BaseEvent<>(eventType, "In the garden...");
            case 3, 4 -> new BaseEvent<>(eventType, "A knock at the door...");
            case 5, 6 -> new BaseEvent<>(eventType, "The world becomes a darker, more dangerous place.") {
                @Override
                public void execute(GameState<PotatoAttribute> state) {
                    state.increase(PotatoAttribute.REMOVECOST);
                }
            };
            default -> throw new IllegalArgumentException(String.format("Invalid event type: %d", eventType));
        };
    }
}
