package ru.nikishechkin.spring_start_here.ch3_ex9_cyclicDependency_objProvider;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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
