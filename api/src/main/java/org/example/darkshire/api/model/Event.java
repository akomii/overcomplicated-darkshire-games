package org.example.darkshire.api.model;

public interface Event {
    
    String getMessage();
    
    GameState execute(GameState state);
}