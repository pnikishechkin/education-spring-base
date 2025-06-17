package ru.nikishechkin.spring_start_here.ch3_ex7_cyclicDependency_lazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name = "Person default name";

    private final Parrot parrot;

    // Внедрение зависимости через конструктор
    // @Autowired - можно не писать, если только один конструктор
    // @Lazy - ленивая инициализация - бин будет полностью создан только тогда, когда понадобится
    //
    @Autowired
    public Person(@Lazy Parrot parrot) {
        this.parrot = parrot;
        System.out.println("Person created with Parrot className: " + parrot.getClass().getName());
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
        String res = parrot.getName();
        System.out.println("Parrot className: " + parrot.getClass().getName());
        return res;
    }

    public void setParrotName(String name) {
        parrot.setName(name);
    }
}
