package org.example.darkshire.potato.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.darkshire.api.enums.Attribute;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum PotatoAttribute implements Attribute {
    
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
