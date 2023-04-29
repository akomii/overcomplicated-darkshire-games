package org.example.darkshire.common.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.darkshire.api.enums.Attribute;
import org.example.darkshire.api.model.Event;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
@JacksonXmlRootElement(localName = "eventHistory")
public class EventHistory<T extends Enum<T> & Attribute> {
    
    @JacksonXmlProperty(localName = "event")
    @JacksonXmlElementWrapper(useWrapping = false)
    @Getter
    final List<Event<T>> history = new LinkedList<>();
    
    public void add(Event<T> event) {
        history.add(event);
    }
}
