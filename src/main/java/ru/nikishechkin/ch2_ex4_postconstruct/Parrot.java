package ru.nikishechkin.ch2_ex4_postconstruct;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Parrot {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void init() {
        System.out.println("Init parrot");
        name = "Post-parrot";
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Destroy parrot");
    }
}
