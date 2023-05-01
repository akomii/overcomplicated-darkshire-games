package org.example.darkshire.common.base;

import lombok.Getter;
import org.example.darkshire.api.MainGame;
import org.example.darkshire.api.enums.GameAttribute;
import org.example.darkshire.api.factory.EventFactory;
import org.example.darkshire.api.model.Dice;
import org.example.darkshire.api.model.Event;
import org.example.darkshire.api.model.EventHistory;
import org.example.darkshire.api.model.GameState;

public abstract class AbstractMainGame<T extends Enum<T> & GameAttribute> implements MainGame<T> {
    
    @Getter
    private GameState<T> gameState;
    
    @Getter
    private EventHistory<T> eventHistory;
    
    protected AbstractBaseEventFactory<T> baseEventFactory;
    
    protected AbstractEndingEventFactory<T> endingEventFactory;
    
    protected Dice dice;
    
    protected void executeEvent(Event<T> event) {
        if (!gameState.isFinished())
            gameState.consume(event);
    }
    
    protected void addToEventHistory(Event<T> event) {
        if (!gameState.isFinished())
            eventHistory.add(event);
    }
    
    protected void rollEventOfFactory(EventFactory<T> factory) {
        Event<T> event = factory.createEvent(dice.roll());
        executeEvent(event);
        eventHistory.add(event);
    }
    
    protected void executeEndingEvent(int eventType) {
        Event<T> event = endingEventFactory.createEvent(eventType);
        executeEvent(event);
        eventHistory.add(event);
    }
    
    protected abstract void checkAndExecuteEndingEvent();
}
