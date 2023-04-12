package org.example.potato.game;

import org.example.potato.model.Event;

import java.util.LinkedList;
import java.util.List;

public class EventHistory {
    
    private final List<Event> history = new LinkedList<>();
    
    public void add(Event event) {
        history.add(event);
    }
}
