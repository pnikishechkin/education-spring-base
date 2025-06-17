package ru.nikishechkin.spring_start_here.ch3_ex7_cyclicDependency_lazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Parrot {
    private String name = "Parrot default name";

    private final Person person;

    @Autowired
    public Parrot(Person person) {
        this.person = person;
        System.out.println("Parrot created with Person className: " + person.getClass().getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

}
