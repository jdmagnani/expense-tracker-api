package com.pairlearning.expensetrackerapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * By default spring uses the concept of singleton design pattern
 */

@Component
@Scope(value = "prototype")
public class Alien {

    private int id;
    private String name;

    @Autowired
    @Qualifier("lap1")
    private Laptop laptop;

    public Alien() {
        System.out.println("object created ...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("in show...");
        laptop.compile();
    }

}
