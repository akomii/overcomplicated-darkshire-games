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
import org.example.darkshire.api.model.EventHistory;

import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JacksonXmlRootElement(localName = "eventHistory")
public class EventHistoryImpl<T extends Enum<T> & Attribute> implements EventHistory<T> {
    
    @JacksonXmlProperty(localName = "event")
    @JacksonXmlElementWrapper(useWrapping = false)
    @Getter
    final List<Event<T>> history = new LinkedList<>();
    
    @Override
    public void add(Event<T> event) {
        history.add(event);
    }
}
