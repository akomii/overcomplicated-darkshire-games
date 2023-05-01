package org.example.darkshire.mastodon.model;

import org.example.darkshire.api.model.Event;
import org.example.darkshire.common.base.AbstractGameState;
import org.example.darkshire.mastodon.enums.MastodonAttribute;

//TODO test REST
public class MastodonGameState extends AbstractGameState<MastodonAttribute> {
    
    @Override
    protected Class<MastodonAttribute> getGameAttributeType() {
        return MastodonAttribute.class;
    }
    
    @Override
    public void consume(Event<MastodonAttribute> event) {
        event.execute(this);
    }
}