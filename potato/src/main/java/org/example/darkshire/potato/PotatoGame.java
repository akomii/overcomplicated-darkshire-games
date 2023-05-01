package org.example.darkshire.potato;

import org.example.darkshire.api.model.Event;
import org.example.darkshire.common.base.AbstractMainGame;
import org.example.darkshire.potato.enums.PotatoAttribute;
import org.example.darkshire.potato.factory.DoorEventFactory;
import org.example.darkshire.potato.factory.GardenEventFactory;
import org.example.darkshire.potato.model.PotatoThrowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("application")
public class PotatoGame extends AbstractMainGame<PotatoAttribute> {
    
    @Autowired
    GardenEventFactory gardenEventFactory;
    
    @Autowired
    DoorEventFactory doorEventFactory;
    
    @Override
    public void executeBaseEvent() {
        int roll = dice.roll();
        Event<PotatoAttribute> event = baseEventFactory.createEvent(roll);
        eventHistory.add(event);
        if (roll == 1 || roll == 2)
            rollEventOfFactory(gardenEventFactory);
        else if (roll == 3 || roll == 4)
            rollEventOfFactory(doorEventFactory);
        else if (roll == 5 || roll == 6)
            executeEvent(event);
        checkAndExecuteEndingEvent();
    }
    
    @Override
    protected void checkAndExecuteEndingEvent() {
        if (gameState.get(PotatoAttribute.DESTINY) >= 10)
            executeEndingEvent(1);
        else if (gameState.get(PotatoAttribute.POTATOES) >= 10)
            executeEndingEvent(2);
        else if (gameState.get(PotatoAttribute.ORCS) >= 10)
            executeEndingEvent(3);
    }
    
    public void executePotatoThrowEvent() {
        PotatoThrowEvent event = new PotatoThrowEvent();
        executeEvent(event);
        eventHistory.add(event);
    }
}
