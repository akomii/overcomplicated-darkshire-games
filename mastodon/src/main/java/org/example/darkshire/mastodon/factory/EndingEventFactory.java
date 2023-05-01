package org.example.darkshire.mastodon.factory;

import org.example.darkshire.common.base.AbstractEndingEventFactory;
import org.example.darkshire.common.model.EndingEvent;
import org.example.darkshire.mastodon.enums.MastodonAttribute;
import org.springframework.stereotype.Service;

@Service
public class EndingEventFactory extends AbstractEndingEventFactory<MastodonAttribute> {
    
    @Override
    public EndingEvent<MastodonAttribute> createEndingEvent(int eventType) {
        return switch (eventType) {
            case 1 -> new EndingEvent<>("You finally lose your temper with the wretched creature and confront it. The argument is brief, because you have no idea what it is trying to tell you, and eventually it crushed you to death using its trunk.");
            case 2 -> new EndingEvent<>("You lose all your money and your livelihood is destoryed, reduced to gigantic footprints in the ashes. The mastadon abondons you in search of someone elso to inconvenience.");
            case 3 -> new EndingEvent<>("You decide that that mastodons are not four you. You slip away into the night with the last of your remaining savings, faking your death. Perhaps you'll build a gigantic pillowfort. Or collect tumblers. Something quiet.");
            case 4 -> new EndingEvent<>("You never emerge.");
            case 5 -> new EndingEvent<>("You finally decipher what the Mastodon was trying to tell you. You live the rest of you life in a state of blissful enlightenment, in harmony with your new friend. You're also a vegan now.");
            default -> throw new IllegalArgumentException(String.format("Invalid event type: %d", eventType));
        };
    }
}
