package org.example.darkshire.potato.model;

import org.example.darkshire.common.model.AbstractEvent;
import org.example.darkshire.api.model.GameState;
import org.example.darkshire.potato.enums.PotatoAttribute;

public class PotatoThrowEvent extends AbstractEvent<PotatoAttribute> {
    
    public PotatoThrowEvent() {
        super("You set out to repel the intruders... ");
    }
    
    @Override
    public void execute(GameState<PotatoAttribute> state) {
        int orcs = state.get(PotatoAttribute.ORCS);
        if (orcs == 0) {
            concatToEventMessage("But the intruders were nowhere to be found.");
        }
        int cost = state.get(PotatoAttribute.REMOVECOST);
        if (cost <= state.get(PotatoAttribute.POTATOES)) {
            for (int i = 0; i < cost; i++) {
                state.decrease(PotatoAttribute.POTATOES);
            }
            state.decrease(PotatoAttribute.ORCS);
            concatToEventMessage("And successfully held the line.");
        } else
            concatToEventMessage("But have not enough potatoes to do so.");
    }
    
    private void concatToEventMessage(String con) {
        this.message = this.message.concat(con);
    }
}
