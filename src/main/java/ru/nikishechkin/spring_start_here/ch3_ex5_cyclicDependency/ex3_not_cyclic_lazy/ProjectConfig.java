package ru.nikishechkin.spring_start_here.ch3_ex5_cyclicDependency.ex3_not_cyclic_lazy;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "ru.nikishechkin.spring_start_here.ch3_ex5_cyclicDependency.ex3_not_cyclic_lazy")
public class ProjectConfig {

}
