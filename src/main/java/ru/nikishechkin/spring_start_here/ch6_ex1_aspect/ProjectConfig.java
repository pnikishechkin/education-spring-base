package ru.nikishechkin.spring_start_here.ch6_ex1_aspect;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {
        "ru.nikishechkin.spring_start_here.ch6_ex1_aspect",
        "ru.nikishechkin.spring_start_here.ch6_ex1_aspect.services"
})
@EnableAspectJAutoProxy
public class ProjectConfig {
}
