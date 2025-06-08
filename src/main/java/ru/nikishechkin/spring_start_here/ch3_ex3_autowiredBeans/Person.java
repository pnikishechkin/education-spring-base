package ru.nikishechkin.spring_start_here.ch3_ex3_autowiredBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name = "Person default name";

    // Команда для Spring внедрить значение, полученное из контекста
    // Минусы: нельзя пометить как final; при инициализации приходится самостоятельно управлять значением
    @Autowired
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
