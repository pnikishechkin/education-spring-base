package ru.nikishechkin.spring_start_here.ch3_ex5_cyclicDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name = "Person default name";

    private final Parrot parrot;

    // Внедрение зависимости через конструктор
    // @Autowired - можно не писать, если только один конструктор
    @Autowired
    public Person(Parrot parrot) {
        this.parrot = parrot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }

}
