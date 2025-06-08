package ru.nikishechkin.factory_bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseService {
    @Autowired
    private String greeting; // Получаем бин, который будет создан через FactoryBean и выполнится дополнительная логика при создании

    public void print() {
        System.out.println(greeting);
    }
}
