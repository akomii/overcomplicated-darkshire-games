package org.example.darkshire.mastodon;


import org.example.darkshire.api.model.Event;
import org.example.darkshire.api.model.GameState;
import org.example.darkshire.common.base.AbstractMainGame;
import org.example.darkshire.mastodon.enums.MastodonAttribute;
import org.example.darkshire.mastodon.factory.DayEventFactory;
import org.example.darkshire.mastodon.factory.EveningEventFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("application")
public class MastodonGame extends AbstractMainGame<MastodonAttribute> {
    
    @Autowired
    DayEventFactory dayEventFactory;
    
    @Autowired
    EveningEventFactory eveningEventFactory;
    
    @Override
    public void executeBaseEvent() {
        int roll = dice.roll();
        Event<MastodonAttribute> event = baseEventFactory.createEvent(roll);
        addToEventHistory(event);
        if (roll == 1 || roll == 2 ||roll==3)
            rollEventOfFactory(dayEventFactory);
        else if (roll == 4 || roll == 5)
            rollEventOfFactory(eveningEventFactory);
        else if (roll == 6)
            //TODO sit-event
        //TODO clarity-event
        checkAndExecuteEndingEvent();
    }
    
    @Override
    protected void checkAndExecuteEndingEvent() {
        GameState<MastodonAttribute> gameState = getGameState();
        if (gameState.get(MastodonAttribute.CONFUSION) >= 10)
            executeEndingEvent(1);
        else if (gameState.get(MastodonAttribute.DAMAGES) >= 10)
            executeEndingEvent(2);
        else if (gameState.get(MastodonAttribute.THINKING) >= 10)
            executeEndingEvent(3);
    }
}
