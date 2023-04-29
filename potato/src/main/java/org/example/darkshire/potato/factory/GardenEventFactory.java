package org.example.darkshire.potato.factory;

import org.example.darkshire.api.base.AbstractDiceRollEvent;
import org.example.darkshire.api.factory.EventFactory;
import org.example.darkshire.api.model.Event;
import org.example.darkshire.api.model.GameState;
import org.example.darkshire.potato.enums.PotatoAttribute;
import org.springframework.stereotype.Service;

@Service
public class GardenEventFactory implements EventFactory<PotatoAttribute> {
    
    @Override
    public Event<PotatoAttribute> createEvent(int eventType) {
        return switch (eventType) {
            case 1 -> new AbstractDiceRollEvent<>(1, "You happily root about all day in your garden.") {
                @Override
                public void execute(GameState<PotatoAttribute> state) {
                    state.increase(PotatoAttribute.POTATOES);
                }
            };
            case 2 -> new AbstractDiceRollEvent<>(2, "You narrowly avoid a visitor by hiding in a potato sack.") {
                @Override
                public void execute(GameState<PotatoAttribute> state) {
                    state.increase(PotatoAttribute.POTATOES);
                    state.increase(PotatoAttribute.DESTINY);
                }
            };
            case 3 -> new AbstractDiceRollEvent<>(3, "A hooded stranger lingers outside your farm.") {
                @Override
                public void execute(GameState<PotatoAttribute> state) {
                    state.increase(PotatoAttribute.DESTINY);
                    state.increase(PotatoAttribute.ORCS);
                }
            };
            case 4 -> new AbstractDiceRollEvent<>(4, "Your field is ravaged in the night by unseen enemies.") {
                @Override
                public void execute(GameState<PotatoAttribute> state) {
                    state.increase(PotatoAttribute.ORCS);
                    state.decrease(PotatoAttribute.POTATOES);
                }
            };
            case 5 -> new AbstractDiceRollEvent<>(5, "You trade potatoes for other delicious foodstuffs.") {
                @Override
                public void execute(GameState<PotatoAttribute> state) {
                    state.decrease(PotatoAttribute.POTATOES);
                }
            };
            case 6 -> new AbstractDiceRollEvent<>(6, "You burrow into a bumper crop of potatoes. Do you cry with joy? Possibly.") {
                @Override
                public void execute(GameState<PotatoAttribute> state) {
                    state.increase(PotatoAttribute.POTATOES);
                    state.increase(PotatoAttribute.POTATOES);
                }
            };
            default -> throw new IllegalArgumentException(String.format("Invalid event type: %d", eventType));
        };
    }
}
