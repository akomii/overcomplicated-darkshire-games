package org.example.darkshire.api.model;

import org.example.darkshire.api.enums.Attribute;

import java.util.List;

public interface EventHistory<T extends Enum<T> & Attribute> {
    
    List<Event<T>> getHistory();
    
    void add(Event<T> event);
}