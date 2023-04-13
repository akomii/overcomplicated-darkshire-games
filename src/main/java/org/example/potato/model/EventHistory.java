package org.example.potato.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Component
@Scope("application")
@JacksonXmlRootElement(localName = "eventHistory")
public class EventHistory {
    
    @JacksonXmlProperty(localName = "event")
    @JacksonXmlElementWrapper(useWrapping = false)
    final List<Event> history = new LinkedList<>();
    
    public void add(Event event) {
        history.add(event);
    }
}
