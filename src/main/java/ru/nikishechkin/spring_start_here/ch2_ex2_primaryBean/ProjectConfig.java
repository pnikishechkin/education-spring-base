package ru.nikishechkin.spring_start_here.ch2_ex2_primaryBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean("koko")
    @Primary
    Parrot parrot() {
        var p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean("mimi")
    Parrot parrot2() {
        var p = new Parrot();
        p.setName("Mimi");
        return p;
    }
}
