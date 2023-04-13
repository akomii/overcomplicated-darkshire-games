package org.example.potato.rest.test;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
@Getter
class SingletonExample {
    private int count = 0;
    
    public void increment() {
        count++;
    }
}
