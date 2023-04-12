package org.example.potato.model;

public class PotatoThrowEvent extends Event {
    
    public PotatoThrowEvent() {
        super("You set out to repel the intruders... ");
    }
    
    @Override
    public GameState execute(GameState state) {
        int orcs = state.getOrcs();
        if (orcs == 0) {
            concatToEventMessage("But the intruders were nowhere to be found.");
            return state;
        }
        int cost = state.getOrcRemoveCost();
        if (cost <= state.getPotatoes()) {
            state.removeXPotatoes(cost);
            state.decreaseOrcs();
            concatToEventMessage("And successfully held the line.");
        } else
            concatToEventMessage("But have not enough potatoes to do so.");
        return state;
    }
    
    private void concatToEventMessage(String con) {
        this.message = this.message.concat(con);
    }
}
