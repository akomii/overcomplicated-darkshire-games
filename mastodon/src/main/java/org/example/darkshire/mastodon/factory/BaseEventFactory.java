package org.example.darkshire.mastodon.factory;

import org.example.darkshire.api.factory.EventFactory;
import org.example.darkshire.api.model.Event;
import org.example.darkshire.common.model.BaseEvent;
import org.example.darkshire.mastodon.enums.MastodonAttribute;
import org.springframework.stereotype.Service;

@Service
public class BaseEventFactory implements EventFactory<MastodonAttribute> {
    
    @Override
    public Event<MastodonAttribute> createEvent(int eventType) {
        return switch (eventType) {
            case 1, 2, 3 -> new BaseEvent<>(eventType, "A day with your mastodon...");
            case 4, 5 -> new BaseEvent<>(eventType, "An evening at home...");
            case 6 -> new BaseEvent<>(eventType, "You anger your mastodon with your questions, and it sits on you.");
            default -> throw new IllegalArgumentException(String.format("Invalid event type: %d", eventType));
        };
    }
}
