package org.example.darkshire.mastodon.factory;

import org.example.darkshire.api.factory.EventFactory;
import org.example.darkshire.api.model.Event;
import org.example.darkshire.api.model.GameState;
import org.example.darkshire.common.model.AbstractDiceRollEvent;
import org.example.darkshire.mastodon.enums.MastodonAttribute;
import org.springframework.stereotype.Service;

@Service
public class DayEventFactory implements EventFactory<MastodonAttribute> {
    
    @Override
    public Event<MastodonAttribute> createEvent(int eventType) {
        return switch (eventType) {
            case 1 -> new AbstractDiceRollEvent<>(1, "The mastodon tells you a secret about your family it could not possibly know.") {
                @Override
                public void execute(GameState<MastodonAttribute> state) {
                    state.increase(MastodonAttribute.CONFUSION);
                }
            };
            case 2 -> new AbstractDiceRollEvent<>(2, "Your mastodon decentralizes all over the carpet.") {
                @Override
                public void execute(GameState<MastodonAttribute> state) {
                    state.increase(MastodonAttribute.DAMAGES);
                }
            };
            case 3 -> new AbstractDiceRollEvent<>(3, "You take the mastodon on a walk in your gated neighbourhood.") {
                @Override
                public void execute(GameState<MastodonAttribute> state) {
                    state.increase(MastodonAttribute.THINKING);
                }
            };
            case 4 -> new AbstractDiceRollEvent<>(4, "The mastodon federates violently through a window, which now needs replacing.") {
                @Override
                public void execute(GameState<MastodonAttribute> state) {
                    state.increase(MastodonAttribute.CONFUSION);
                    state.increase(MastodonAttribute.DAMAGES);
                }
            };
            case 5 -> new AbstractDiceRollEvent<>(5, "The mastodon won't move unless you know the password. You do not know the password.") {
                @Override
                public void execute(GameState<MastodonAttribute> state) {
                    state.increase(MastodonAttribute.CONFUSION);
                    state.increase(MastodonAttribute.CONFUSION);
                }
            };
            case 6 -> new AbstractDiceRollEvent<>(6, "The mastodon bashes a hole in your roof, and now claims to have much better view of other mastodons.") {
                @Override
                public void execute(GameState<MastodonAttribute> state) {
                    state.increase(MastodonAttribute.DAMAGES);
                    state.increase(MastodonAttribute.DAMAGES);
                }
            };
            default -> throw new IllegalArgumentException(String.format("Invalid event type: %d", eventType));
        };
    }
}
