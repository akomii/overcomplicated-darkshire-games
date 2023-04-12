package org.example.potato.game;

import org.example.potato.model.DiceRollEvent;
import org.example.potato.model.Event;
import org.example.potato.model.GameState;
import org.springframework.stereotype.Service;

@Service
public class DoorEventFactory implements AbstractEventFactory {
    
    @Override
    public Event createEvent(int eventType) {
        return switch (eventType) {
            case 1 -> new DiceRollEvent(1, "A distant cousin. They are after your potatoes. They may snitch on you.") {
                @Override
                public GameState execute(GameState state) {
                    state.increaseOrcs();
                    return state;
                }
            };
            case 2 -> new DiceRollEvent(2, "A dwarven stranger. You refuse them entry. Ghastly creatures.") {
                @Override
                public GameState execute(GameState state) {
                    state.increaseDestiny();
                    return state;
                }
            };
            case 3 -> new DiceRollEvent(3, "A wizard strolls by. You pointedly draw the curtains.") {
                @Override
                public GameState execute(GameState state) {
                    state.increaseOrcs();
                    state.increaseDestiny();
                    return state;
                }
            };
            case 4 -> new DiceRollEvent(4, "There are rumours of war in the reaches. You eat some potatoes.") {
                @Override
                public GameState execute(GameState state) {
                    state.decreasePotatoes();
                    state.increaseOrcs();
                    state.increaseOrcs();
                    return state;
                }
            };
            case 5 -> new DiceRollEvent(5, "It's an elf. They are not serious people.") {
                @Override
                public GameState execute(GameState state) {
                    state.increaseDestiny();
                    return state;
                }
            };
            case 6 -> new DiceRollEvent(6, "It's a sack of potatoes from a generous neighbour. You really must remember to pay them a visit one of these years.") {
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
