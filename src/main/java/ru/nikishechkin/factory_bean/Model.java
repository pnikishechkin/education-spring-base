package ru.nikishechkin.factory_bean;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class Model implements InitializingBean {
    private Integer value = 5;

    public Model() {
        System.out.println("Model constructor");
    }

    // Не вызовется, потому что Spring делегирует создание бина фабрике, а не стандартному контейнеру
    // Т.о., ответственность за инициализацию полностью ложится на FactoryBean
    @PostConstruct
    public void initMethod() {
        System.out.println("Model post-constructor");
    }

    // Также не будет вызван
    // Если Spring управляет созданием бина, то вызовется после PostConstruct если бин реализует InitializingBean
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Model afterPropertiesSet");
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
