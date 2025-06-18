package ru.nikishechkin.spring_start_here.ch3_ex10_cyclicDependency_setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name = "Person default name";

    private Parrot parrot;

    @Autowired
    public void setParrot(Parrot parrot) {
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

    public String getParrotName() {
        System.out.println("Parrot className: " + parrot.getClass().getName());
        return parrot.getName();
    }

    public void setParrotName(String name) {
        parrot.setName(name);
    }
}
