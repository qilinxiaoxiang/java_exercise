package com.wsbo.demo.aop;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {

    @Override
    public String bark() {
        return "woof";
    }
}
