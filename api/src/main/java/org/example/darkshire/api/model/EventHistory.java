package org.example.darkshire.api.model;

import java.util.List;

public interface EventHistory {
    
    List<Event> getHistory();
    
    void add(Event event);
}