package org.example.darkshire.api.model;

import org.example.darkshire.api.enums.GameAttribute;

import java.util.List;

public interface EventHistory<T extends Enum<T> & GameAttribute> {
    
    List<Event<T>> getHistory();
    
    void add(Event<T> event);
}