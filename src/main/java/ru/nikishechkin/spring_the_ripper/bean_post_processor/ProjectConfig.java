package ru.nikishechkin.spring_the_ripper.bean_post_processor;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.nikishechkin.spring_the_ripper.bean_post_processor.post_processors.InjectRandomIntAnnotationBeanPostProcessor;
import ru.nikishechkin.spring_the_ripper.bean_post_processor.post_processors.ProfilingHandlerBeanPostProcessor;

@Configuration
public class ProjectConfig {

    // Бины объектов должны создаваться после создания кастомной реализации BeanPostProcessor
    // Решение - сделать его статическим
    @Bean
    static ProfilingHandlerBeanPostProcessor profilingHandlerBeanPostProcessor() throws Exception {
        return new ProfilingHandlerBeanPostProcessor();
    }

    @Bean
    static InjectRandomIntAnnotationBeanPostProcessor injectRandomIntAnnotationBeanPostProcessor() {
        var injectRandomIntAnnotationBeanPostProcessor = new InjectRandomIntAnnotationBeanPostProcessor();
        return injectRandomIntAnnotationBeanPostProcessor;
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    TerminatorQuoter quoter() {
        var p = new TerminatorQuoter();
        p.setMessage("Hello!");
        return p;
    }
}
