package org.example.potato.game;

import org.example.potato.model.DiceRollEvent;
import org.example.potato.model.Event;
import org.example.potato.model.GameState;
import org.springframework.stereotype.Service;

@Service
public class DailyEventFactory implements AbstractEventFactory {
    
    @Override
    public Event createEvent(int eventType) {
        return switch (eventType) {
            case 1, 2 -> new DiceRollEvent(eventType, "In the garden...") {
                @Override
                public GameState execute(GameState state) {
                    return state;
                }
            };
            case 3, 4 -> new DiceRollEvent(eventType, "A knock at the door...") {
                @Override
                public GameState execute(GameState state) {
                    return state;
                }
            };
            case 5, 6 -> new DiceRollEvent(eventType, "The world becomes a darker, more dangerous place.") {
                @Override
                public GameState execute(GameState state) {
                    state.increaseOrcRemoveCost();
                    return state;
                }
            };
            default -> throw new IllegalArgumentException(String.format("Invalid event type: %d", eventType));
        };
    }
}
