package com.wsbo.demo.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private Animal animal;

    @GetMapping("/bark")
    public String bark() {
        return animal.bark();
    }
}
