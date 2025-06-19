package ru.nikishechkin.spring_start_here.ch3_ex6_someBeans;

public class Parrot implements Entity {
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
