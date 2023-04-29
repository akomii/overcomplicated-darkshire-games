package org.example.darkshire.potato.enums;

import lombok.RequiredArgsConstructor;
import org.example.darkshire.api.enums.GameAttribute;

@RequiredArgsConstructor
public enum PotatoAttribute implements GameAttribute {
    
    DESTINY("destiny"),
    POTATOES("potatoes"),
    ORCS("orcs"),
    REMOVECOST("removeCost");
    
    private final String name;
    
    @Override
    public String getName() {
        return name;
    }
}
