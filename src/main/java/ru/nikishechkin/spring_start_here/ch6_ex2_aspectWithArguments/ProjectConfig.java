package ru.nikishechkin.spring_start_here.ch6_ex2_aspectWithArguments;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {
        "ru.nikishechkin.spring_start_here.ch6_ex2_aspectWithArguments",
        "ru.nikishechkin.spring_start_here.ch6_ex2_aspectWithArguments.services"
})
@EnableAspectJAutoProxy
public class ProjectConfig {
}
