package org.example.darkshire.potato.factory;

import org.example.darkshire.api.factory.EventFactory;
import org.example.darkshire.api.model.Event;
import org.example.darkshire.common.model.EndingEvent;
import org.example.darkshire.potato.enums.PotatoAttribute;
import org.springframework.stereotype.Service;

@Service
public class EndingEventFactory implements EventFactory<PotatoAttribute> {
    
    @Override
    public Event<PotatoAttribute> createEvent(int eventType) {
        return switch (eventType) {
            case 1 -> new EndingEvent<>("An interfering bard or wizard turns up at your doorstep with a quest, and you are whisked away against your will on an adventure.");
            case 2 -> new EndingEvent<>("You have enough potatoes that you can go underground and not return to the surface until the danger is past. You nestle down into your burrow and enjoy your well earned rest.");
            case 3 -> new EndingEvent<>("The orcs finally find your potato farm. Alas, orcs are not so interested in potatoes as they are in eating you, and you end up in a cook pot.");
            default -> throw new IllegalArgumentException(String.format("Invalid event type: %d", eventType));
        };
    }
}
