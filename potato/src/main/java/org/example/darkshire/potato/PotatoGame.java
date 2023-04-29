package org.example.darkshire.potato;

import org.example.darkshire.api.base.AbstractMainGame;
import org.example.darkshire.api.factory.EventFactory;
import org.example.darkshire.api.model.Dice;
import org.example.darkshire.api.model.Event;
import org.example.darkshire.potato.enums.PotatoAttribute;
import org.example.darkshire.potato.factory.BaseEventFactory;
import org.example.darkshire.potato.factory.DoorEventFactory;
import org.example.darkshire.potato.factory.EndingEventFactory;
import org.example.darkshire.potato.factory.GardenEventFactory;
import org.example.darkshire.potato.model.PotatoThrowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("application")
public class PotatoGame extends AbstractMainGame<PotatoAttribute> {
    
    @Autowired
    BaseEventFactory baseEventFactory;
    
    @Autowired
    GardenEventFactory gardenEventFactory;
    
    @Autowired
    DoorEventFactory doorEventFactory;
    
    @Autowired
    EndingEventFactory endingEventFactory;
    
    @Autowired
    Dice dice;
    
    
    public void executeBaseEvent() {
        int roll = dice.roll();
        Event<PotatoAttribute> event = baseEventFactory.createEvent(roll);
        eventHistory.add(event);
        if (roll == 1 || roll == 2)
            rollNewEventOfFactory(gardenEventFactory);
        else if (roll == 3 || roll == 4)
            rollNewEventOfFactory(doorEventFactory);
        else if (roll == 5 || roll == 6)
            executeEvent(event);
        checkAndExecuteEndingEvent();
    }
    
    private void rollNewEventOfFactory(EventFactory<PotatoAttribute> factory) {
        Event<PotatoAttribute> event = factory.createEvent(dice.roll());
        executeEvent(event);
        eventHistory.add(event);
    }
    
    private void checkAndExecuteEndingEvent() {
        if (gameState.get(PotatoAttribute.DESTINY) >= 10)
            executeEndingEvent(1);
        else if (gameState.get(PotatoAttribute.POTATOES) >= 10)
            executeEndingEvent(2);
        else if (gameState.get(PotatoAttribute.ORCS) >= 10)
            executeEndingEvent(3);
    }
    
    private void executeEndingEvent(int eventType) {
        Event<PotatoAttribute> event = endingEventFactory.createEvent(eventType);
        executeEvent(event);
        eventHistory.add(event);
    }
    
    public void executePotatoThrowEvent() {
        PotatoThrowEvent event = new PotatoThrowEvent();
        executeEvent(event);
        eventHistory.add(event);
    }
}
