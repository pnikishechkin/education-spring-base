package ru.nikishechkin.factory_bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    public PrefixStringFactoryBean greeting() {
        PrefixStringFactoryBean factory = new PrefixStringFactoryBean();
        factory.setPrefix("Hello, ");
        factory.setValue("World");
        return factory;
    }

    @Bean
    public BaseService greetingService() {
        return new BaseService();
    }
}
