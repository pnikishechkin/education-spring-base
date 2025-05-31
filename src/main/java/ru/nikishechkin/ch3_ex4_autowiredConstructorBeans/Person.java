package ru.nikishechkin.ch3_ex4_autowiredConstructorBeans;

import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name = "Person default name";

    private final Parrot parrot;

    // Внедрение зависимости через конструктор
    // @Autowired - можно и не писать, если только один конструктор
    public Person(Parrot parrot) {
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

    // Другой вариант - через сеттер. Аннотация @Autowired обязательна
//    @Autowired
//    public void setParrot(Parrot parrot) {
//        this.parrot = parrot;
//    }
}
