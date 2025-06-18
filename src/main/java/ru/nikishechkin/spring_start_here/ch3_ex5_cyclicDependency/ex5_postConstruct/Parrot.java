package ru.nikishechkin.spring_start_here.ch3_ex5_cyclicDependency.ex5_postConstruct;

import org.springframework.stereotype.Component;

@Component
public class Parrot {
    private String name = "Parrot default name";

    private Person person;

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
