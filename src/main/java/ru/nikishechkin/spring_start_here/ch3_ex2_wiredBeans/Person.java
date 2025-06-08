package ru.nikishechkin.spring_start_here.ch3_ex2_wiredBeans;

public class Person {
    private String name = "Person default name";

    private Parrot parrot;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }
}
