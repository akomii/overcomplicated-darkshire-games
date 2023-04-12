package org.example.potato.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
@Scope("application")
@JacksonXmlRootElement
public class EventHistory {
    
    private final List<Event> history = new LinkedList<>();
    
    public void add(Event event) {
        history.add(event);
    }
}
