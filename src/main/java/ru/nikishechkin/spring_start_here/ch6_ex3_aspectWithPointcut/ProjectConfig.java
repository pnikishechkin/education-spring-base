package ru.nikishechkin.spring_start_here.ch6_ex3_aspectWithPointcut;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {
        "ru.nikishechkin.spring_start_here.ch6_ex3_aspectWithPointcut",
        "ru.nikishechkin.spring_start_here.ch6_ex3_aspectWithPointcut.services"
})
@EnableAspectJAutoProxy
public class ProjectConfig {
}
