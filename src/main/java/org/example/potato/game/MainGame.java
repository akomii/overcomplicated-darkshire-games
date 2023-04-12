package org.example.potato.game;

import org.example.potato.model.Event;
import org.example.potato.model.GameState;

import java.util.Random;

public class MainGame {
    
    GameState state = new GameState();
    
    Random random = new Random();
    
    EventHistory history = new EventHistory();
    
    DailyEventFactory dailyEventFactory = new DailyEventFactory();
    
    GardenEventFactory gardenEventFactory = new GardenEventFactory();
    
    DoorEventFactory doorEventFactory = new DoorEventFactory();
    
    EndingEventFactory endingEventFactory = new EndingEventFactory();
    
    
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
