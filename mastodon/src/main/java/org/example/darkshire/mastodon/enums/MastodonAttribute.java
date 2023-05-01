package org.example.darkshire.mastodon.enums;

import lombok.RequiredArgsConstructor;
import org.example.darkshire.api.enums.GameAttribute;

@RequiredArgsConstructor
public enum MastodonAttribute implements GameAttribute {
    
    CONFUSION("confusion"),
    DAMAGES("damages"),
    THINKING("thinking");
    
    private final String name;
    
    @Override
    public String getName() {
        return name;
    }
}
