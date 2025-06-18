package ru.nikishechkin.spring_start_here.ch3_ex5_cyclicDependency.ex5_postConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public Parrot parrot() {
        return new Parrot();
    }

    @Bean
    public Person person() {
        return new Person();
    }
}
