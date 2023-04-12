package org.example.potato.rest;

import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

@RestController("/test")
public class TestController {
    
    @Autowired
    private SingletonExample singletonExample;
    
    @Autowired
    private PrototypeExample prototypeExample;
    
    @Autowired
    private RequestExample requestExample;
    
    @Autowired
    private SessionExample sessionExample;
    
    @GetMapping("/singleton")
    public String singleton() {
        singletonExample.increment();
        return "Singleton count: " + singletonExample.getCount();
    }
    
    @GetMapping("/prototype")
    public String prototype() {
        prototypeExample.increment();
        return "Prototype count: " + prototypeExample.getCount();
    }
    
    @GetMapping("/request")
    public String request() {
        requestExample.increment();
        return "Request count: " + requestExample.getCount();
    }
    
    @GetMapping("/session")
    public String session(HttpSession httpSession) {
        sessionExample.increment(httpSession.getId());
        return "Session count: " + sessionExample.getCount(httpSession.getId());
    }
    
    @Service
    @Scope("singleton")
    @Getter
    class SingletonExample {
        private int count = 0;
        
        public void increment() {
            count++;
        }
    }
    
    @Service
    @Scope("prototype")
    @Getter
    class PrototypeExample {
        private int count = 0;
        
        public void increment() {
            count++;
        }
    }
    
    @Component
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    @Getter
    class RequestExample {
        private int count = 0;
        
        public void increment() {
            count++;
        }
    }
    
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
}