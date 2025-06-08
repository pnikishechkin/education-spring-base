package ru.nikishechkin.spring_start_here.ch3_ex1_baseBeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
// Используя сканирование, будет создан объект Cat, помеченный как @Component
@ComponentScan(basePackages = "ru.nikishechkin.spring_start_here.ch3_ex1_baseBeans")
public class ProjectConfig {

    // Ручное создание бинов
    @Bean
    Parrot parrot() {
        var p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean(value = "Poko")
    Parrot parrot2() {
        var p = new Parrot();
        p.setName("Poko");
        return p;
    }

    @Bean
    String hello() {
        return "Hello";
    }

    @Bean
    Integer ten() {
        return 10;
    }

    @Bean
    @Primary
    Integer eleven() {
        return 11;
    }
}
