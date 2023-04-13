package org.example.potato.rest.test;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
@Getter
class PrototypeExample {
    private int count = 0;
    
    public void increment() {
        count++;
    }
}
