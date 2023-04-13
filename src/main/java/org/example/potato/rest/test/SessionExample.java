package org.example.potato.rest.test;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
class SessionExample {
    private Map<String, Integer> counts = new HashMap<>();
    
    public void increment(String sessionId) {
        counts.compute(sessionId, (k, v) -> (v == null) ? 1 : v + 1);
    }
    
    public int getCount(String sessionId) {
        return counts.getOrDefault(sessionId, 0);
    }
}
