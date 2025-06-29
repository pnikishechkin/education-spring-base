package ru.nikishechkin.spring_start_here.ch3_ex5_cyclicDependency.ex4_setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Parrot {
    private String name = "Parrot default name";

    private Person person;

    @Autowired
    public void setPerson(Person person) {
        this.person = person;
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
