package ru.nikishechkin.spring_start_here.ch3_ex5_cyclicDependency.ex4_objectProvider;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name = "Person default name";

    // Не создаём объект parrot сразу, а предоставляем провайдер - механизм ленивого и безопасного доступа к бинам
    // в контейнере IoC. Он позволяет получить бин лениво без прокси.

    // Обеспечивает:
    // - Избегать циклических зависимостей за счёт отложенного получения бинов.
    // - Уменьшать накладные расходы на создание прокси (когда используются @Lazy или @Scope("prototype")).
    // - Работать с бинами, которые могут отсутствовать в контексте (без исключения NoSuchBeanDefinitionException).

    private final ObjectProvider<Parrot> parrot;

    @Autowired
    public Person(ObjectProvider<Parrot> parrot) {
        this.parrot = parrot;
        System.out.print("Person constructor | ");
        try {
            System.out.println(parrot.getIfAvailable().getClass().getName()); // Parrot еще не инициализирован в контексте
        } catch (BeansException e) {
            System.out.println("parrot is not available");
        }
    }

    @PostConstruct
    public void postConstruct() {
        System.out.print("Person postConstruct | ");
        try {
            System.out.println(parrot.getObject().getClass().getName()); // Parrot еще не инициализирован в контексте
        } catch (BeansException e) {
            System.out.println("parrot is not available");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot.getObject();
    }

    public String getParrotName() {
        System.out.println("Parrot className: " + parrot.getObject().getClass().getName());
        String res = parrot.getObject().getName();
        System.out.println("Parrot className: " + parrot.getObject().getClass().getName());
        return res;
    }

    public void setParrotName(String name) {
        parrot.getObject().setName(name);
    }
}
