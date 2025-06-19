package ru.nikishechkin.factory_bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// @ComponentScan(basePackages = "ru.nikishechkin.factory_bean")
public class ProjectConfig {
    @Bean
    public PrefixStringFactoryBean greeting() {
        PrefixStringFactoryBean factory = new PrefixStringFactoryBean();
        factory.setPrefix("Hello, ");
        factory.setValue("World");
        return factory;
    }

    @Bean
    public ModelFactory factoryBeanModel() {
        ModelFactory factory = new ModelFactory();
        factory.setDelta(3);
        return factory;
    }

    @Bean
    public BaseService greetingService(Model model) {
        return new BaseService(model);
    }
}
