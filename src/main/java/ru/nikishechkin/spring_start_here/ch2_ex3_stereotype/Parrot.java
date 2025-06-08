package ru.nikishechkin.spring_start_here.ch2_ex3_stereotype;

import org.springframework.stereotype.Component;

@Component
public class Parrot {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
