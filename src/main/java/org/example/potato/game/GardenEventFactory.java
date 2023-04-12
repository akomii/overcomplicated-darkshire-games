package org.example.potato.game;

import org.example.potato.model.DiceRollEvent;
import org.example.potato.model.Event;
import org.example.potato.model.GameState;

public class GardenEventFactory implements AbstractEventFactory {
    
    @Override
    public Event createEvent(int eventType) {
        return switch (eventType) {
            case 1 -> new DiceRollEvent(1, "You happily root about all day in your garden.") {
                @Override
                public GameState execute(GameState state) {
                    state.increasePotatoes();
                    return state;
                }
            };
            case 2 -> new DiceRollEvent(2, "You narrowly avoid a visitor by hiding in a potato sack.") {
                @Override
                public GameState execute(GameState state) {
                    state.increasePotatoes();
                    state.increaseDestiny();
                    return state;
                }
            };
            case 3 -> new DiceRollEvent(3, "A hooded stranger lingers outside your farm.") {
                @Override
                public GameState execute(GameState state) {
                    state.increaseDestiny();
                    state.increaseOrcs();
                    return state;
                }
            };
            case 4 -> new DiceRollEvent(4, "Your field is ravaged in the night by unseen enemies.") {
                @Override
                public GameState execute(GameState state) {
                    state.increaseOrcs();
                    state.decreasePotatoes();
                    return state;
                }
            };
            case 5 -> new DiceRollEvent(5, "You trade potatoes for other delicious foodstuffs.") {
                @Override
                public GameState execute(GameState state) {
                    state.decreasePotatoes();
                    return state;
                }
            };
            case 6 -> new DiceRollEvent(6, "You burrow into a bumper crop of potatoes. Do you cry with joy? Possibly.") {
                @Override
                public GameState execute(GameState state) {
                    state.increasePotatoes();
                    state.increasePotatoes();
                    return state;
                }
            };
            default -> throw new IllegalArgumentException(String.format("Invalid event type: %d", eventType));
        };
    }
}
