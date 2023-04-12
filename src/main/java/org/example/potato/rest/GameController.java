package org.example.potato.rest;

import org.example.potato.game.MainGame;
import org.example.potato.model.EventHistory;
import org.example.potato.model.GameState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {
    
    @Autowired
    private MainGame mainGame;
    
    @PostMapping("/daily")
    @ResponseStatus(HttpStatus.OK)
    public void executeDailyEvent() {
        mainGame.executeDailyEvent();
    }
    
    @PostMapping("/throw")
    @ResponseStatus(HttpStatus.OK)
    public void executePotatoThrowEvent() {
        mainGame.executePotatoThrowEvent();
    }
    
    @GetMapping("/state")
    @ResponseStatus(HttpStatus.OK)
    public GameState getGameState() {
        return mainGame.getGameState();
    }
    
    @GetMapping("/history")
    @ResponseStatus(HttpStatus.OK)
    public EventHistory getEventHistory() {
        return mainGame.getEventHistory();
    }
}