package org.example.darkshire.potato.factory;

import org.example.darkshire.api.base.AbstractDiceRollEvent;
import org.example.darkshire.api.factory.EventFactory;
import org.example.darkshire.api.model.Event;
import org.example.darkshire.api.model.GameState;
import org.example.darkshire.potato.enums.PotatoAttribute;
import org.springframework.stereotype.Service;

@Service
public class DoorEventFactory implements EventFactory<PotatoAttribute> {
    
    @Override
    public Event<PotatoAttribute> createEvent(int eventType) {
        return switch (eventType) {
            case 1 -> new AbstractDiceRollEvent<>(1, "A distant cousin. They are after your potatoes. They may snitch on you.") {
                @Override
                public GameState<PotatoAttribute> execute(GameState<PotatoAttribute> state) {
                    state.increase(PotatoAttribute.ORCS);
                    return state;
                }
            };
            case 2 -> new AbstractDiceRollEvent<>(2, "A dwarven stranger. You refuse them entry. Ghastly creatures.") {
                @Override
                public GameState<PotatoAttribute> execute(GameState<PotatoAttribute> state) {
                    state.increase(PotatoAttribute.DESTINY);
                    return state;
                }
            };
            case 3 -> new AbstractDiceRollEvent<>(3, "A wizard strolls by. You pointedly draw the curtains.") {
                @Override
                public GameState<PotatoAttribute> execute(GameState<PotatoAttribute> state) {
                    state.increase(PotatoAttribute.ORCS);
                    state.increase(PotatoAttribute.DESTINY);
                    return state;
                }
            };
            case 4 -> new AbstractDiceRollEvent<>(4, "There are rumours of war in the reaches. You eat some potatoes.") {
                @Override
                public GameState<PotatoAttribute> execute(GameState<PotatoAttribute> state) {
                    state.decrease(PotatoAttribute.POTATOES);
                    state.increase(PotatoAttribute.ORCS);
                    state.increase(PotatoAttribute.ORCS);
                    return state;
                }
            };
            case 5 -> new AbstractDiceRollEvent<>(5, "It's an elf. They are not serious people.") {
                @Override
                public GameState<PotatoAttribute> execute(GameState<PotatoAttribute> state) {
                    state.increase(PotatoAttribute.DESTINY);
                    return state;
                }
            };
            case 6 -> new AbstractDiceRollEvent<>(6, "It's a sack of potatoes from a generous neighbour. You really must remember to pay them a visit one of these years.") {
                @Override
                public GameState<PotatoAttribute> execute(GameState<PotatoAttribute> state) {
                    state.increase(PotatoAttribute.POTATOES);
                    state.increase(PotatoAttribute.POTATOES);
                    return state;
                }
            };
            default -> throw new IllegalArgumentException(String.format("Invalid event type: %d", eventType));
        };
    }
}
