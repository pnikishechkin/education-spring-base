package ru.nikishechkin.spring_start_here.ch3_ex5_cyclicDependency.ex3_not_cyclic_lazy;

import org.springframework.stereotype.Component;

@Component
public class Parrot {
    private String name = "Parrot default name";

    public Parrot() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
