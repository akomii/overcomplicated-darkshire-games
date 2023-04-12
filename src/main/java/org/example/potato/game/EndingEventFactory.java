package org.example.potato.game;

import org.example.potato.model.Event;
import org.example.potato.model.GameState;

public class EndingEventFactory implements AbstractEventFactory {
    
    @Override
    public Event createEvent(int eventType) {
        return switch (eventType) {
            case 1 -> new Event("An interfering bard or wizard turns up at your doorstep with a quest, and you are whisked away against your will on an adventure.") {
                @Override
                public GameState execute(GameState state) {
                    state.finishGame();
                    return state;
                }
            };
            case 2 -> new Event("You have enough potatoes that you can go underground and not return to the surface until the danger is past. You nestle down into your burrow and enjoy your well earned rest.") {
                @Override
                public GameState execute(GameState state) {
                    state.finishGame();
                    return state;
                }
            };
            case 3 -> new Event("The orcs finally find your potato farm. Alas, orcs are not so interested in potatoes as they are in eating you, and you end up in a cook pot.") {
                @Override
                public GameState execute(GameState state) {
                    state.finishGame();
                    return state;
                }
            };
            default -> throw new IllegalArgumentException(String.format("Invalid event type: %d", eventType));
        };
    }
}
