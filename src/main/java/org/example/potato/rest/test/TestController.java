package org.example.potato.rest.test;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
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
}
