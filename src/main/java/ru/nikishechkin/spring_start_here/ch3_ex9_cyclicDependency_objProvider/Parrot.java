package ru.nikishechkin.spring_start_here.ch3_ex9_cyclicDependency_objProvider;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Parrot {
    private String name = "Parrot default name";

    private final ObjectProvider<Person> person;

    @Autowired
    public Parrot(ObjectProvider<Person> person) {
        this.person = person;
        System.out.print("Parrot constructor | ");
        try {
            System.out.println(person.getIfAvailable()); // Person еще не инициализирован в контексте
        } catch (BeansException e) {
            System.out.println("person is not available");
        }
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Parrot postConstruct start...");
        try {
            System.out.println(person.getObject().getClass().getName()); // Person еще не инициализирован в контексте
        } catch (BeansException e) {
            System.out.println("person is not available");
        }
        System.out.println("Parrot postConstruct finish");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person.getIfAvailable();
    }

}
