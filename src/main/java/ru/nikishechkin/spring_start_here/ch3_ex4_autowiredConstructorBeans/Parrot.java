package ru.nikishechkin.spring_start_here.ch3_ex4_autowiredConstructorBeans;

import org.springframework.stereotype.Component;

@Component
public class Parrot {
    private String name = "Parrot default name";

    public Parrot() {
        System.out.println("Parrot created");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
