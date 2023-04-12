package org.example.potato.game;

import org.example.potato.model.Event;
import org.example.potato.model.EventHistory;
import org.example.potato.model.GameState;
import org.example.potato.model.PotatoThrowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Scope("application")
public class MainGame {
    
    private GameState state;
    
    private final EventHistory history;
    
    public MainGame(GameState state, EventHistory history) {
        this.state = state;
        this.history = history;
    }
    
    @Autowired
    DailyEventFactory dailyEventFactory;
    
    @Autowired
    GardenEventFactory gardenEventFactory;
    
    @Autowired
    DoorEventFactory doorEventFactory;
    
    @Autowired
    EndingEventFactory endingEventFactory;
    
    Random random = new Random();
    
    private int rollDice() {
        return random.nextInt(6) + 1;
    }
    
    public void executePotatoThrowEvent() {
        if (!state.isFinished()) {
            PotatoThrowEvent event = new PotatoThrowEvent();
            state = event.execute(state);
            history.add(event);
        }
    }
    
    public void executeDailyEvent() {
        if (!state.isFinished()) {
            int roll = rollDice();
            Event event = dailyEventFactory.createEvent(roll);
            history.add(event);
            
            if (roll == 1 || roll == 2)
                rollNewEventOfFactory(gardenEventFactory);
            else if (roll == 3 || roll == 4)
                rollNewEventOfFactory(doorEventFactory);
            else if (roll == 5 || roll == 6)
                state = event.execute(state);
            checkAndExecuteEndingEvent();
        }
    }
    
    private void rollNewEventOfFactory(AbstractEventFactory factory) {
        int roll = rollDice();
        Event event = factory.createEvent(roll);
        state = event.execute(state);
        history.add(event);
    }
    
    private void checkAndExecuteEndingEvent() {
        if (state.getDestiny() >= 10)
            executeEndingEvent(1);
        else if (state.getPotatoes() >= 10)
            executeEndingEvent(2);
        else if (state.getOrcs() >= 10)
            executeEndingEvent(3);
    }
    
    private void executeEndingEvent(int eventType) {
        Event event = endingEventFactory.createEvent(eventType);
        state = event.execute(state);
        history.add(event);
    }
}
