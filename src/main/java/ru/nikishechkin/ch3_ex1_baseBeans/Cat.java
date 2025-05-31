package ru.nikishechkin.ch3_ex1_baseBeans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component // стереотипная аннотация
public class Cat {
    private String name;

    public Cat() {
        System.out.println("Cat: phase 1 (constructor)");
    }

    @PostConstruct // двухфазный конструктор
    public void init() {
        System.out.println("Cat: phase 2 (init method)");
        this.name = "Murka";
    }

    @PreDestroy // вызывается перед закрытием и очисткой контекста
    public void destroy() {
        System.out.println("Cat: destroy");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
