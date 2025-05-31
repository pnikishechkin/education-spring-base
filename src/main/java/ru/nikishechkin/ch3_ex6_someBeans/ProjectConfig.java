package ru.nikishechkin.ch3_ex6_someBeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "ru.nikishechkin.ch3_ex6_someBeans")
public class ProjectConfig {

    // Создаем 2 бина с разными названиями

    @Primary // основной бин по умолчанию
    @Bean
    public Parrot parrot() {
        Parrot p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean("mainParrot") // можем найти бин по имени
    public Parrot parrot2() {
        Parrot p = new Parrot();
        p.setName("Popo");
        return p;
    }

}
