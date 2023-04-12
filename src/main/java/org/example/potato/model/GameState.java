package org.example.potato.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Component
@Scope("application")
@JacksonXmlRootElement(localName = "gameState")
public class GameState {
    
    int destiny;
    int potatoes;
    int orcs;
    
    int orcRemoveCost = 1;
    boolean isFinished;
    
    public void increaseDestiny() {
        destiny++;
    }
    
    public void increasePotatoes() {
        potatoes++;
    }
    
    public void decreasePotatoes() {
        if (potatoes != 0)
            potatoes--;
    }
    
    public void removeXPotatoes(int x) {
        potatoes -= x;
    }
    
    public void increaseOrcs() {
        orcs++;
    }
    
    public void decreaseOrcs() {
        if (orcs != 0)
            orcs--;
    }
    
    public void increaseOrcRemoveCost() {
        orcRemoveCost++;
    }
    
    public void finishGame() {
        isFinished = true;
    }
}
