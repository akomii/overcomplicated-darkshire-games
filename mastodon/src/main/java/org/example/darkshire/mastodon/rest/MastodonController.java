package org.example.darkshire.mastodon.rest;

import org.example.darkshire.api.model.EventHistory;
import org.example.darkshire.api.model.GameState;
import org.example.darkshire.common.rest.AbstractGameController;
import org.example.darkshire.mastodon.MastodonGame;
import org.example.darkshire.mastodon.enums.MastodonAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mastodon")
public class MastodonController extends AbstractGameController<MastodonAttribute> {
    
    @Autowired
    private MastodonGame mastodonGame;
    
    public MastodonController(MastodonGame mastodonGame) {
        super(mastodonGame);
    }
    
    @PostMapping("/base")
    @ResponseStatus(HttpStatus.OK)
    public void executeBaseEvent() {
        super.executeBaseEvent();
    }
    
    @GetMapping("/state")
    @ResponseStatus(HttpStatus.OK)
    public GameState<MastodonAttribute> getGameState() {
        return super.getGameState();
    }
    
    @GetMapping("/history")
    @ResponseStatus(HttpStatus.OK)
    public EventHistory<MastodonAttribute> getEventHistory() {
        return super.getEventHistory();
    }
}
