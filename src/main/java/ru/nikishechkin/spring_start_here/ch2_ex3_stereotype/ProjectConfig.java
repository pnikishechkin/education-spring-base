package ru.nikishechkin.spring_start_here.ch2_ex3_stereotype;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "ru.nikishechkin.spring_start_here.ch2_ex3_stereotype")
public class ProjectConfig {

}
