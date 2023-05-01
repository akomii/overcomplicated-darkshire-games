package org.example.darkshire.potato.rest;

import org.example.darkshire.api.model.EventHistory;
import org.example.darkshire.api.model.GameState;
import org.example.darkshire.common.base.AbstractGameController;
import org.example.darkshire.potato.PotatoGame;
import org.example.darkshire.potato.enums.PotatoAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/potato")
public class PotatoController extends AbstractGameController<PotatoAttribute> {
    
    @Autowired
    private PotatoGame potatoGame;
    
    public PotatoController(PotatoGame potatoGame) {
        super(potatoGame);
    }
    
    @PostMapping("/base")
    @ResponseStatus(HttpStatus.OK)
    public void executeBaseEvent() {
        super.executeBaseEvent();
    }
    
    @GetMapping("/state")
    @ResponseStatus(HttpStatus.OK)
    public GameState<PotatoAttribute> getGameState() {
        return super.getGameState();
    }
    
    @GetMapping("/history")
    @ResponseStatus(HttpStatus.OK)
    public EventHistory<PotatoAttribute> getEventHistory() {
        return super.getEventHistory();
    }
    
    @PostMapping("/throw")
    @ResponseStatus(HttpStatus.OK)
    public void executePotatoThrowEvent() {
        potatoGame.executePotatoThrowEvent();
    }
}
