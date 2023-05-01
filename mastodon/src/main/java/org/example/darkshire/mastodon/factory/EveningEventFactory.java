package org.example.darkshire.mastodon.factory;

import org.example.darkshire.api.factory.EventFactory;
import org.example.darkshire.api.model.Event;
import org.example.darkshire.api.model.GameState;
import org.example.darkshire.common.base.AbstractDiceRollEvent;
import org.example.darkshire.mastodon.enums.MastodonAttribute;
import org.springframework.stereotype.Service;

@Service
public class EveningEventFactory implements EventFactory<MastodonAttribute> {
    
    @Override
    public Event<MastodonAttribute> createEvent(int eventType) {
        return switch (eventType) {
            case 1 -> new AbstractDiceRollEvent<>(1, "The mastodon trumpets ERROR at you. You ponder your mistake.") {
                @Override
                public void execute(GameState<MastodonAttribute> state) {
                    state.increase(MastodonAttribute.THINKING);
                }
            };
            case 2 -> new AbstractDiceRollEvent<>(2, "It wears so many hats. How will you wash all these hats?") {
                @Override
                public void execute(GameState<MastodonAttribute> state) {
                    state.increase(MastodonAttribute.CONFUSION);
                }
            };
            case 3 -> new AbstractDiceRollEvent<>(3, "It reads moral philosophy and particle physics. All day. It will not let you read with it.") {
                @Override
                public void execute(GameState<MastodonAttribute> state) {
                    state.increase(MastodonAttribute.CONFUSION);
                }
            };
            case 4 -> new AbstractDiceRollEvent<>(4, "Your friends tell you how wonderful their mastodons are. You burn with envy.") {
                @Override
                public void execute(GameState<MastodonAttribute> state) {
                    state.increase(MastodonAttribute.CONFUSION);
                    state.increase(MastodonAttribute.THINKING);
                }
            };
            case 5 -> new AbstractDiceRollEvent<>(5, "Before the mastodon will sleep, you must clean its many whistles and gears.") {
                @Override
                public void execute(GameState<MastodonAttribute> state) {
                    state.increase(MastodonAttribute.CONFUSION);
                    state.increase(MastodonAttribute.THINKING);
                }
            };
            case 6 -> new AbstractDiceRollEvent<>(6, "During the night, your mastodon holds not one, not two, but a third party. There is a platform. And servers.") {
                @Override
                public void execute(GameState<MastodonAttribute> state) {
                    state.increase(MastodonAttribute.DAMAGES);
                }
            };
            default -> throw new IllegalArgumentException(String.format("Invalid event type: %d", eventType));
        };
    }
}
