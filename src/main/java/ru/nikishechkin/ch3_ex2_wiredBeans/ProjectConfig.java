package ru.nikishechkin.ch3_ex2_wiredBeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {


    @Bean
    public Parrot parrot() {
        Parrot p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean
    public Person person(Parrot parrot) { // передавая параметр, Spring вытащит объект из контекста
        Person p = new Person();
        p.setName("Ella");
        p.setParrot(parrot);

        // p.setParrot(parrot()); // Другой способ - внедрится экземпляр объекта из контекста (если нет - создастся)

        return p;
    }

}
