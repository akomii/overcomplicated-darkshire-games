package org.example.darkshire.common.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.darkshire.api.enums.GameAttribute;
import org.example.darkshire.api.model.Event;
import org.example.darkshire.api.model.EventHistory;

import java.util.LinkedList;
import java.util.List;

//TODO checkRest
@NoArgsConstructor
@JacksonXmlRootElement(localName = "eventHistory")
public class EventHistoryImpl<T extends Enum<T> & GameAttribute> implements EventHistory<T> {
    
    @JacksonXmlProperty(localName = "event")
    @JacksonXmlElementWrapper(useWrapping = false)
    @Getter
    private final List<Event<T>> history = new LinkedList<>();
    
    @Override
    public void add(Event<T> event) {
        history.add(event);
    }
}
