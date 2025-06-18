package ru.nikishechkin.spring_start_here.ch3_ex9_cyclicDependency_objProvider;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class ProjectConfig {

    // Spring не гарантирует, что бины будут создаваться в том порядке, в котором они объявлены в @Configuration-классе.
    @Bean
    public Parrot parrot(ObjectProvider<Person> person) {
        return new Parrot(person);
    }

    @Bean
    @DependsOn("parrot")
    public Person person(ObjectProvider<Parrot> parrot) {
        return new Person(parrot);
    }
}
