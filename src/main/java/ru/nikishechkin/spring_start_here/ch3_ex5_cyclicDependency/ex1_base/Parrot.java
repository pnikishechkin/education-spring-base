package ru.nikishechkin.spring_start_here.ch3_ex5_cyclicDependency.ex1_base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Parrot {
    private String name = "Parrot default name";

    private final Person person;

    @Autowired
    public Parrot(Person person) {
        this.person = person;
        System.out.println("Parrot created");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
